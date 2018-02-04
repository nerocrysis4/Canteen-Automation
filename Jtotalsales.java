import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Jtotalsales {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jtotalsales window = new Jtotalsales();
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
	public Jtotalsales() {
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
		
		JButton btnTotalSales = new JButton("Total sales");
		btnTotalSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/canteen","root","nero");
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select sum(quantity) from inventory");
					rs.next();
					int q=rs.getInt(1);
					ResultSet rs1=st.executeQuery("select sum(quantity) from odr");
					rs1.next();
					int w=rs1.getInt(1);
					//String query="insert into inventory(orderid,itemname,cond,quantity) "+"values ("+orderid+",'"+ itemname +"',"+quantity+",'"+condition+"')";
					String query1="update totalsales SET reststock="+q+" WHERE month=1";
					st.executeUpdate(query1);
					String query2="update totalsales SET totalsale="+w+" WHERE month=1";
					st.executeUpdate(query2);
					
					java.sql.PreparedStatement st1 = con.prepareStatement("select * from totalsales");
					ResultSet rs2 = st1.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs2));
					
					
					st.close();
					rs.close();
					rs1.close();
					con.close();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnTotalSales.setBounds(34, 6, 117, 29);
		frame.getContentPane().add(btnTotalSales);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				D.main(null);
				frame.dispose();
			}
		});
		btnBack.setBounds(305, 6, 117, 29);
		frame.getContentPane().add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 70, 438, 202);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		

	}
}
