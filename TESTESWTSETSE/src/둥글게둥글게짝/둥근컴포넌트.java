package µÕ±Û°ÔµÕ±Û°ÔÂ¦;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class µÕ±ÙÄÄÆ÷³ÍÆ® extends JLabel {
	public µÕ±ÙÄÄÆ÷³ÍÆ®(Color background) {
		setBackground(background);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(getBackground());
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);
	}
}
