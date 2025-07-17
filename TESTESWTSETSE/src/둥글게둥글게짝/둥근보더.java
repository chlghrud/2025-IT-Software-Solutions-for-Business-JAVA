package µÕ±Û°ÔµÕ±Û°ÔÂ¦;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.border.AbstractBorder;

public class µÕ±Ùº¸´õ extends AbstractBorder {// AbstractBorder = border Ä¿½ºÅÍ¸¶ÀÌÂ¡ Å¬·¡½º
	private Color borderColor;

	public µÕ±Ùº¸´õ(Color borderColor) {
		this.borderColor = borderColor;
	}
	
	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		g.setColor(borderColor);
		g.drawRoundRect(x, y, width - 1, height - 1, 20, 20);
		super.paintBorder(c, g, x, y, width, height);
	}
}
