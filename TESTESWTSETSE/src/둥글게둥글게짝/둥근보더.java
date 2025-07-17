package �ձ۰Եձ۰�¦;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.border.AbstractBorder;

public class �ձٺ��� extends AbstractBorder {// AbstractBorder = border Ŀ���͸���¡ Ŭ����
	private Color borderColor;

	public �ձٺ���(Color borderColor) {
		this.borderColor = borderColor;
	}
	
	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		g.setColor(borderColor);
		g.drawRoundRect(x, y, width - 1, height - 1, 20, 20);
		super.paintBorder(c, g, x, y, width, height);
	}
}
