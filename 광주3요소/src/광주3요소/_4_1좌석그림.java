package ±¤ÁÖ3¿ä¼Ò;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class _4_1ÁÂ¼®±×¸² extends JFrame {

	private JPanel contentPane;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_4_1ÁÂ¼®±×¸² frame = new _4_1ÁÂ¼®±×¸²();
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
	public _4_1ÁÂ¼®±×¸²() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel = new JPanel() ;
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(12, 10, 532, 302);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(5, 4, 50, 20));
		for (int i = 0; i < 5; i++) {
			panel.add(new SeatInfo(Color.red));
		}
		for (int i = 0; i < 10; i++) {
			panel.add(new SeatInfo(Color.white));
		}
		for (int i = 0; i < 5; i++) {
			panel.add(new SeatInfo(Color.blue));
		}
	}
	class SeatInfo extends JPanel{
		Color c;

	    public SeatInfo(Color co) {
	        c = co;
	        setPreferredSize(new Dimension(50, 50));
	        setSize(new Dimension(50, 50));
	        setOpaque(false);
	    }

	    @Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				
			g2.setColor(c);
			g2.fillArc(25, 0, 50, 50, -180, -180);
			g2.fillRect(25, 25, 50, 25);
		}

	    public void setColor(Color c) {
	        this.c = c;
	    }
	}
}
