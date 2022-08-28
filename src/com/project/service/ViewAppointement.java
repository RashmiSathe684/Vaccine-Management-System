package com.project.service;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ViewAppointement extends JFrame {
	Connection con=null;
	ResultSet rs=null;
	Statement st=null;
	ResultSet rs1=null;
	Statement st1=null;
	private static String driver="com.mysql.jdbc.Driver"; 
	  private static String url="jdbc:mysql:///vaccination";
	  private static String user="root";
	  private static String pwd=null;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable reg_table;
	private JTable book_table;
	private JLabel profilename;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAppointement frame = new ViewAppointement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void regData_display() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pwd);
			st=con.createStatement();
			String query="select reg_id,firstname,lastname,phoneNo,dob,gender,address from reg_details ORDER BY reg_id DESC LIMIT 1";
			rs=st.executeQuery(query);
			ResultSetMetaData rsmd=rs.getMetaData();
			DefaultTableModel model=(DefaultTableModel) reg_table.getModel();
			int cols=rsmd.getColumnCount();
			String[] colName=new String[cols];
			for(int i=0;i<cols;i++)
				colName[i]=rsmd.getColumnName(i+1);
			model.setColumnIdentifiers(colName);
			String reg_id,firstname,lastname,phoneNo,dob,gender,address;
			while(rs.next()) {
				reg_id=rs.getString(1);
				
				String a=rs.getString("firstname");
				String b=rs.getString("lastname");
				
				profilename.setText(a.concat(" ").concat(b));
				
				firstname=rs.getString(2);
				lastname=rs.getString(3);
				phoneNo=rs.getString(4);
				dob=rs.getString(5);
				gender=rs.getString(6);
				address=rs.getString(7);
				String[] row= {reg_id,firstname,lastname,phoneNo,dob,gender,address};
				
				model.addRow(row);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void bookingData_display() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pwd);
			st1=con.createStatement();
			String query1="select book_id,emailId,aadharNo,date,type,centre,doseNo from booking_details ORDER BY book_id DESC LIMIT 1";
			rs1=st1.executeQuery(query1);
			ResultSetMetaData rsmd1=rs1.getMetaData();
			DefaultTableModel model1=(DefaultTableModel) book_table.getModel();
			int cols=rsmd1.getColumnCount();
			String[] colName=new String[cols];
			for(int i=0;i<cols;i++)
				colName[i]=rsmd1.getColumnName(i+1);
			model1.setColumnIdentifiers(colName);
			String book_id,emailId,aadharNo,date,type,centre,doseNo;
			while(rs1.next()) {
				book_id=rs1.getString(1);
				emailId=rs1.getString(2);
				aadharNo=rs1.getString(3);
				date=rs1.getString(4);
				type=rs1.getString(5);
				centre=rs1.getString(6);
				doseNo=rs1.getString(7);
				String[] row= {book_id,emailId,aadharNo,date,type,centre,doseNo};
				
				model1.addRow(row);
			
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				st1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				rs1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public ViewAppointement() {
		setBounds(250,100,950,650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 950, 123);
		panel.setBackground(new Color(0, 0, 51));
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("MAHA VACCINATION PORTAL");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 35));
		lblNewLabel.setBounds(94, 36, 736, 65);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBounds(0, 122, 950, 528);
		contentPane.add(panel_1);
		
		profilename = new JLabel("");
		profilename.setBounds(52, 25, 142, 28);
		profilename.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		profilename.setBounds(52, 25, 142, 20);
		panel_1.add(profilename);

		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 10, 58, 59);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProfilePage pp=new ProfilePage();
				pp.setVisible(true);
				dispose();
					}
		});
		panel_1.setLayout(null);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Rashmi Sathe\\OneDrive\\Pictures\\Saved Pictures\\Userimg.png"));
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(244, 164, 96));
		panel_2.setBounds(204, 0, 746, 528);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("View Your Appointement ");
		lblNewLabel_2.setBounds(10, 10, 543, 52);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(25, 25, 112));
		lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.BOLD, 35));
		panel_2.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(245, 255, 250));
		scrollPane.setFont(new Font("Aparajita", Font.BOLD, 20));
		scrollPane.setBounds(35, 169, 701, 58);
		panel_2.add(scrollPane);
		
		reg_table = new JTable();
		reg_table.setFont(new Font("Segoe UI Variable", Font.PLAIN, 10));
		reg_table.setBackground(new Color(245, 255, 250));
		reg_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(reg_table);
		
		JLabel lblNewLabel_3 = new JLabel("Registration Details ");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
		lblNewLabel_3.setBounds(41, 113, 350, 52);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Appointements Details ");
		lblNewLabel_3_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_3_1.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
		lblNewLabel_3_1.setBounds(41, 282, 350, 37);
		panel_2.add(lblNewLabel_3_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		scrollPane_1.setBounds(35, 329, 701, 58);
		panel_2.add(scrollPane_1);
		
		book_table = new JTable();
		book_table.setFont(new Font("Segoe UI Variable", Font.PLAIN, 10));
		book_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane_1.setViewportView(book_table);
		
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setBounds(10, 464, 48, 54);
		lblNewLabel_13.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				DashBoardPage dbp=new DashBoardPage();
				dbp.setVisible(true);
				dispose();
				
			}
		});
		lblNewLabel_13.setIcon(new ImageIcon("C:\\Users\\Rashmi Sathe\\OneDrive\\Pictures\\Saved Pictures\\logout.png"));
		panel_1.add(lblNewLabel_13);
		
		
		
		regData_display();
		bookingData_display();
}
}
