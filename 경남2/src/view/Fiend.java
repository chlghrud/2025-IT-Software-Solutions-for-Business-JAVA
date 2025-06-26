package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controll.BF;
import controll.DB;

public class Fiend extends BF {

	/**
	 * Launch the application.
	 */
	private JPanel panel;
	private JPanel panel_1;
	private JLabel map;
	ArrayList<Point> points = new ArrayList<Point>(); 
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fiend frame = new Fiend();
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
	public Fiend() {
		setBounds(100, 100, 837, 605);
		setDefaultCloseOperation(2);
	

		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(600, 550));
		panel.setBounds(12, 10, 600, 550);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(624, 10, 178, 373);
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		label = new JLabel("\uC804\uCCB4");
		label.setBackground(new Color(255, 255, 255));
		label.setOpaque(true);
		
		label.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(label);
		
		label_1 = new JLabel("\uC74C\uC2DD\uC810");
		label_1.setBackground(new Color(255, 255, 255));
		label_1.setOpaque(true);
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		label_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(label_1);
		
		label_2 = new JLabel("\uCE74\uD398");
		label_2.setBackground(new Color(255, 255, 255));
		label_2.setOpaque(true);
		label_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		label_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(label_2);
		
		label_3 = new JLabel("\uD3B8\uC758\uC810/\uB9C8\uD2B8");
		label_3.setBackground(new Color(255, 255, 255));
		label_3.setOpaque(true);
		label_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		label_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(label_3);
		
		label_4 = new JLabel("\uC219\uBC15");
		label_4.setBackground(new Color(255, 255, 255));
		label_4.setOpaque(true);
		label_4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		label_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(label_4);
		
		label_5 = new JLabel("\uC758\uB958/\uBDF0\uD2F0 \uB9E4\uC7A5");
		label_5.setBackground(new Color(255, 255, 255));
		label_5.setOpaque(true);
		label_5.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		label_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(label_5);
		
		label_6 = new JLabel("\uB808\uC800 \uC2DC\uC124");
		label_6.setBackground(new Color(255, 255, 255));
		label_6.setOpaque(true);
		label_6.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		label_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(label_6);
		
		label_7 = new JLabel("\uBB38\uD654 \uC2DC\uC124");
		label_7.setBackground(new Color(255, 255, 255));
		label_7.setOpaque(true);
		label_7.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		label_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(label_7);
		
		label_8 = new JLabel("\uC11C\uC810/\uBB38\uAD6C");
		label_8.setBackground(new Color(255, 255, 255));
		label_8.setOpaque(true);
		label_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		label_8.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		label_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(label_8);
		
		label_9 = new JLabel("\uBC30\uB2EC/\uD0DD\uBC30");
		label_9.setBackground(new Color(255, 255, 255));
		label_9.setOpaque(true);
		label_9.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		label_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(label_9);
		
		label_10 = new JLabel("\uAE30\uD0C0");
		label_10.setBackground(new Color(255, 255, 255));
		label_10.setOpaque(true);
		label_10.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		label_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(label_10);
		label.addMouseListener(new lc());
		label_1.addMouseListener(new lc());
		label_2.addMouseListener(new lc());
		label_3.addMouseListener(new lc());
		label_4.addMouseListener(new lc());
		label_5.addMouseListener(new lc());
		label_6.addMouseListener(new lc());
		label_7.addMouseListener(new lc());
		label_8.addMouseListener(new lc());
		label_9.addMouseListener(new lc());
		label_10.addMouseListener(new lc());
		setMap("");

	}
	private void setMap(String string) {
		try (var rs = DB.stmt.executeQuery("SELECT * FROM brand join category using(cno) "+string+";")) {
			points.clear();
			if(map != null)
				map.repaint();
			while (rs.next()) {
				points.add(new Point(rs.getInt("bxx"), rs.getInt("byy")));
				
			}
			map = new JLabel(new ImageIcon(new ImageIcon("./datafiles/Áöµµ.PNG").getImage().getScaledInstance(600, 550, Image.SCALE_SMOOTH))) {
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.setColor(Color.red);
					for (Point point : points) {
						g.fillOval(point.x, point.y, 10, 10);
					}
				}
			};
			
			map.setBounds(0, 0, 600, 550);
			panel.add(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	JLabel beforeL = new JLabel();
	class lc extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel now = (JLabel)e.getSource();
			if(now != beforeL) {
				beforeL.setForeground(Color.black);
				beforeL.setBackground(Color.white);
				beforeL = now;
				now.setForeground(Color.red);
				now.setBackground(Color.white);
				if(!now.getText().equals("ÀüÃ¼"))
					setMap("where cname like '%" + now.getText() + "%'");
				else
					setMap("");
			}
		}
	}
}
