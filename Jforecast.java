import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Jforecast {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jforecast window = new Jforecast();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Jforecast() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Food Forecasting");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(141, 36, 164, 25);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Forecast");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/canteen", "root", "nero");
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select max(quantity) from odr");
					rs.next();
					int q = rs.getInt(1);
					System.out.println(q);
					String query2 = "select orderid from odr where quantity=" + q;
					ResultSet rs1 = st.executeQuery(query2);
					rs1.next();
					int w = rs1.getInt(1);
					String time = textField.getText();
					String ava;
					if (w >= 5) {
						ava = "yes";
					} else
						ava = "no";
					// while (rs.next()) {

					// int q = rs.getInt("quantity");
					// System.out.println(q + "\n");
					// }
					String query = "insert into orderforecasting(favourite_items,specialhour,available) " + "values ("
							+ w + ",'" + time + "','" + ava + "')";
					// String query1="update totalsales SET reststock="+q+" WHERE month=1";
					st.executeUpdate(query);
				    JOptionPane.showMessageDialog(null,"complete forecasting","forecasting",JOptionPane.INFORMATION_MESSAGE);

					st.close();
					st.close();
					con.close();
				} catch (Exception e1) {
				    JOptionPane.showMessageDialog(null,"error","forecasting",JOptionPane.INFORMATION_MESSAGE);
					e1.printStackTrace();
				}
				Jviewforecast.main(null);
			}
		});
		btnNewButton.setBounds(293, 210, 117, 29);
		frame.getContentPane().add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(216, 112, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblSpecialHour = new JLabel("Special hour");
		lblSpecialHour.setBounds(77, 117, 86, 16);
		frame.getContentPane().add(lblSpecialHour);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				D.main(null);
				frame.dispose();
			}
		});
		btnBack.setBounds(46, 210, 117, 29);
		frame.getContentPane().add(btnBack);
	}
}
