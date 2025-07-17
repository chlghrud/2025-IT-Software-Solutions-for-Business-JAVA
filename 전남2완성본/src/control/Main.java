package control;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.AbstractBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends UF {
	private JLabel label;
	private JTextField textField;
	
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
		tag = "∏ﬁ¿Œ";
		
		setBounds(100, 100, 1024, 628);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel("Skills Qualification Association");
		label.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		label.setBounds(70, 10, 297, 38);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(379, 10, 297, 43);
		textField.setBorder(new RoundBorder(Color.blue));
		getContentPane().add(textField);
		textField.setColumns(10);
		addLogo();
	}

}
