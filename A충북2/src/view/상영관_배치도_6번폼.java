package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class 상영관_배치도_6번폼 extends JFrame {

	JPanel contentPane;
	JPanel panel;
	
	int[][] map = new int[9][9]; // 상영관 배치도 배열
	int[][] prev = new int[9][9]; // 상영관 배치도 배열
	int[] xdir = {0, 1, 0, -1}; // x방향 배열
	int[] ydir = {1, 0, -1, 0}; // y방향 배열
	boolean[][] visited = new boolean[9][9]; // 방문 배열
	JPanel[][] jps = new JPanel[9][9]; // 화면 표시 배열
	int[] srmnos= new int[6]; // 상영관 번호의 인덱스
	
	public static void main(String[] args) {
		상영관_배치도_6번폼 frame = new 상영관_배치도_6번폼(6); // 예시데이터 : 3관으로 가기
		frame.setVisible(true);
	}

	public 상영관_배치도_6번폼(int srmno) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 625);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 9, 0, 0));
		
		getData();
		addPanels();
		FindRoute(srmno);
	}

	private void FindRoute(int srmno) {
		for (int i = 0; i < 9; i++) {
			Arrays.fill(prev[i], -1);
		}
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(72);
		visited[8][0] = true;
		
		int to = srmnos[srmno-1];
		while(!queue.isEmpty()) {
			int current = queue.poll();
			int row = current / 9, col = current % 9;
			
			if(current==to) break;
			
			for (int i = 0; i < 4; i++) {
				int nextR = row + ydir[i];
				int nextC = col + xdir[i];
				
				if (nextC < 0 || nextR < 0 || nextC >= 9 || nextR >= 9 || map[nextR][nextC] == 1 || visited[nextR][nextC]) continue;
				
				queue.add(nextR*9+nextC);
				prev[nextR][nextC] = current;
				visited[nextR][nextC] = true;
			}
		}
		
		int p = to;
		List<Integer> prevList = new ArrayList<>();
		
		while(p!=72) {
			int row = p / 9, col = p % 9;
			p = prev[row][col];
			prevList.add(0, p);
		}
		
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i < prevList.size(); i++) {
					int point = prevList.get(i);
					int row = point / 9, col = point % 9;
					jps[row][col].setBackground(Color.red);
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int i = 1; i < prevList.size(); i++) {
					int point = prevList.get(i);
					int row = point / 9, col = point % 9;
					for (int j = 0; j < 5; j++) {
						jps[row][col].setBackground(j%2==0? Color.red : Color.white);
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				JOptionPane.showMessageDialog(null, srmno+"관에 도착했습니다.", "정보", 1);
			}
		});
		th.start();
		
	}

	private void addPanels() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				jps[i][j] = new JPanel();
				jps[i][j].setBorder(new LineBorder(Color.black));
				jps[i][j].setBackground(getColor(map[i][j]));
				panel.add(jps[i][j]);
			}
		}
	}

	private Color getColor(int type) {
		return type==0? Color.white : type == 1? Color.gray : type==2? Color.BLUE : Color.green;
	}

	private void getData() {
		try (var rs = Connect.res("select * from srm")) {
			for (int i = 0; rs.next(); i++) {
				map[i/9][i%9] = rs.getInt(2);
				if(rs.getBoolean(3)) srmnos[rs.getInt(3)-1] = i;
			}
		} catch (SQLException e) {
		}
	}
}
