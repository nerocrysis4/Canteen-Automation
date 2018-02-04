import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Jinsert {

	private JFrame frame;
	private JTextField textfield;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jinsert window = new Jinsert();
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
	public Jinsert() {
		
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
		
		JLabel lblNewLabel = new JLabel("enter orderid");
		lblNewLabel.setBounds(47, 89, 97, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("enter itemname");
		lblNewLabel_1.setBounds(47, 117, 107, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("enter quantity");
		lblNewLabel_2.setBounds(47, 145, 97, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("enter condition");
		lblNewLabel_3.setBounds(47, 173, 97, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		textfield = new JTextField();
		textfield.setBounds(173, 84, 130, 26);
		frame.getContentPane().add(textfield);
		textfield.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(173, 112, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(173, 140, 130, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(173, 168, 130, 26);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Insert Row");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(173, 34, 107, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String orderid = textfield.getText();
					String itemname = textField_1.getText();
					String quantity = textField_2.getText();
					String condition = textField_3.getText();


					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/canteen", "root", "nero");
					Statement st = con.createStatement();

					String query = "insert into inventory(orderid,itemname,cond,quantity) " + "values (" + orderid + ",'"
							+ itemname + "','" + condition + "'," + quantity + ")";
					st.executeUpdate(query);
				    JOptionPane.showMessageDialog(null,"complete insertion","inventory",JOptionPane.INFORMATION_MESSAGE);


					st.close();
					con.close();
				} 
				catch (Exception e1) {
				    JOptionPane.showMessageDialog(null,"error","inventory",JOptionPane.INFORMATION_MESSAGE);
					e1.printStackTrace();
				}
				Jviewinv.main(null);
			}
		});
		btnNewButton.setBounds(269, 221, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jinve.main(null);
				frame.dispose();
			}
		});
		btnBack.setBounds(47, 221, 117, 29);
		frame.getContentPane().add(btnBack);
	}
}
