package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controll.BF;
import controll.DB;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class JobInfo extends BF {
	private JPanel contentPane;

	private JPanel panel;

	private JLabel infoLabel = new JLabel();
	private JLabel mapLabel;
	private JScrollPane scrollPane;
	private int jno = 1;
	private JLabel label;
	private JPanel panel_1;
	private JLabel label_1;
	private JButton button;
	private boolean isFill;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JobInfo frame = new JobInfo(1);
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
	public JobInfo(int jno) {
		setTitle("\uC54C\uBC14\uC815\uBCF4");
		this.jno = jno;
		setDefaultCloseOperation(2);
		setBounds(100, 100, 368, 507);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 95, 321, 278);
		contentPane.add(scrollPane);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		panel.setPreferredSize(new java.awt.Dimension(300, 275 * 2));
		
		label = new JLabel("New label");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		label.setBounds(12, 0, 303, 72);
		contentPane.add(label);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 0));
		panel_1.setBounds(12, 87, 321, 9);
		contentPane.add(panel_1);
		
		label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(!isFill) {
						label_1.setIcon(getImageString("./datafiles/icon/하트1.PNG", 50, 50));
						DB.stmt.execute("insert likes values(0, "+jno+", '"+LocalDate.now().toString()+"', "+uno+");");
					}else {
						DB.stmt.execute("delete from likes where  uno = "+uno+" and jno = "+jno+";");
						label_1.setIcon(getImageString("./datafiles/icon/하트2.PNG", 50, 50));
					}
					
					isFill = !isFill;
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(19, 390, 62, 54);
		contentPane.add(label_1);
		
		button = new JButton("\uC9C0\uC6D0\uD558\uAE30 \u2192");
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(255, 128, 0));
		button.setBounds(201, 397, 130, 47);
		contentPane.add(button);
		setScroll();
	}
	@Override
	public void setUI() {
		setScroll();
	}

	private void setScroll() {

		infoLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		infoLabel.setBounds(10, 0, 300, 275);
		panel.add(infoLabel);
		try (var rs = DB.stmt.executeQuery("SELECT * FROM job join brand b using(bno) where jno = "+jno+";")) {
			while (rs.next()) {
				label.setText("<html>" + rs.getString("jname"));
				infoLabel.setText("<html>[근무조건]<br>급여: " + String.format("%,d원", rs.getInt("jmoney")) + "<br>근무요일: 주 "
						+ rs.getString("jday") + "회<br>근무시간: " + rs.getString("jtime") + "시간<br>고용형태: "
						+ (rs.getBoolean("jwork") ? "계약직" : "정규직") + "<br><br>" + "[모집조건]<br>지원자격: "
						+ (rs.getInt("jgrade") == 0 ? "무관" : rs.getInt("jgrade") == 1 ? "대학" : "고등") + "<br>모집인원: "
						+ rs.getInt("jpeople") + "명<br><br>" + "[기업정보]<br>" + rs.getString("bname") + "<br>" + "▽위치보기");
				int x = rs.getInt("bxx") / 2, y = rs.getInt("byy") / 2;
				mapLabel = new JLabel() {
					@Override
					protected void paintComponent(Graphics g) {

						super.paintComponent(g);
						g.setColor(Color.red);
						g.fillOval(x, y, 10, 10);
					}
				};
				mapLabel.setBounds(0, 275, 300, 275);
				mapLabel.setIcon(new ImageIcon(new ImageIcon("./datafiles/지도.PNG").getImage().getScaledInstance(300,
						275, Image.SCALE_SMOOTH)));
				panel.add(mapLabel);
			}
			var rs1 =  DB.stmt.executeQuery("select li.* from user join likes li using(uno) where uno = "+uno+" and jno = "+jno+";");
			isFill = rs1.next();
			if(isFill) {
				label_1.setIcon(getImageString("./datafiles/icon/하트1.PNG", 50, 50));
			}else {
				label_1.setIcon(getImageString("./datafiles/icon/하트2.PNG", 50, 50));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
