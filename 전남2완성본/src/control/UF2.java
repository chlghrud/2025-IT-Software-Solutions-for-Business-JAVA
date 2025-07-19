package control;

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

public class UF2 extends JFrame {
	private static ArrayList<UF2> forms = new ArrayList<UF2>();
	public String tag, befTag;
	public static Statement stmt;
	public static Connection con;
	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost?serverTimezone=UTC&allowLoadLocalInfile=true",
					"root", "1234");
			stmt = con.createStatement();
			stmt.execute("use lecture");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public UF2() {
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				update();
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

	public void update() {

	}

	public void setPre(PreparedStatement pre, Object... objects) {
		try {
			int i = 0;
			for (Object object : objects) {
				pre.setObject(i++, objects);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addLogo() {
		JLabel label = new JLabel(new ImageIcon(
				new ImageIcon("./datafiles/icon/logo.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		label.setBounds(0, 0, 60, 60);
		getContentPane().add(label);
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

	public void formOpen(UF2 uf) {
		befTag = uf.tag;
		forms.add(uf);
	}

	class RoundBorder extends AbstractBorder {// AbstractBorder = border 커스터마이징 클래스
		private Color borderColor;

		public RoundBorder(Color borderColor) {
			this.borderColor = borderColor;
		}
		
		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			g.setColor(borderColor);
			g.drawRoundRect(x, y, width - 1, height - 1, 20, 20);
			super.paintBorder(c, g, x, y, width, height);
		}
	}
	 class ButtonRound extends JButton {
		public ButtonRound(String text) {
			super(text);
			setContentAreaFilled(false);
			setFont(this.getFont());
		}
		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();

			g2.setColor(this.getBackground());
			g2.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);

			super.paintComponent(g2);
			g2.dispose();
		}
	}
}
