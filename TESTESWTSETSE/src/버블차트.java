
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class 버블차트 extends JFrame {

	private JPanel contentPane;
	JPanel jp;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					버블차트 frame = new 버블차트();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	int[] data = new int[] { 10, 20, 20, 15, 16, 17, 4, 9 };
	int total = 0;
	ArrayList<Color> clist = new ArrayList<>();
	ArrayList<BubbleChart> location = new ArrayList<>();
	BufferedImage image;
	Graphics2D g2d;
	
	Random r = new Random();

	public 버블차트() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		for (int i = 0; i < data.length; i++) {
			total += data[i];
		}

		jp = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				moveBubble(g);
			}
		};
		jp.setBounds(12, 10, 550, 347);
		contentPane.add(jp);

		setBubble();
		jp.repaint();
	}

	private void setBubble() {
		image = new BufferedImage(jp.getWidth(), jp.getHeight(), BufferedImage.TYPE_INT_ARGB);
		g2d = image.createGraphics();
		for (int item : data) {
			Shape bubble;

			int size = item * 1000 / total;

			int tryWhile = 0;
			boolean set = false;
			while (set == false && tryWhile <= 1000) {
				int x = r.nextInt(jp.getWidth() - size);
				int y = r.nextInt(jp.getHeight() - size);

				bubble = new Rectangle(x, y, size, size);
				boolean inter = false;
				for (var i : location) {
					if (i.intersects(bubble.getBounds())) {
						inter = true;
						break;
					}
				}

				if (inter == false) {
					Color c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
					clist.add(c);
					g2d.setColor(c);
					g2d.fillOval(x, y, size, size);
					set = true;
					location.add(new BubbleChart(x, y, size));
				}
				tryWhile++;
			}

		}
	}

	private void moveBubble(Graphics g) {
		g.drawImage(image, 0, 0, null);
        
        g2d = image.createGraphics();
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, jp.getWidth(), jp.getHeight());
        
		for (var item : location) {
			if (item.ang == -1)
				item.ang = r.nextInt(360);
			
			double x = item.x + Math.cos(Math.toRadians(item.ang));
			double y = item.y + Math.sin(Math.toRadians(item.ang));
			
			item.setFrame(x,y,item.size,item.size);
			
			boolean check = true;
			for (var inItem : location) {
				Area area = new Area(item);
				area.intersect(new Area(inItem));
				if(!new Rectangle(0,0,jp.getWidth(),jp.getHeight()).contains(item.getBounds())|| (item != inItem && !area.isEmpty())) {
					item.setFrame(item.x, item.y, item.size, item.size);
					item.ang = -1;
					check = false;
					break;
				}
			}
			if(check) {
				item.x = x;
				item.y = y;
			}
			g2d.setColor(clist.get(location.indexOf(item)));
			g2d.fill(item);
		}
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
		}
		jp.repaint();
	}
}

class BubbleChart extends Ellipse2D.Double {
	double x, y, size;
	int ang = -1;

	public BubbleChart(int x, int y, int size) {
		super(x, y, size, size);
		this.x = x;
		this.y = y;
		this.size = size;
	}
}
