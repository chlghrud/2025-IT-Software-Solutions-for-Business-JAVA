package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controll.BF;
import javax.swing.JComboBox;

public class Brand extends BF {
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Brand frame = new Brand();
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
	public Brand() {
		setTitle("\uBE0C\uB79C\uB4DC");
		setBounds(100, 100, 646, 452);
		setDefaultCloseOperation(2);
		
		comboBox = new JComboBox();
		comboBox.setBounds(12, 10, 155, 23);
		getContentPane().add(comboBox);

	}
}
