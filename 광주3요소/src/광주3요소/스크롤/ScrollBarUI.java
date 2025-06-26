package ����3���.��ũ��;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 * ��ũ�ѹ��� ������ �ܺο��� ������ �� �ֵ��� Ŀ���͸���¡�� UI Ŭ����.
 * �巡�� ����(thumb)�� ������ ���� �����ϸ�, ���� ��ư�� ���� ó����.
 */
public class ScrollBarUI extends BasicScrollBarUI {

    private final Color customThumbColor;

    public ScrollBarUI(Color color) {
        this.customThumbColor = color;
    }
    
    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
    	Graphics2D g2 = (Graphics2D) g.create();

		g2.setColor(customThumbColor);
		g2.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, 20, 20);
    }
    
    @Override
    protected JButton createDecreaseButton(int orientation) {
        return createZeroButton();
    }
    
    @Override
    protected JButton createIncreaseButton(int orientation) {
        return createZeroButton();
    }

    private JButton createZeroButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(0, 0));
        return button;
    }
}
