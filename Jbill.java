import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Jbill extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jbill frame = new Jbill();
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
	public Jbill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("enter orderno");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel.setBounds(53, 116, 96, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("enter paymenttype");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(53, 172, 130, 16);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(223, 112, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(223, 168, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnPrintBill = new JButton("print Bill");
		btnPrintBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String orderno=textField.getText();
					String pay=textField_1.getText();
					
					Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/canteen","root","nero");
						Statement st=con.createStatement();
						String query2="select quantity from odr where orderno="+orderno;
						ResultSet rs=st.executeQuery(query2);
						rs.next();
						int q=rs.getInt(1);
						
						String query3="select price from odr where orderno="+orderno;
						ResultSet rs1=st.executeQuery(query3);
						rs1.next();
						int p=rs1.getInt(1);
						int amount=q*p;
						String query="insert into billing(orderno,paymenttype,amount) "+"values ("+orderno+",'"+ pay +"',"+amount+ ")";
						st.executeUpdate(query);
						String a="Orderno=" +orderno+ "amount=" +amount+ "payment type=" +pay;
					    JOptionPane.showMessageDialog(null,a,"bill",JOptionPane.INFORMATION_MESSAGE);
						Jviewbill.main(null);

						rs.close();
						rs1.close();
						st.close();
						con.close();
					}catch(Exception e1) {
					    JOptionPane.showMessageDialog(null,"error","bill",JOptionPane.INFORMATION_MESSAGE);
						e1.printStackTrace();
					}
			}
		});
		btnPrintBill.setBounds(313, 227, 117, 29);
		contentPane.add(btnPrintBill);
		
		JLabel lblBilling = new JLabel("Billing");
		lblBilling.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblBilling.setBounds(199, 35, 67, 29);
		contentPane.add(lblBilling);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				D.main(null);
			}
		});
		btnBack.setBounds(32, 227, 117, 29);
		contentPane.add(btnBack);
	}

}
