package 경남2요소;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class _8_3번확대 extends JFrame {

	private JPanel contentPane;
	public static Statement stmt;
	public static Connection con;
	private JPanel panel;
	private JLabel map;
	ArrayList<Point> points = new ArrayList<Point>();
	Point ClPoint = null;
	double scale = 1.0;
	Image bgImg;
	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost?serverTimezone=UTC&allowLoadLocalInfile=true",
					"root", "1234");
			stmt = con.createStatement();
			stmt.execute("use parttimecat;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_8_3번확대 frame = new _8_3번확대();
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
	public _8_3번확대() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 615);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(600, 550));
		panel.setBounds(12, 10, 603, 556);
		contentPane.add(panel);
		panel.setLayout(null);
		try {
			setMap();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void startZoom() {
		new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scale += 0.05;
				if (scale >= 9.0) {
					((Timer) e.getSource()).stop();

				}
				repaint();
			}
		}).start();

	}

	private void setMap() throws IOException {
		try (var rs = stmt.executeQuery("SELECT * FROM brand join category using(cno);")) {
			while (rs.next()) {
				points.add(new Point(rs.getInt("bxx"), rs.getInt("byy")));

			}

			map = new JLabel() {
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);

					Graphics2D g2 = (Graphics2D) g.create();
					
					if (ClPoint != null) {
						g2.translate(map.getWidth() / 2.0 - scale * ClPoint.x, map.getHeight() / 2.0 - scale * ClPoint.y );
						g2.scale(scale, scale);
					}

					Image bgImage = new ImageIcon("./datafiles/지도.PNG").getImage();
					g2.drawImage(bgImage, 0, 0, 600, 550, null);

					g2.setColor(Color.RED);
					for (Point p : points) {
						g2.fillOval(p.x - 5 , p.y - 5 , 10, 10);
					}

					g2.dispose();

				}
			};
			map.setBounds(0, 0, 600, 550);
			panel.add(map);

			map.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					for (Point p : points) {
						if (e.getPoint().distance(p) < 10) {
							ClPoint = p;
							startZoom();
							break;
						}
					}

				}
			});
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
