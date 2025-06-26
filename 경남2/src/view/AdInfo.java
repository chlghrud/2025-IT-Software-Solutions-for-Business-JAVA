package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controll.BF;
import controll.DB;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

public class AdInfo extends BF {
	private JPanel panel;
	private JLabel label;
	private JLabel label_1;
	JLabel ads[] = new JLabel[2] ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdInfo frame = new AdInfo(1);
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
	public AdInfo(int adno) {
		setTitle("\uAD11\uACE0 \uC815\uBCF4");
		setBounds(100, 100, 507, 414);
		setDefaultCloseOperation(2);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(52, 86, 388, 163);
		getContentPane().add(panel);
		
		label = new JLabel("New label");
		label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		label.setBounds(12, 10, 467, 59);
		getContentPane().add(label);
		
		label_1 = new JLabel("New label");
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 17));
		label_1.setBounds(12, 277, 467, 88);
		panel.setLayout(null);
		getContentPane().add(label_1);
		
		try (var rs = DB.stmt.executeQuery("SELECT * FROM parttimecat.advertise where ano = " + adno)) {
			rs.next();
			label.setText("<html>"+rs.getString("aname"));
			label_1.setText("<html>"+rs.getString("adetail"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < ads.length; i++) {
			ads[i] = new JLabel();
			ads[i].setSize(panel.getSize());
			ads[i].setLocation(panel.getWidth() * i, 0);
			panel.add(ads[i]);
		}
		ads[0].setIcon(getImageString("./datafiles/advertise/"+adno+"-1.JPG", panel.getWidth(), panel.getHeight()));
		ads[1].setIcon(getImageString("./datafiles/advertise/"+adno+"-2.JPG", panel.getWidth(), panel.getHeight()));
		Thread th = new Thread(() -> {
			int idx = 0;
			while (true) {
				for (int i = 0; i < panel.getWidth(); i++) {
					for (int j = 0; j < ads.length; j++) {
						ads[j].setLocation(ads[j].getLocation().x - 1, 0);
					}
					try {
						Thread.sleep(5000/panel.getWidth());
					} catch (InterruptedException e) {
					}
				}
				ads[idx].setLocation(panel.getWidth(), 0);
				idx = ++idx % 2;
			}
		});
		th.start();
	}
}
