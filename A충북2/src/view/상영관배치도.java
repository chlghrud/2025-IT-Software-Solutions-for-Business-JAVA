package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import tools.BF;
import tools.Model;

public class 상영관배치도 extends BF {

	private JPanel panel;
	private int[][] map;
	private int[] srmnos = new int[6];
	private JPanel[][] jps = new JPanel[9][9];
	private boolean[][] visited = new boolean[9][9];
	private int[][] prev = new int[9][9];
	int[] xdir = {0, 1, 0, -1};
	int[] ydir = {1, 0, -1, 0};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					상영관배치도 frame = new 상영관배치도();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public 상영관배치도() {
		setBounds(100, 100, 602, 625);

		getContentPane().setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(9, 9, 0, 0));
	}

	private void find(int srmno) {
		for (int i = 0; i < 9; i++) {
			Arrays.fill(prev[i], -1);
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(72);
		visited[8][0] = true;
		
		int to = srmnos[srmno - 1];
		while (!queue.isEmpty()) {
			int current = queue.poll();
			int row = current / 9, col = current % 9;
			if(current == to) break;
			for (int i = 0; i < 4; i++) {
				int nextR = row + ydir[i];
				int nextc = row + xdir[i];
			}
		}
	}

	@Override
	public void control() {
		try (var rs = Model.stmt.executeQuery("select * from srm")) {
			for (int i = 0; rs.next(); i++) {
				map[i / 9][i % 9] = rs.getInt(2);
				if (rs.getBoolean(3))
					srmnos[rs.getInt(3) - 1] = i;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
		return type == 0 ? Color.white : type == 1 ? Color.gray : type == 2 ? Color.BLUE : Color.green;
	}
}
