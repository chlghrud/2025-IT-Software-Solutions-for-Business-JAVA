package tools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BP extends JPanel {
	public JPanel befPanel;

	public BP() {
		setLayout(null);
		setBackground(Color.white);
		setSize(904, 496);
		setPreferredSize(new Dimension(904, 496));
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				control();
			}
		});
	}

	public void control() {
	}

	public static ImageIcon setIcon(String name, int w, int h) {
		return new ImageIcon(new ImageIcon(name.replaceAll("/A충남2", ".")).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
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

}
