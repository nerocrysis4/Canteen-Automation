import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;


import java.awt.Color;
import java.awt.Font;

public class D {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					D window = new D();
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
	public D() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 204, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Order");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jord.main(null);
				frame.dispose();
			}  	
		});
		btnNewButton.setBounds(91, 85, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Canteen Automation");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 0, 51));
		lblNewLabel.setBounds(129, 26, 196, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Inventory");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jinve.main(null);
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(251, 85, 117, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Biliing");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jbill.main(null);
				frame.dispose();
			}
		});
		btnNewButton_3.setBounds(44, 126, 117, 29);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Forecasting");
		btnNewButton_4.setBounds(299, 126, 117, 29);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Total Sales");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jtotalsales.main(null);
				frame.dispose();
			}
		});
		btnNewButton_5.setBounds(91, 167, 117, 29);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Total Earning");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jtotalearning.main(null);
				frame.dispose();
			}
		});
		btnNewButton_6.setBounds(251, 167, 117, 29);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnViewTables = new JButton("View Table");
		btnViewTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JViewtable.main(null);
				frame.dispose();
			}
		});
		btnViewTables.setBounds(173, 126, 117, 29);
		frame.getContentPane().add(btnViewTables);
		
		JButton btnBack = new JButton("Signout");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AdminLogin.main(null);
			frame.dispose();
			}
		});
		btnBack.setBounds(173, 208, 117, 29);
		frame.getContentPane().add(btnBack);
	}
}
