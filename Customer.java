import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Customer {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer window = new Customer();
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
	public Customer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 204, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setForeground(new Color(204, 0, 0));
		lblCustomer.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		lblCustomer.setBounds(168, 30, 101, 26);
		frame.getContentPane().add(lblCustomer);
		
		JButton btnNewButton = new JButton("Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Cviewinv.main(null);
			frame.dispose();
			}
		});
		btnNewButton.setBounds(65, 88, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Order");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Cord.main(null);
			frame.dispose();
			}
		});
		btnNewButton_1.setBounds(65, 129, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Bill payment");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Cbill.main(null);
			frame.dispose();
			}
		});
		btnNewButton_2.setBounds(65, 170, 117, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnBack = new JButton("Signout");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			CustomerLogin.main(null);
			frame.dispose();
			}
		});
		btnBack.setBounds(266, 220, 117, 29);
		frame.getContentPane().add(btnBack);
	}

}
