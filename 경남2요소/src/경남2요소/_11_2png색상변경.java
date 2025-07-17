package 경남2요소;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class _11_2png색상변경 extends JFrame {

	private JPanel contentPane;
	private JLabel label;
	BufferedImage img;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_11_2png색상변경 frame = new _11_2png색상변경();
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
	
	public _11_2png색상변경() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(115, 63, 148, 113);
		contentPane.add(label);
		setLabel();
	}

	private void setLabel() {
		Random r = new Random();
		try {
			img = ImageIO.read(new File("./datafiles/icon/insert.png"));
			Thread th = new Thread(() -> {
				while (true) {
					int color = (r.nextInt(256) << 24) | (r.nextInt(256) << 16) | (r.nextInt(256) << 8) | r.nextInt(256);
					 for (int y = 0; y < img.getHeight(); y++) {
		                    for (int x = 0; x < img.getWidth(); x++) {
		                    	if(img.getRGB(x, y) == Color.white.getRGB()) 
		                    		continue;
		                    	img.setRGB(x,y,color);

		                    }
		                }
					 javax.swing.SwingUtilities.invokeLater(() -> label.setIcon(new ImageIcon( new ImageIcon(img).getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH))));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			th.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
