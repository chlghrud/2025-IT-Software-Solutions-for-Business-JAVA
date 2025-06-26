package ±§¡÷3ø‰º“.πˆ∆∞;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Test extends JFrame {

	private JPanel contentPane;
	private ButtonRound bt;
	private ButtonRound bt_1;
	private ButtonRound bt_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 487);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		bt = new ButtonRound("∑Œ±◊¿Œ");
		bt.setForeground(new Color(255, 255, 255));
		bt.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 31));
		bt.setBounds(91, 67, 163, 94);
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("∑Œ±◊¿Œ≈¨∏Ø");
			}
		});
		contentPane.setLayout(null);
		bt.setBackground(new Color(0, 0, 255));
		
		contentPane.add(bt);
		
		setContentPane(contentPane);
		
		bt_1 = new ButtonRound("\uB85C\uADF8\uC778");
		bt_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("¡¬ºÆº±≈√ ≈¨∏Ø");
			}
		});
		bt_1.setText("\uC88C\uC11D\uC120\uD0DD");
		bt_1.setForeground(new Color(0, 0, 0));
		bt_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 17));
		bt_1.setBackground(new Color(255, 255, 255));
		bt_1.setBounds(326, 67, 138, 53);
		contentPane.add(bt_1);
		
		bt_2 = new ButtonRound("\uB85C\uADF8\uC778");
		bt_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("¥ŸΩ√º±≈√≈¨∏Ø");
			}
		});
		bt_2.setText("\uB2E4\uC2DC\uC120\uD0DD");
		bt_2.setForeground(Color.WHITE);
		bt_2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 23));
		bt_2.setBackground(new Color(255, 0, 0));
		bt_2.setBounds(280, 240, 125, 50);
		contentPane.add(bt_2);
	}

}
