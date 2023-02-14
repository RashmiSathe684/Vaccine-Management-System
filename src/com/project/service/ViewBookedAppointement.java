package com.project.service;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ViewBookedAppointement extends JFrame {
	Connection con=null;
	ResultSet rs=null;
	Statement st=null;
	ResultSet rs1=null;
	Statement st1=null;
	PreparedStatement pst=null;
	private static String driver="com.mysql.jdbc.Driver"; 
	  private static String url="jdbc:mysql:///vaccination";
	  private static String user="root";
	  private static String pwd=null;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel typeLabel,aadharLabel,emailLabel,cityLabel,centreLabel,dateLabel,doseLabel,profileName;
	private JRadioButton b1,b2,b3;
	private ButtonGroup buttonGroup;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBookedAppointement frame = new ViewBookedAppointement();
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
			String query="select firstname from reg_details ORDER BY reg_id DESC LIMIT 1";
			rs=st.executeQuery(query);
			while(rs.next()) {
				
				String a=rs.getString("firstname");
				
				profileName.setText(a);
				
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
//	
//	
//	public void bookingData_display() {
//	if(b1.isSelected()==true) 
//	{
//		try
//		{
//		Class.forName(driver);
//		con=DriverManager.getConnection(url,user,pwd);
//		String sql="select * from booking_details";
//		pst=con.prepareStatement(sql);
//		rs=pst.executeQuery();
//		while(rs.next())
//		{
//			
//			String a=rs.getString("aadharNo");
//			aadharLabel.setText(a);
//			
//			
//			String b=rs.getString("emailId");
//			emailLabel.setText(b);
//			
//			
//			String c=rs.getString("city");
//			cityLabel.setText(c);
//			
//			String d=rs.getString("centre");
//			centreLabel.setText(d);
//			
//			String e=rs.getString("date");
//			dateLabel.setText(e);
//			
//			String f=rs.getString("type");
//			typeLabel.setText(f);
//			
//			String g=rs.getString("doseNo");
//			doseLabel.setText(g);
//		
//		}
//		}catch(Exception e1){
//			e1.printStackTrace();
//		}
//	}
//	else if(b2.isSelected()==true) 
//	{
//		try
//		{
//		Class.forName(driver);
//		con=DriverManager.getConnection(url,user,pwd);
//		String sql="select * from booking_details";
//		pst=con.prepareStatement(sql);
//		rs=pst.executeQuery();
//		while(rs.next())
//		{
//			
//			String a=rs.getString("aadharNo");
//			aadharLabel.setText(a);
//			
//			
//			String b=rs.getString("emailId");
//			emailLabel.setText(b);
//			
//			
//			String c=rs.getString("city");
//			cityLabel.setText(c);
//			
//			String d=rs.getString("centre");
//			centreLabel.setText(d);
//			
//			String edate=rs.getString("date");
//			dateLabel.setText(edate);
//			
//			String f=rs.getString("type");
//			typeLabel.setText(f);
//			
//			String g=rs.getString("doseNo");
//			doseLabel.setText(g);
//		
//		}
//		}catch(Exception ex){
//			ex.printStackTrace();
//		}
//	}
//	else if(b3.isSelected()==true)
//	{
//		try
//		{
//		Class.forName(driver);
//		con=DriverManager.getConnection(url,user,pwd);
//		String sql="select * from boosterbooking_details";
//		pst=con.prepareStatement(sql);
//		rs=pst.executeQuery();
//		while(rs.next())
//		{
//			
////			String a=rs.getString("aadharNo");
////			aadharLabel.setText(a);
//			
//			String b=rs.getString("emailId");
//			emailLabel.setText(b);
//			
//			
//			String c=rs.getString("city");
//			cityLabel.setText(c);
//			
//			String d=rs.getString("centre");
//			centreLabel.setText(d);
//			
//			String edate=rs.getString("date");
//			dateLabel.setText(edate);
//			
//			String f=rs.getString("type");
//			typeLabel.setText(f);
//			
//			String g=rs.getString("doseNo");
//			doseLabel.setText(g);
//		
//		}
//		}catch(Exception e3){
//			e3.printStackTrace();
//		}
//	}
//	else 
//	{
//		try
//		{
//		Class.forName(driver);
//		con=DriverManager.getConnection(url,user,pwd);
//		String sql="select * from booking_details";
//		pst=con.prepareStatement(sql);
//		rs=pst.executeQuery();
//		while(rs.next())
//		{
//			
//			String a=rs.getString("aadharNo");
//			aadharLabel.setText(a);
//			
//			
//			String b=rs.getString("emailId");
//			emailLabel.setText(b);
//			
//			
//			String c=rs.getString("city");
//			cityLabel.setText(c);
//			
//			String d=rs.getString("centre");
//			centreLabel.setText(d);
//			
//			String e=rs.getString("date");
//			dateLabel.setText(e);
//			
//			String f=rs.getString("type");
//			typeLabel.setText(f);
//			
//			String g=rs.getString("doseNo");
//			doseLabel.setText(g);
//		
//		}
//		}catch(Exception e1){
//			e1.printStackTrace();
//		}
//	}
//		
//	}
	public ViewBookedAppointement() {
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
		panel_2.setBounds(204, 0, 746, 528);
		panel_2.setBackground(new Color(118,82,139));
		panel_1.add(panel_2);
		 panel_2.setLayout(null);
		
		
		 JPanel panel_3 = new JPanel();
		 panel_3.setBounds(37, 26, 650, 463);
		panel_3.setBackground(new Color(215,196,158));
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Booked Appointements Details ");
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(25, 25, 112));
		lblNewLabel_3.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		lblNewLabel_3.setBounds(0, 0, 650, 70);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Aadhar Card No : ");
		lblNewLabel_5.setBounds(31, 101, 217, 31);
		lblNewLabel_5.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Email Id :");
		lblNewLabel_6.setBounds(31, 142, 219, 36);
		lblNewLabel_6.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5_1 = new JLabel("Vaccine City : ");
		lblNewLabel_5_1.setBounds(31, 200, 217, 22);
		lblNewLabel_5_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_3.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Vaccine Centre : ");
		lblNewLabel_5_2.setBounds(31, 245, 217, 22);
		lblNewLabel_5_2.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_3.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("Date of Appointement : ");
		lblNewLabel_5_3.setBounds(31, 293, 236, 22);
		lblNewLabel_5_3.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_3.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5_4 = new JLabel("Vaccine Type : ");
		lblNewLabel_5_4.setBounds(31, 345, 217, 22);
		lblNewLabel_5_4.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_3.add(lblNewLabel_5_4);
		
		JLabel lblNewLabel_5_5 = new JLabel("Dose Number : ");
		lblNewLabel_5_5.setBounds(31, 391, 217, 22);
		lblNewLabel_5_5.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_3.add(lblNewLabel_5_5);
		
		typeLabel = new JLabel("");
		typeLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		typeLabel.setBounds(275, 345, 352, 31);
		typeLabel.setOpaque(true);
		typeLabel.setBackground(new Color(255, 255, 255));
		panel_3.add(typeLabel);
		
		aadharLabel = new JLabel("");
		aadharLabel.setOpaque(true);
		aadharLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		aadharLabel.setBackground(Color.WHITE);
		aadharLabel.setBounds(275, 101, 352, 31);
		panel_3.add(aadharLabel);
		
		emailLabel = new JLabel("");
		emailLabel.setOpaque(true);
		emailLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		emailLabel.setBackground(Color.WHITE);
		emailLabel.setBounds(275, 147, 352, 31);
		panel_3.add(emailLabel);
		
		cityLabel = new JLabel("");
		cityLabel.setOpaque(true);
		cityLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		cityLabel.setBackground(Color.WHITE);
		cityLabel.setBounds(275, 200, 352, 31);
		panel_3.add(cityLabel);
		
		centreLabel = new JLabel("");
		centreLabel.setOpaque(true);
		centreLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		centreLabel.setBackground(Color.WHITE);
		centreLabel.setBounds(275, 245, 352, 31);
		panel_3.add(centreLabel);
		
		dateLabel = new JLabel("");
		dateLabel.setOpaque(true);
		dateLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		dateLabel.setBackground(Color.WHITE);
		dateLabel.setBounds(277, 293, 352, 31);
		panel_3.add(dateLabel);
		
		doseLabel = new JLabel("");
		doseLabel.setOpaque(true);
		doseLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		doseLabel.setBackground(Color.WHITE);
		doseLabel.setBounds(275, 391, 352, 31);
		panel_3.add(doseLabel);
		
		b1 = new JRadioButton("Dose 1 Details ");
		b1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				try
				{
				Class.forName(driver);
				con=DriverManager.getConnection(url,user,pwd);
				String sql="select * from booking_details";
				pst=con.prepareStatement(sql);
				rs=pst.executeQuery();
				while(rs.next())
				{
					
					String a=rs.getString("aadharNo");
					aadharLabel.setText(a);
					
					
					String b=rs.getString("emailId");
					emailLabel.setText(b);
					
					
					String c=rs.getString("city");
					cityLabel.setText(c);
					
					String d=rs.getString("centre");
					centreLabel.setText(d);
					
					String edate=rs.getString("date");
					dateLabel.setText(edate);
					
					String f=rs.getString("type");
					typeLabel.setText(f);
					
					String g=rs.getString("doseNo");
					doseLabel.setText(g);
				
				}
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		b1.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));		
		b1.setBounds(134, 495, 155, 21);
		panel_2.add(b1);
		
		b2 = new JRadioButton("Dose 2 Details");
		b2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				try
				{
				Class.forName(driver);
				con=DriverManager.getConnection(url,user,pwd);
				String sql="select * from rebooking_details";
				pst=con.prepareStatement(sql);
				rs=pst.executeQuery();
				while(rs.next())
				{
					
//					String a=rs.getString("aadharNo");
//					aadharLabel.setText(a);
					
					
					String b=rs.getString("emailId");
					emailLabel.setText(b);
					
					
					String c=rs.getString("city");
					cityLabel.setText(c);
					
					String d=rs.getString("centre");
					centreLabel.setText(d);
					
					String edate=rs.getString("date");
					dateLabel.setText(edate);
					
					String f=rs.getString("type");
					typeLabel.setText(f);
					
					String g=rs.getString("doseNo");
					doseLabel.setText(g);
				
				}
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		b2.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		b2.setBounds(317, 495, 155, 21);
		panel_2.add(b2);
		
		b3 = new JRadioButton("Booster Details");
		b3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				try
				{
				Class.forName(driver);
				con=DriverManager.getConnection(url,user,pwd);
				String sql="select * from boosterbooking_details";
				pst=con.prepareStatement(sql);
				rs=pst.executeQuery();
				while(rs.next())
				{
					
//					String a=rs.getString("aadharNo");
//					aadharLabel.setText(a);
					
					String b=rs.getString("emailId");
					emailLabel.setText(b);
					
					
					String c=rs.getString("city");
					cityLabel.setText(c);
					
					String d=rs.getString("centre");
					centreLabel.setText(d);
					
					String edate=rs.getString("date");
					dateLabel.setText(edate);
					
					String f=rs.getString("type");
					typeLabel.setText(f);
					
					String g=rs.getString("doseNo");
					doseLabel.setText(g);
				
				}
				}catch(Exception e3){
					e3.printStackTrace();
				}
			}
		});
		b3.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		b3.setBounds(510, 495, 161, 21);
		panel_2.add(b3);
		 
		buttonGroup = new ButtonGroup();
		buttonGroup.add(b1);
		buttonGroup.add(b2);
		buttonGroup.add(b3);

		
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
		
		profileName = new JLabel("");
		profileName.setFont(new Font("Segoe UI Variable", Font.BOLD, 25));
		profileName.setBounds(67, 23, 127, 29);
		panel_1.add(profileName);
		
		regData_display();
		//bookingData_display();
}
}
