package controll;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class BF extends JFrame {
	public static ArrayList<Thread> ths = new ArrayList<>();
	public static Stack<JFrame> forms = new Stack<>();
	public static int uno;
	public static String uname;

	public BF() {
		setIconImage(getImageString("./datafiles/icon/icon.png", 30, 30).getImage());
		getContentPane().setBackground(Color.white);
		getContentPane().setLayout(null);
		addComponentListener(new ComponentAdapter() {

			@Override
			public void componentResized(ComponentEvent e) {
				setLocationRelativeTo(null);
			}

			@Override
			public void componentShown(ComponentEvent e) {
				setUI();
			}
		});

	}

	public static void addEmptyPanel(JPanel jp, JScrollPane s, int max, int cnt) {
		if (s == null || jp == null)
			return;
		if (cnt >= max) {
			s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			return;
		}
		s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		for (int i = 0; i < max - cnt; i++) {
			JPanel j = new JPanel();
			j.setOpaque(false);
			jp.add(j);
		}
	}

	public void setUI() {

	}

	public static void addLogo(JLabel jl) {
		jl.setIcon(getImageString("./datafiles/icon/cat.PNG", jl.getWidth(), jl.getHeight()));
	}

	public boolean isEmpty(JTextField... textFields) {
		for (JTextField jTextField : textFields)
			if (jTextField.getText().equals(""))
				return true;
		return false;

	}

	public static void mes(String mes) {
		JOptionPane.showMessageDialog(null, mes, "경고", JOptionPane.INFORMATION_MESSAGE);
	}

	public boolean errMes(boolean b, String mes) {
		if (b)
			JOptionPane.showMessageDialog(null, mes, "경고", JOptionPane.ERROR_MESSAGE);
		return b;
	}

	public static ImageIcon getImageString(String path, int w, int h) {
		return new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(w, h, Image.SCALE_AREA_AVERAGING));
	}

	public static void openForm(JFrame bf, JFrame af) {
		bf.setVisible(true);
		af.setVisible(true);
		forms.push(bf);
		af.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				JFrame f = forms.pop();
				f.setVisible(true);
				f.setEnabled(true);
			}
		});
	}

	public void fiendForm(String fiendForm) {
		JFrame j;
		for (JFrame jFrame : forms) {
			j = forms.pop();
			if (jFrame.getTitle().equals(fiendForm)) {
				forms.push(j);
				break;
			}
		}
	}
}
