package com.project.service;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AdminLoginPage extends JFrame {
	private static String driver="com.mysql.jdbc.Driver"; 
	private static String url="jdbc:mysql:///vaccination";
	private static String user="root";
	private static String pwd=null;
	Connection con=null;
	ResultSet rs=null;
	Statement st=null;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLoginPage frame = new AdminLoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void Adminlogindetails() 
	{
		String uname=textField.getText();
		String pword=String. valueOf(passwordField. getPassword());
		try 
		{
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pwd);
			st=con.createStatement();
			String sql="SELECT * FROM `admin` WHERE username='"+uname+"' and password ='"+pword+"'";
			rs=st.executeQuery(sql);
			
			if(rs.next())
			{
				String s1=rs.getString("username");
				String s2=rs.getString("password");
				 if(s1.equals(uname) && s2.equals(pword))
				 {
							AdminPage ap=new AdminPage();
							ap.setVisible(true);
							dispose();							
				}
			}
			else 
			{
				 JOptionPane.showMessageDialog(null,"Username password Not Matched");
			}
		}
		catch(Exception ex)
		{
			System.out.println(" "+ex);
		}
		
	}

	public AdminLoginPage() {
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
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(176, 158, 637, 463);
		panel_1.setBackground(new Color(211, 211, 211));
		contentPane.add(panel_1);
		setUndecorated(true);
		panel_1.setLayout(null);
		
		
		JLabel ulabel = new JLabel("");
		ulabel.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		ulabel.setForeground(new Color(255, 0, 0));
		ulabel.setBounds(365, 222, 262, 24);
		panel_1.add(ulabel);
		
		JLabel plabel = new JLabel("");
		plabel.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		plabel.setForeground(new Color(255, 0, 0));
		plabel.setBounds(365, 305, 262, 24);
		panel_1.add(plabel);
		
		
		JButton loginbtn = new JButton("LOGIN");
		loginbtn.setBorderPainted(false);
		loginbtn.setBackground(new Color(50, 205, 50));
		loginbtn.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String password=new String(passwordField.getPassword());
				if(textField.getText().trim().isEmpty() && password.equals("")) 
				{
					ulabel.setText("*Username is empty");
					plabel.setText("*Password is empty");
				}
				else if(textField.getText().trim().isEmpty())
				{
					ulabel.setText("*Username is empty");
				}
				else if(password.equals("")) 
				{
				plabel.setText("*Password is empty");
				}
				else 
				{
					Adminlogindetails();
				
			//	s1.setString("username");	
			}
			}
		});
		loginbtn.setBounds(119, 365, 167, 59);
		panel_1.add(loginbtn);
		
		
		JLabel uname = new JLabel("USERNAME : ");
		uname.setBounds(92, 178, 167, 43);
		uname.setFont(new Font("Tahoma", Font.BOLD, 22));
		uname.setForeground(new Color(0, 0, 128));
		panel_1.add(uname);
		
		JLabel pname = new JLabel("PASSWORD : ");
		pname.setBounds(92, 252, 167, 43);
		pname.setFont(new Font("Tahoma", Font.BOLD, 22));
		pname.setForeground(new Color(0, 0, 128));
		panel_1.add(pname);
		
		textField = new JTextField();
		textField.setBounds(256, 182, 277, 38);
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton resetbtn = new JButton("RESET");
		resetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				ulabel.setVisible(false);
				
				passwordField.setText(null);
				plabel.setVisible(false);
			}
		});
		resetbtn.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		resetbtn.setBorderPainted(false);
		resetbtn.setBackground(new Color(220, 20, 60));
		resetbtn.setBounds(386, 365, 167, 59);
		panel_1.add(resetbtn);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(256, 256, 277, 38);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(passwordField);
		
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(24, 178, 58, 43);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Rashmi Sathe\\OneDrive\\Pictures\\Saved Pictures\\User.png"));
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(24, 245, 48, 54);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Rashmi Sathe\\OneDrive\\Pictures\\Saved Pictures\\Key.png"));
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Admin Login Page");
		lblNewLabel_3.setBounds(24, 10, 579, 95);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Bookman Old Style", Font.BOLD, 40));
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(20, 564, 59, 76);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage hp=new HomePage();
				hp.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Rashmi Sathe\\OneDrive\\Pictures\\Saved Pictures\\logout.png"));
		contentPane.add(lblNewLabel_1);
		
	
		
	}
}
