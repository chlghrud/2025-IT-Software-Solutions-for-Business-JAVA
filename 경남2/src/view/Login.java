package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controll.BF;
import controll.DB;
import controll.PlaceHolder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends BF {
	private JLabel lblNewLabel = new JLabel("\uC54C\uBC14\uCEA3");
	private PlaceHolder pt;
	private PlaceHolder pt_1 = new PlaceHolder("\uC5EC\uAE30\uC785\uB825");
	private JButton button = new JButton("\uB85C\uADF8\uC778");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("\uB85C\uADF8\uC778");
		setBounds(100, 100, 698, 261);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 682, 55);
		
		pt = new PlaceHolder("�����Է�");
		pt.setPlaceHolder("ID");
		pt.setFont(new Font("���� ���", Font.BOLD, 15));
		pt.setBounds(55, 79, 281, 34);
		getContentPane().add(pt);
		getContentPane().add(lblNewLabel);
		pt_1.setPlaceHolder("PW");
		pt_1.setFont(new Font("���� ���", Font.BOLD, 15));
		pt_1.setBounds(369, 79, 263, 34);
		
		getContentPane().add(pt_1);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (var pre = DB.con.prepareStatement("SELECT * FROM user where uid = ? and upw = ?;")) {
					DB.setPre(pre, pt.getText(), pt_1.getText());
					var rs = pre.executeQuery();
					if(!errMes(isEmpty(pt, pt_1), "��ĭ�� �ֽ��ϴ�.")) {
						if(pt.getText().equals("admin") && pt.getText().equals("admin")) {
							mes("�����ڷ� �α��� �Ͽ����ϴ�.");
						}
						if(!errMes(!rs.next(), "��ġ�ϴ� ȸ�� ������ �����ϴ�.")) {
							uname = rs.getString("uname");
							uno = rs.getInt("uno");
							mes(uname = "ȸ����("+uname +":"+rs.getString("unick")+") ȯ���մϴ�.");
							openForm(Login.this, new Main());
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(255, 128, 0));
		button.setFont(new Font("���� ���", Font.BOLD, 15));
		button.setBounds(55, 134, 577, 34);
		
		getContentPane().add(button);

	}
}
