package controll;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JTextField;

public class PlaceHolder extends JTextField {
    private String placeHolder;

    public PlaceHolder(String text) {
        this.placeHolder = text;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (getText().isEmpty()) {
            g.setColor(Color.LIGHT_GRAY); 
            FontMetrics fm = g.getFontMetrics();
            //getWidth() - fm.stringWidth(placeHolder)) / 2 x 가운데 정렬
            g.drawString(placeHolder, 2, (getHeight() - fm.getHeight()) / 2 + fm.getAscent());
        }
    }

    public void setPlaceHolder(String text) {
        this.placeHolder = text;
        repaint();
    }

    public String getPlaceHolder() {
        return this.placeHolder;
    }
}
