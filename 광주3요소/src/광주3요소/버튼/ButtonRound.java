package 광주3요소.버튼;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;

public class ButtonRound extends JButton {
	public ButtonRound(String text) {
		super(text);
		setBorderPainted(false);
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

   