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
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Jupdate {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jupdate window = new Jupdate();
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
	public Jupdate() {
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
		lblNewLabel.setBounds(42, 115, 88, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("enter quantity");
		lblNewLabel_1.setBounds(42, 171, 101, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(190, 110, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(190, 166, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String orderid = textField.getText();
					
					String quantity = textField_1.getText();
					

					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/canteen", "root", "nero");
					Statement st = con.createStatement();

					String query1="update inventory SET quantity="+quantity+" WHERE orderid="+orderid;
					st.executeUpdate(query1);
				    JOptionPane.showMessageDialog(null,"complete Updation","inventory",JOptionPane.INFORMATION_MESSAGE);

					st.close();
					con.close();
				} catch (Exception e1) {
				    JOptionPane.showMessageDialog(null,"error","inventory",JOptionPane.INFORMATION_MESSAGE);
					e1.printStackTrace();
				}
				Jviewinv.main(null);
			}			
		});
		btnNewButton.setBounds(284, 227, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Update quantity");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(156, 31, 154, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jinve.main(null);
				frame.dispose();
			}
		});
		btnBack.setBounds(42, 227, 117, 29);
		frame.getContentPane().add(btnBack);
	}

}
