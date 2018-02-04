import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;

public class Jviewforecast {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jviewforecast window = new Jviewforecast();
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
	public Jviewforecast() {
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

		JLabel lblFoodForecasting = new JLabel("Food Forecasting");
		lblFoodForecasting.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblFoodForecasting.setBounds(132, 23, 170, 27);
		frame.getContentPane().add(lblFoodForecasting);

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(327, 39, 117, 29);
		frame.getContentPane().add(btnBack);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 80, 438, 192);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/canteen", "root", "nero");

			java.sql.PreparedStatement st = con.prepareStatement("select * from ");
			ResultSet rs = st.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));

			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JViewtable.main(null);
					frame.dispose();
				}
			});
			btnBack.setBounds(327, 22, 117, 29);
			frame.getContentPane().add(btnBack);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
