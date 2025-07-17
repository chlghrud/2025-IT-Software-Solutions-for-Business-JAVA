package ����2���;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.Arc2D.Double;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.nio.file.Path;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class ������Ʈȸ��_2����_1 extends JFrame {

	private JPanel contentPane;
	JPanel jp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					������Ʈȸ��_2����_1 frame = new ������Ʈȸ��_2����_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Graphics2D g2d;
	BufferedImage image;

	int[] data = new int[5]; // db���� ������ ������ ��
	int total = 0; // ������ �����͵��� ����
	int select = -1;

	int rotAngel = 0; // ȸ�� ����
	int startAngel = 0;
	int[] arcAngle = new int[5];

	int jpw = 0;
	int jph = 0;
	int w;
	int h;

	boolean mouse = false;

	Color[] colorList = new Color[] { Color.red, Color.green, Color.blue, Color.pink, Color.orange };

	Random rnd = new Random();

	public ������Ʈȸ��_2����_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// ���� ������
		for (int i = 0; i < data.length; i++) {
			data[i] = rnd.nextInt(10) + 1;
			total += data[i];
			System.out.println(data[i]);
		}
		System.out.println(total);
		
		for (int i = 0; i < arcAngle.length; i++) {
			arcAngle[i] = (int) (data[i] * 1.0 * 360 / total);
		}

		jp = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g2d = (Graphics2D) g;
				g2d.rotate(Math.toRadians(rotAngel), jpw / 2, jph / 2);
				g.drawImage(image, 0, 0, jpw, jph, this);

				for (int i = 0; i < arcAngle.length; i++) {
					createPie();
					try {
						if (rotAngel != 0 && rotAngel % 360 == 0) {
							rotAngel %= 360;
							mouse = false;
							Thread.interrupted();
						} else {
							Thread.sleep(1);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (mouse == false)
					return;
				rotAngel++;
				jp.repaint();
			}
		};
		jp.addMouseMotionListener(new JpMouseMotionListener());
		jp.addMouseListener(new Jp_1MouseListener());
		jp.setBounds(57, 30, 450, 450);
		contentPane.add(jp);

		jpw = jp.getWidth();
		jph = jp.getHeight();
		w = jpw - 50;
		h = jph - 50;
		jp.add(l);
	}

	private void createPie() {
		image = new BufferedImage(jpw, jph, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = image.createGraphics();

		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, jpw, jph);

		int acc = 0;
		int startX = (jpw - w) / 2;
		int startY = (jph - h) / 2;

		for (int i = 0; i < 5; i++) {
			g2d.setColor(colorList[i]);

			if (rotAngel % 360 == 0 && select == i) {
				int midAngle = acc + arcAngle[i] / 2;// ȣ�� ��� ���� ���ϴ� ���� (���۰� + ����) / 2 �ε� ���� = ���۰� + ȣ�� �� �̹Ƿ� (���۰� *2 +
														// ȣ��
														// ��) / 2 = ���۰� + ȣ�� �� / 2
				int moveX = (int) (Math.cos(Math.toRadians(midAngle)) * 20);
				int moveY = -(int) (Math.sin(Math.toRadians(midAngle)) * 20);
				g2d.fillArc(startX + moveX, startY + moveY, w, h, acc, arcAngle[i]);

			} else {
				g2d.fillArc(startX, startY, w, h, acc, arcAngle[i]);
			}
			acc += arcAngle[i];
			if (i == 3) {
				arcAngle[4] = 360 - acc; // ��κ� ä���ֱ�
			}
		}
		g2d.dispose();

		jp.repaint();

	}

	private class Jp_1MouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			if (mouse)
				return;

			mouse = true;

			int x = e.getX();
			int y = e.getY();

			for (int i = 0; i < data.length; i++) {
				int rgb = image.getRGB(x, y);
				Color c = new Color(rgb);
				if (colorList[i].equals(c)) {
					select = i;
				}
			}

		}
	}

	JLabel l = new JLabel();

	private class JpMouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseMoved(MouseEvent e) {

			l.setOpaque(false);
			l.setLocation(e.getX() - 50, e.getY() - 50);
			l.setSize(100, 100);

			if (rotAngel % 360 == 0 && select != -1) {

				int x = e.getX();
				int y = e.getY();

				int rgb = image.getRGB(x, y);
				Color c = new Color(rgb);
				if (colorList[select].equals(c)) {
					l.setToolTipText(data[select] + " / " + (data[select] * 100) / total+"%");
				}else {
					l.setToolTipText(null);
				}

			}
		}
	}
}
