import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class CustomerLogin {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerLogin window = new CustomerLogin();
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
	public CustomerLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Focus.color"));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Login");
		lblNewLabel.setForeground(UIManager.getColor("InternalFrame.borderLight"));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 21));
		lblNewLabel.setBounds(143, 33, 172, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("user id");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(new Color(51, 0, 0));
		lblNewLabel_1.setBounds(79, 116, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("password");
		lblNewLabel_3.setForeground(new Color(51, 0, 0));
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(79, 172, 83, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String s1=textField.getText();
			String s2=passwordField.getText();
			if(s1.equals("cos")&&s2.equals("1234")) {
				Customer.main(null);
				frame.dispose();
			}
			else {
			    JOptionPane.showMessageDialog(null,"retry","wrong password",JOptionPane.INFORMATION_MESSAGE);
			}
			}
		});
		btnLogin.setBounds(283, 224, 117, 29);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(197, 168, 136, 26);
		frame.getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(197, 112, 136, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Login.main(null);
			frame.dispose();
			}
		});
		btnBack.setBounds(45, 224, 117, 29);
		frame.getContentPane().add(btnBack);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
