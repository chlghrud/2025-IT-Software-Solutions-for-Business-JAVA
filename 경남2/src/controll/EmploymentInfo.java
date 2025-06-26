package controll;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class EmploymentInfo extends JPanel {
	private JLabel label;

	/**
	 * Create the panel.
	 */
	public EmploymentInfo(String text, String path, int h) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("<html><Center>" + text);
		label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		add(label, BorderLayout.CENTER);
		label.setIcon(BF.getImageString(path, 130, h));

	}
	
}
