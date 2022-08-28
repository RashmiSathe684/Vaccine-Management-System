package com.project.service;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class AdminPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static String driver="com.mysql.jdbc.Driver"; 
	  private static String url="jdbc:mysql:///vaccination";
	  private static String user="root";
	  private static String pwd=null;
	  
	  Connection con=null;
	  ResultSet rs=null;
		Statement st=null;
		ResultSet rs1=null;
		Statement st1=null;
		private JTable adminbook_table;
		private JTable adminreg_table;
	  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	//Login 
	
	public void adminregData_display() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pwd);
			st=con.createStatement();
			String query="select reg_id,firstname,lastname,phoneNo,emailId,dob,gender,address,password,confirmPassword from reg_details";
			rs=st.executeQuery(query);
			ResultSetMetaData rsmd=rs.getMetaData();
			DefaultTableModel model=(DefaultTableModel) adminreg_table.getModel();
			int cols=rsmd.getColumnCount();
			String[] colName=new String[cols];
			for(int i=0;i<cols;i++)
				colName[i]=rsmd.getColumnName(i+1);
			model.setColumnIdentifiers(colName);
			String reg_id,firstname,lastname,phoneNo,emailId,dob,gender,address,password,confirmPassword;
			while(rs.next()) {
				reg_id=rs.getString(1);
				firstname=rs.getString(2);
				lastname=rs.getString(3);
				phoneNo=rs.getString(4);
				emailId=rs.getString(5);
				dob=rs.getString(6);
				gender=rs.getString(7);
				address=rs.getString(8);
				password=rs.getString(9);
				confirmPassword=rs.getString(10);
				String[] row= {reg_id,firstname,lastname,phoneNo,emailId,dob,gender,address,password,confirmPassword};				
				model.addRow(row);
				
			}
			st.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void adminBookData_display() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pwd);
			st1=con.createStatement();
			String query1="select book_id,emailId,aadharNo,date,type,centre,doseNo from booking_details";
			rs1=st1.executeQuery(query1);
			ResultSetMetaData rsmd1=rs1.getMetaData();
			DefaultTableModel model1=(DefaultTableModel) adminbook_table.getModel();
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
			st1.close();
			rs1.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public AdminPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(21, 587, 48, 53);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage hp=new HomePage();
				hp.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Rashmi Sathe\\OneDrive\\Pictures\\Saved Pictures\\logout.png"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(253, 245, 230));
		panel_1.setBounds(89, 154, 800, 466);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Admin Dashboard");
		lblNewLabel_2.setBounds(21, 10, 319, 43);
		lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		lblNewLabel_2.setForeground(new Color(72, 61, 139));
		panel_1.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 63, 702, 171);
		panel_1.add(scrollPane);
		
		adminreg_table = new JTable();
		scrollPane.setViewportView(adminreg_table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(60, 263, 694, 171);
		panel_1.add(scrollPane_1);
		
		adminbook_table = new JTable();
		scrollPane_1.setViewportView(adminbook_table);
		
		adminregData_display();
		adminBookData_display();
	}
}
