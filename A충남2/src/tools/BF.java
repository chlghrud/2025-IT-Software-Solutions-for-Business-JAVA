package tools;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.AbstractBorder;

public class BF extends JFrame {
	private static ArrayList<BF> forms = new ArrayList<BF>();
	public String tag, befTag;

	public BF() {
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				control();
				setLocationRelativeTo(null);
				setVisible(true);
				setTitle(tag);
			}
			@Override
			public void windowClosed(WindowEvent e) {
				forms.stream().filter(f -> f.tag.equals(befTag)).findFirst().ifPresent(f -> f.setVisible(true));
			}
		});
	}

	public void control() {
		
	}


	boolean errMes(boolean b, String text) {
		if (b)
			JOptionPane.showMessageDialog(null, text, "경고", 0);
		return b;
	}

	boolean mes(boolean b, String text) {
		if (b)
			JOptionPane.showMessageDialog(null, text, "정보", 1);
		return b;
	}

	public void formOpen(BF uf) {
		befTag = uf.tag;
		forms.add(uf);
	}

}
