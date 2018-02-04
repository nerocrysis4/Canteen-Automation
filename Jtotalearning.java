import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Jtotalearning {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jtotalearning window = new Jtotalearning();
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
	public Jtotalearning() {
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 58, 417, 214);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		
		JButton btnTotalEarning = new JButton("Total Earning");
		btnTotalEarning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/canteen","root","nero");
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select sum(amount) from billing");
					rs.next();
					int q=rs.getInt(1);
					int w=(q*30)/100;
					//String query="insert into inventory(orderid,itemname,cond,quantity) "+"values ("+orderid+",'"+ itemname +"',"+quantity+",'"+condition+"')";
					String query1="update totalearning SET totalamount="+q+" WHERE month=1";
					st.executeUpdate(query1);
					String query2="update totalearning SET profit="+w+" WHERE month=1";
					st.executeUpdate(query2);
					
					java.sql.PreparedStatement st1 = con.prepareStatement("select * from totalearning");
					ResultSet rs1 = st1.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs1));
					
					rs1.close();
					st1.close();
					st.close();
					rs.close();
					con.close();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnTotalEarning.setBounds(44, 17, 117, 29);
		frame.getContentPane().add(btnTotalEarning);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				D.main(null);
				frame.dispose();
			}
		});
		btnBack.setBounds(293, 17, 117, 29);
		frame.getContentPane().add(btnBack);
	}
}
