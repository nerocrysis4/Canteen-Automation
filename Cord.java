import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Cord {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cord window = new Cord();
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
	public Cord() {
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
		
		JLabel lblNewLabel = new JLabel("enter orderId");
		lblNewLabel.setBounds(49, 101, 87, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("enter quantity");
		lblNewLabel_1.setBounds(49, 129, 98, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("enter price");
		lblNewLabel_2.setBounds(49, 157, 87, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(183, 96, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(183, 124, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(183, 152, 130, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnOrder = new JButton("order ");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String orderid = textField.getText();
					int quantity = Integer.parseInt(textField_1.getText());
					String price = textField_2.getText();

					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/canteen", "root", "nero");
					Statement st = con.createStatement();
					String query2 = "select quantity from inventory where orderid=" + orderid;
					ResultSet rs = st.executeQuery(query2);
					rs.next();
					int q = rs.getInt(1);
					q = q - quantity;

					String query = "insert into odr(orderid,quantity,price) " + "values (" + orderid + "," + quantity + ","
							+ price + ")";
					st.executeUpdate(query);
					String query1 = "update inventory SET quantity=" + q + " WHERE orderid=" + orderid;
					st.executeUpdate(query1);
				    JOptionPane.showMessageDialog(null,"complete order","order",JOptionPane.INFORMATION_MESSAGE);
					Cvieword.main(null);

					// st.executeUpdate("update inventory SET quantity=50 WHERE orderid=1001");
					rs.close();
					st.close();
					con.close();
				} catch (Exception e1) {
				    JOptionPane.showMessageDialog(null,"error","order",JOptionPane.INFORMATION_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnOrder.setBounds(273, 204, 117, 29);
		frame.getContentPane().add(btnOrder);
		
		JLabel lblOrder = new JLabel("Order");
		lblOrder.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblOrder.setBounds(194, 31, 65, 26);
		frame.getContentPane().add(lblOrder);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer.main(null);
				frame.dispose();
			}
		});
		btnBack.setBounds(49, 204, 117, 29);
		frame.getContentPane().add(btnBack);
	}
}
