package ����2���.pdf����;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PDF���� extends JFrame {

	private JPanel contentPane;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PDF���� frame = new PDF����();
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
	public PDF����() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		button = new JButton("PDF\uC800\uC7A5");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new �ڰ�Ȯ�μ�().setVisible(true);
				dispose();
			}
		});
		button.setBounds(53, 62, 168, 70);
		contentPane.add(button);
	}
}
