package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;

import controll.BF;
import controll.DB;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Random;

public class Main extends BF {
	private JLabel label = new JLabel("");
	private JLabel label_1 = new JLabel("\uC54C\uBC14\uCEA3");
	private JPanel panel = new JPanel();
	private JLabel label_2 = new JLabel("\uCC44\uC6A9");
	private JLabel label_3 = new JLabel("\uBE0C\uB79C\uB4DC");
	private JLabel label_4 = new JLabel("\uCC3E\uAE30");
	private JLabel label_5 = new JLabel("\uB9C8\uC774\uD398\uC774\uC9C0");
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JLabel label_6 = new JLabel("\uC778\uAE30 \uBE0C\uB79C\uB4DC TOP 5");
	private final JLabel top = new JLabel("");
	private final JLabel top_1 = new JLabel("");
	private final JLabel top_2 = new JLabel("");
	private final JLabel top_3 = new JLabel("");
	private final JLabel top_4 = new JLabel("");
	private final JLabel label_7 = new JLabel("");
	Thread th;
	private final JLabel label_6_1 = new JLabel("\uCD94\uCC9C \uC54C\uBC14");
	private final JLabel cl = new JLabel("");
	private final JLabel cl_1 = new JLabel("");
	private final JLabel cl_2 = new JLabel("");
	private final JLabel cl_3 = new JLabel("");
	private final JLabel cl_4 = new JLabel("");
	private final JLabel cl_5 = new JLabel("");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setTitle("\uBA54\uC778");
		setBounds(100, 100, 800, 680);
		setDefaultCloseOperation(2);
		getContentPane().setLayout(null);
		label.setBounds(0, 0, 79, 74);

		getContentPane().add(label);

		addLogo(label);
		label_1.setBounds(85, 27, 85, 35);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(255, 128, 0));
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));

		getContentPane().add(label_1);
		panel.setBounds(0, 84, 784, 40);
		panel.setBackground(new Color(255, 128, 0));

		getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));

		panel.add(label_2);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));

		panel.add(label_3);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));

		panel.add(label_4);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));

		panel.add(label_5);
		panel_1.setBounds(25, 134, 493, 137);
		
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		label_6.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		label_6.setBounds(12, 10, 372, 20);
		
		panel_1.add(label_6);
		top.setBounds(20, 52, 74, 75);
		
		panel_1.add(top);
		top_1.setBounds(114, 52, 74, 75);
		
		panel_1.add(top_1);
		top_2.setBounds(208, 52, 74, 75);
		
		panel_1.add(top_2);
		top_3.setBounds(302, 52, 74, 75);
		
		panel_1.add(top_3);
		top_4.setBounds(396, 52, 74, 75);
		
		panel_1.add(top_4);
		panel_2.setBounds(530, 134, 226, 137);
		
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(0, 0, 226, 137);
		
		panel_2.add(label_7);
		panel_3.setBounds(20, 281, 752, 350);
		
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		label_6_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		label_6_1.setBounds(12, 22, 372, 20);
		
		panel_3.add(label_6_1);
		cl.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		cl.setOpaque(true);
		cl.setBackground(new Color(255, 255, 255));
		cl.setBorder(new LineBorder(new Color(255, 128, 0)));
		cl.setHorizontalAlignment(SwingConstants.LEFT);
		cl.setBounds(38, 67, 177, 120);
		
		panel_3.add(cl);
		cl_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		cl_1.setOpaque(true);
		cl_1.setBackground(new Color(255, 255, 255));
		cl_1.setHorizontalAlignment(SwingConstants.LEFT);
		cl_1.setBorder(new LineBorder(new Color(255, 128, 0)));
		cl_1.setBounds(284, 67, 177, 120);
		
		panel_3.add(cl_1);
		cl_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		cl_2.setOpaque(true);
		cl_2.setBackground(new Color(255, 255, 255));
		cl_2.setHorizontalAlignment(SwingConstants.LEFT);
		cl_2.setBorder(new LineBorder(new Color(255, 128, 0)));
		cl_2.setBounds(538, 67, 177, 120);
		
		panel_3.add(cl_2);
		cl_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		cl_3.setOpaque(true);
		cl_3.setBackground(new Color(255, 255, 255));
		cl_3.setHorizontalAlignment(SwingConstants.LEFT);
		cl_3.setBorder(new LineBorder(new Color(255, 128, 0)));
		cl_3.setBounds(38, 201, 177, 120);
		
		panel_3.add(cl_3);
		cl_4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		cl_4.setOpaque(true);
		cl_4.setBackground(new Color(255, 255, 255));
		cl_4.setHorizontalAlignment(SwingConstants.LEFT);
		cl_4.setBorder(new LineBorder(new Color(255, 128, 0)));
		cl_4.setBounds(284, 197, 177, 120);
		
		panel_3.add(cl_4);
		cl_5.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		cl_5.setOpaque(true);
		cl_5.setBackground(new Color(255, 255, 255));
		cl_5.setHorizontalAlignment(SwingConstants.LEFT);
		cl_5.setBorder(new LineBorder(new Color(255, 128, 0)));
		cl_5.setBounds(538, 197, 177, 120);
		
		panel_3.add(cl_5);
		b();
		c();
		d();
	}

	private void d() {
		JLabel cls[] = new JLabel[] {cl, cl_1, cl_2, cl_3, cl_4, cl_5};
		try (var rs = DB.stmt.executeQuery("select job.* from job join brand b  using(bno) where b.cno = (SELECT cno FROM apply ap join job j using(jno) join brand b using(bno) where uno = "+uno+" order by apdate desc limit 1) order by Rand() limit 6;")) {
			int i;
			for (i = 0; rs.next(); i++) {
				cls[i].setText("<html>" + rs.getString("jname") + "<br><br>[ÁÖ " + rs.getString("jday") + "ÀÏ, " + rs.getString("jtime") + "½Ã°£" +(rs.getInt("jgrade") == 0 ? "¹«°ü" : rs.getInt("jgrade") == 1 ? "´ëÇÐ" : "°íµî") +"]<br>½Ã±Þ: "+String.format("%,d¿ø", rs.getInt("jmoney")));
				int jno = rs.getInt("jno");
				cls[i].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						openForm(Main.this, new JobInfo(jno));
						
					}
				});
			}
			if(i == 0) {
				var rs1 =  DB.stmt.executeQuery("SELECT j.* FROM apply ap join job j using(jno) join brand b using(bno) group by bno order by count(*) desc limit 6;");
				for (i = 0; rs1.next(); i++) {
					cls[i].setText("<html>" + rs1.getString("jname") + "<br><br>[ÁÖ " + rs1.getString("jday") + "ÀÏ, " + rs1.getString("jtime") + "½Ã°£" +(rs1.getInt("jgrade") == 0 ? "¹«°ü" : rs1.getInt("jgrade") == 1 ? "´ëÇÐ" : "°íµî") +"]<br>½Ã±Þ: "+String.format("%,d¿ø", rs1.getInt("jmoney")));
					int jno = rs1.getInt("jno");
					cls[i].addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							openForm(Main.this, new JobInfo(jno));
							
						}
					});
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void c() {
		  final int[] xx = {0}; 
		    Random r = new Random();

		    th = new Thread(() -> {
		        try {
		            while (true) {
		                xx[0] = r.nextInt(200);
		                label_7.setIcon(getImageString("./datafiles/advertise/"+xx[0]+"-1.JPG", label_7.getWidth(), label_7.getHeight()));
		                Thread.sleep(2000);
		            }
		        } catch (InterruptedException e) {
		        }
		    });
		    th.start();

		    label_7.addMouseListener(new MouseAdapter() {
		        @Override
		        public void mouseClicked(MouseEvent e) {
		            openForm(Main.this, new AdInfo(xx[0]));
		            Main.this.setEnabled(false);
		        }
		    });
	}

	private void b() {
		JLabel lbs[] = new JLabel[] {top, top_1, top_2, top_3, top_4};
		try (var rs = DB.stmt.executeQuery("select b.* from apply ap join job j using(jno) join brand b using(bno) group by bno order by count(bno) desc, bno limit 5")) {
			for (int i = 0; rs.next(); i++) {
				lbs[i].setIcon(getImageString("./datafiles/brand/"+rs.getInt("bno")+".png", lbs[i].getWidth(), lbs[i].getHeight()));
				lbs[i].setBorder(new LineBorder(Color.black));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
