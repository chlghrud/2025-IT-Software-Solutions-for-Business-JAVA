package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tools.BP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;

public class Main extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private static JPanel panel_1;
	private JLabel label;
	private JPanel panel_2;
	private static JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 605);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel.setPreferredSize(new Dimension(10, 70));
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(null);

		label = new JLabel("");
		label.setBounds(12, 10, 135, 50);
		label.setIcon(BP.setIcon("/A√Ê≥≤2/datafiles/æ∆¿Ãƒ‹/æ∆¿Ãƒ‹.png", label.getWidth(), label.getHeight()));
		panel.add(label);

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(185, 10, 535, 50);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 4, 0, 0));

		label_1 = new JLabel("\uC804\uC2DC");
		label_1.setForeground(new Color(0, 0, 255));
		label_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 17));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_1);

		label_2 = new JLabel("\uC608\uB9E4");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 17));
		panel_2.add(label_2);

		label_3 = new JLabel("\uD504\uB85C\uADF8\uB7A8");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 17));
		panel_2.add(label_3);

		label_4 = new JLabel("\uCEE4\uBBA4\uB2C8\uD2F0");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 17));
		panel_2.add(label_4);

		label_5 = new JLabel("LOGOUT");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 17));
		label_5.setBounds(777, 8, 120, 50);
		panel.add(label_5);

		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		label_1.addMouseListener(new labelsClick());
		label_2.addMouseListener(new labelsClick());
		label_3.addMouseListener(new labelsClick());
		label_4.addMouseListener(new labelsClick());
		
		øπ∏≈ øπ∏≈ = new øπ∏≈();
		panel_1.add(øπ∏≈);
		øπ∏≈.setLayout(null);

	}

	static class labelsClick extends MouseAdapter {
		static JLabel beforeLabel = label_1;

		@Override
		public void mouseClicked(MouseEvent e) {
			beforeLabel.setForeground(Color.black);
			beforeLabel = (JLabel) e.getComponent();
			beforeLabel.setForeground(Color.blue);
			
			try {
				BP np = (BP) Class.forName("view." + ((JLabel) e.getComponent()).getText()).getDeclaredConstructor().newInstance();
				panel_1.removeAll();
				panel_1.add(np);
				panel_1.revalidate();
			} catch (Exception e1) {
			}
		}
	}
}
