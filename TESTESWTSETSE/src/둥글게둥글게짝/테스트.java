package �ձ۰Եձ۰�¦;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class �׽�Ʈ extends JFrame {

	public �׽�Ʈ() {
		ui();
		setVisible(true);
	}

	private void ui() {
		setSize(400, 500);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		
		add(new JTextField() {
			{
				setBorder(null);
				setLayout(new BorderLayout());
				add(new �ձ�������Ʈ(Color.blue));
			}
		}, "North");
		add(new JButton("��ư") {
			{
				setLayout(new BorderLayout());
				setContentAreaFilled(false);
				setRolloverEnabled(false);
				setBackground(Color.white);
				setBorder(null);
				add(new �ձ�������Ʈ(Color.blue));
				setPreferredSize(new Dimension(0, 30));
			}
		}, "South");
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new �׽�Ʈ();
		});
	}
}
