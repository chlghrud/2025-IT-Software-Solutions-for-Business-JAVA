package 요소들;

import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class _3번스크롤 extends JFrame {

	private JPanel contentPane;
	
	private JPanel panel;
	
	private JLabel infoLabel = new JLabel();
	private JLabel mapLabel;
	
	public static Statement stmt;
	public static Connection con;
	private JScrollPane scrollPane;
	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost?serverTimezone=UTC&allowLoadLocalInfile=true", "root", "1234");
			stmt = con.createStatement();
			stmt.execute("use parttimecat;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_3번스크롤 frame = new _3번스크롤(1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public _3번스크롤(int Jno) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 536);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 120, 321, 278);
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		panel.setPreferredSize(new java.awt.Dimension(300, 275 * 2));
		setScroll();
		
	}


	private void setScroll() {
		
		infoLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		infoLabel.setBounds( 10, 0,300, 275);
		panel.add(infoLabel);
		try (var rs = stmt.executeQuery("SELECT * FROM job join brand b using(bno) where jno = 1;")) {
			while (rs.next()) {
				infoLabel.setText("<html>[근무조건]<br>급여: "+String.format("%,d원", rs.getInt("jmoney"))+"<br>근무요일: 주 "+rs.getString("jday")
						+"회<br>근무시간: "+rs.getString("jtime")+"시간<br>고용형태: "+(rs.getBoolean("jwork") ? "계약직" : "정규직")+"<br><br>" +
				        "[모집조건]<br>지원자격: "+(rs.getInt("jgrade") == 0 ? "무관" : rs.getInt("jgrade") == 1 ? "대학" : "고등")+"<br>모집인원: "+rs.getInt("jpeople")+"명<br><br>" +
				        "[기업정보]<br>"+rs.getString("bname")+"<br>" +
				        "▽위치보기");
				int x = rs.getInt("bxx")/2, y = rs.getInt("byy")/2;
				mapLabel = new JLabel() {
					@Override
					protected void paintComponent(Graphics g) {
						
						super.paintComponent(g);
						g.setColor(Color.red);
						g.fillOval(x, y, 10, 10);
					}
				};
				mapLabel.setBounds( 0, 275, 300, 275);
				mapLabel.setIcon(new ImageIcon(new ImageIcon("./datafiles/지도.PNG").getImage().getScaledInstance(300, 275, Image.SCALE_SMOOTH)));
				panel.add(mapLabel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
