package �ձ۰Եձ۰�¦;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class �ձ�������Ʈ extends JLabel {
	public �ձ�������Ʈ(Color background) {
		setBackground(background);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(getBackground());
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);
	}
}
