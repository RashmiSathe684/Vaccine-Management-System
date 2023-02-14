package com.project.service;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProfilePage extends JFrame {
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel fnameLbl,lnameLbl,phoneNoLbl,emailIdLbl,dobLbl,genderLbl,addressLbl,profilename;
	private static String driver="com.mysql.jdbc.Driver"; 
	  private static String url="jdbc:mysql:///vaccination";
	  private static String user="root";
	  private static String pwd=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfilePage frame = new ProfilePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void profileData_display() 
	{
	try
	{
	Class.forName(driver);
	con=DriverManager.getConnection(url,user,pwd);
	String sql="select * from reg_details";
	pst=con.prepareStatement(sql);
	rs=pst.executeQuery();
	while(rs.next())
	{
		
		String a=rs.getString("firstname");
		fnameLbl.setText(a);
		
		
		String b=rs.getString("lastname");
		lnameLbl.setText(b);
		
		profilename.setText(a.concat(" ").concat(b));
		
		String c=rs.getString("phoneNo");
		phoneNoLbl.setText(c);
		
		String d=rs.getString("emailId");
		emailIdLbl.setText(d);
		
		String e=rs.getString("dob");
		dobLbl.setText(e);
		
		String f=rs.getString("gender");
		genderLbl.setText(f);
		
		String g=rs.getString("address");
		addressLbl.setText(g);
	
	}
	}catch(Exception e){
		e.printStackTrace();
	}
	}
	/**
	 * Create the frame.
	 */
	public ProfilePage() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250,100,950,650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 160, 122));
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
		panel_1.setBackground(new Color(143, 188, 143));
		panel_1.setBounds(217, 173, 650, 432);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("First Name : ");
		lblNewLabel_5.setBounds(54, 60, 217, 31);
		lblNewLabel_5.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Last Name : ");
		lblNewLabel_6.setBounds(54, 101, 219, 36);
		lblNewLabel_6.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5_1 = new JLabel("Phone No : ");
		lblNewLabel_5_1.setBounds(54, 164, 217, 22);
		lblNewLabel_5_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Email Id : ");
		lblNewLabel_5_2.setBounds(54, 212, 217, 22);
		lblNewLabel_5_2.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_1.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("DOB : ");
		lblNewLabel_5_3.setBounds(54, 258, 217, 22);
		lblNewLabel_5_3.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_1.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5_4 = new JLabel("Gender : ");
		lblNewLabel_5_4.setBounds(54, 299, 217, 22);
		lblNewLabel_5_4.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_1.add(lblNewLabel_5_4);
		
		JLabel lblNewLabel_5_5 = new JLabel("Address : ");
		lblNewLabel_5_5.setBounds(54, 349, 217, 22);
		lblNewLabel_5_5.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_1.add(lblNewLabel_5_5);
		
		fnameLbl = new JLabel("");
		fnameLbl.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		fnameLbl.setBounds(240, 65, 362, 31);
		fnameLbl.setOpaque(true);
		fnameLbl.setBackground(new Color(255, 255, 255));
		panel_1.add(fnameLbl);
		
		lnameLbl = new JLabel("");
		lnameLbl.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		lnameLbl.setBounds(240, 106, 362, 31);
		lnameLbl.setOpaque(true);
		lnameLbl.setBackground(new Color(255, 255, 255));
		panel_1.add(lnameLbl);
		
		 phoneNoLbl = new JLabel("");
		phoneNoLbl.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		phoneNoLbl.setBounds(240, 155, 362, 31);
		phoneNoLbl.setOpaque(true);
		phoneNoLbl.setBackground(new Color(255, 255, 255));
		panel_1.add(phoneNoLbl);
		
		 emailIdLbl = new JLabel("");
		emailIdLbl.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		emailIdLbl.setBounds(240, 203, 362, 31);
		emailIdLbl.setOpaque(true);
		emailIdLbl.setBackground(new Color(255, 255, 255));
		panel_1.add(emailIdLbl);
		
		 dobLbl = new JLabel("");
		dobLbl.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		dobLbl.setBounds(240, 247, 362, 31);
		dobLbl.setOpaque(true);
		dobLbl.setBackground(new Color(255, 255, 255));
		panel_1.add(dobLbl);
		
		 genderLbl = new JLabel("");
		genderLbl.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		genderLbl.setBounds(240, 294, 362, 31);
		genderLbl.setOpaque(true);
		genderLbl.setBackground(new Color(255, 255, 255));
		panel_1.add(genderLbl);
		
		 addressLbl = new JLabel("");
		addressLbl.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		addressLbl.setBounds(240, 340, 362, 31);
		addressLbl.setOpaque(true);
		addressLbl.setBackground(new Color(255, 255, 255));
		panel_1.add(addressLbl);
		
		JLabel lblNewLabel_3 = new JLabel("Profile ");
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(25, 25, 112));
		lblNewLabel_3.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		lblNewLabel_3.setBounds(0, 0, 650, 51);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DashBoardPage dbp=new DashBoardPage();
				dbp.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Rashmi Sathe\\OneDrive\\Pictures\\Saved Pictures\\logout.png"));
		lblNewLabel_1.setBounds(10, 589, 59, 51);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Rashmi Sathe\\OneDrive\\Pictures\\Saved Pictures\\person.png"));
		lblNewLabel_2.setBounds(10, 133, 75, 64);
		contentPane.add(lblNewLabel_2);
		
		profilename = new JLabel("");
		profilename.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		profilename.setBounds(84, 133, 150, 36);
		contentPane.add(profilename);
		profileData_display();
	}
}