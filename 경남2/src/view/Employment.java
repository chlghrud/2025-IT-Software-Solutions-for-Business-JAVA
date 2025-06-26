package view;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JFrame;

import controll.BF;
import controll.DB;
import controll.EmploymentInfo;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Employment extends BF {
	private JLabel label;
	private JTextField textField;
	private JLabel label_1;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JScrollPane scrollPane;
	private JPanel panel;
	Random r = new Random();
	String order = "", search = "'%%'", cata;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employment frame = new Employment();
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
	public Employment() {
		setTitle("\uCC44\uC6A9");
		setBounds(100, 100, 596, 687);
		setDefaultCloseOperation(2);
		getContentPane().setLayout(null);

		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 93, 74);
		getContentPane().add(label);
		addLogo(label);

		textField = new JTextField();
		textField.setBounds(139, 27, 319, 26);
		getContentPane().add(textField);
		textField.setColumns(10);

		label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				search = "'%" + textField.getText() + "%'";
				search(order, search, cata);
			}
		});
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(470, 13, 47, 40);
		getContentPane().add(label_1);
		label_1.setIcon(getImageString("./datafiles/icon/search.png", label_1.getWidth(), label_1.getHeight()));

		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBox.getSelectedIndex() == 0) {
					cata = "";
					return;
				}
				cata = " and cno = " + comboBox.getSelectedIndex();
				search(order, search, cata);
			}
		});
		comboBox.setBounds(37, 81, 134, 23);
		getContentPane().add(comboBox);
		comboBox.addItem("ÀüÃ¼");

		comboBox_1 = new JComboBox();
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBox_1.getSelectedIndex() == 0) {
					order = " order by j.jno";
				} else if (comboBox_1.getSelectedIndex() == 1) {
					order = " order by populer desc";
				} else if (comboBox_1.getSelectedIndex() == 2) {
					order = " order by jmoney desc";
				}
				search(order, search, cata);
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(
				new String[] { "\uAE30\uBCF8\uC21C", "\uC778\uAE30\uC21C", "\uAE09\uC5EC\uB192\uC740\uC21C" }));
		comboBox_1.setBounds(434, 81, 134, 23);
		getContentPane().add(comboBox_1);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 130, 556, 508);
		getContentPane().add(scrollPane);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1, 10, 10));
		try (var rs = DB.stmt.executeQuery("SELECT * FROM category;")) {
			while (rs.next()) {
				comboBox.addItem(rs.getString("cname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		search(" order by j.jno", "'%%'", "");
	}

	private void search(String order, String search, String cata) {
		try (var rs = DB.stmt.executeQuery(
				"select j.*, c.*, po.* from job j join brand b using(bno) join category c using(cno) join (select jno, count(*) as populer from apply join job j using(jno) group by jno) as po using(jno) where jname like "
						+ search + cata + order)) {
			panel.removeAll();
			int i;
			for (i = 0; rs.next(); i++) {
				String ad = "";
				if (r.nextBoolean()) {
					ad = "./datafiles/advertise/" + rs.getString("jno") + "-" + (r.nextInt(2) + 1) + ".JPG";
				}
				EmploymentInfo info = new EmploymentInfo(rs.getString("jname"), ad, scrollPane.getHeight() / 5 - 10);
				info.setPreferredSize(new Dimension(scrollPane.getWidth() - 20, scrollPane.getHeight() / 5 - 10));
				panel.add(info);
				int jno = rs.getInt("jno");
				info.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						openForm(Employment.this, new JobInfo(jno));
						Employment.this.setEnabled(false);
					}
				});
				panel.repaint();
			}

			addEmptyPanel(panel, scrollPane, 5, i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
