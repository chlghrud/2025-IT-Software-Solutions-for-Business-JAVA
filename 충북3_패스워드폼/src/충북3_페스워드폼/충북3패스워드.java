package 面合3_其胶况靛汽;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class 面合3菩胶况靛 extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField textField;
	private JPanel panel_1;
	Object[] keynum = new Object[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, "*", 9, "#" };
	JLabel[] nums = new JLabel[12];
	private JPanel ClearPanel;
	private JPanel Line;
	private JLabel label;
	private Timer upTimer, downTimer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					面合3菩胶况靛 frame = new 面合3菩胶况靛();
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
	public 面合3菩胶况靛() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 536);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		ClearPanel = new JPanel();
		ClearPanel.setSize(424, 437);
		panel.add(ClearPanel);
		ClearPanel.setBackground(Color.PINK);
		ClearPanel.setLayout(null);

		Line = new JPanel();
		Line.setBounds(0, 257, 424, 10);
		ClearPanel.add(Line);
		Line.setBackground(new Color(0, 0, 0));

		label = new JLabel("") {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.black);
				g.fillOval(0, 0, 80, 80);
			}
		};
		label.setBounds(165, 306, 88, 84);
		ClearPanel.add(label);
		label.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				upTimer.start();
			}
		});

		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 424, 437);
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(4, 3, 0, 0));

		textField = new JTextField() {
			@Override
			public void setText(String t) {
				if (t.startsWith("*")) {
					super.setText(t);
				}else if(t.equals("")) {
					super.setText(t);
				}
			}
		};
		textField.setPreferredSize(new Dimension(7, 50));
		contentPane.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);

		setLocationRelativeTo(null);
		setKeyPad();
		ran();
		setTimer();
	}

	private void setTimer() {
		upTimer = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ClearPanel.getLocation().y <= (-ClearPanel.getHeight()))
					((Timer) e.getSource()).stop();
				ClearPanel.setLocation(ClearPanel.getX(), ClearPanel.getY() - 35);

			}
		});

		downTimer = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ClearPanel.getY() >= 0) {
					((Timer) e.getSource()).stop();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
					}
					upTimer.start();
				}
				ClearPanel.setLocation(ClearPanel.getX(), ClearPanel.getY() + 35);

			}
		});

	}

	private void ran() {
		var list = Arrays.asList(keynum);
		Collections.shuffle(list);
		keynum = list.toArray();
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < keynum.length; i++) {
				try {

					int a = (int) keynum[i];

				} catch (Exception e) {

					if (((String) keynum[i]).equals("*")) {
						Object temp = keynum[9];
						keynum[9] = keynum[i];
						keynum[i] = temp;
					} else if (((String) keynum[i]).equals("#")) {
						Object temp = keynum[11];
						keynum[11] = keynum[i];
						keynum[i] = temp;
					}

				}
			}
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = new JLabel();
			nums[i].setHorizontalAlignment(SwingUtilities.CENTER);
			nums[i].setText(keynum[i].toString());
			nums[i].setBorder(new LineBorder(Color.black));
			nums[i].setFont(new Font("讣篮绊雕", 0, 20));
			int idx = i;
			nums[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (idx != 11)
						textField.setText(textField.getText() + ((JLabel) e.getSource()).getText());
					else {
						if (!upTimer.isRunning())
							downTimer.start();
						textField.setText("");
					}
				}
			});
			panel_1.add(nums[i]);
		}
	}

	private void setKeyPad() {

		for (int i = 0; i < keynum.length; i++) {

		}
	}
}
