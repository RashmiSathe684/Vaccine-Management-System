package com.project.service;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.project.dao.Connectionz;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class LoginPage extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JPasswordField passwordField;	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try
				{
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public void logindetails() {
		String uname=textField.getText();
		String pword=String. valueOf(passwordField. getPassword());
		try 
		{
			con=Connectionz.getConnection();
			Statement stmt=con.createStatement();
			String sql="SELECT * FROM `reg_details` WHERE emailId='"+uname+"' and password ='"+pword+"'";
			rs=stmt.executeQuery(sql);
			
			if(rs.next())
			{
				String s1=rs.getString("emailId");
				String s2=rs.getString("password");
				//String s3=rs.getString("firstname");
				 if(s1.equals(uname) && s2.equals(pword))
				 {
					//JOptionPane.showMessageDialog(null,"Username password Matched");
							DashBoardPage dp=new DashBoardPage();
							dp.setVisible(true);
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
	
	public LoginPage()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250,100,950,650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
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
		panel_1.setBounds(178, 159, 598, 461);
		panel_1.setBackground(new Color(224, 255, 255));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage hp=new HomePage();
				hp.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Rashmi Sathe\\OneDrive\\Pictures\\Saved Pictures\\logout.png"));
		lblNewLabel_1.setBounds(10, 582, 45, 58);
		contentPane.add(lblNewLabel_1);
		
		JLabel plabel = new JLabel("");
		plabel.setBounds(327, 273, 261, 27);
		plabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		plabel.setForeground(new Color(255, 0, 0));
		panel_1.add(plabel);
		setUndecorated(true);
		
		JLabel ulabel = new JLabel("");
		ulabel.setBounds(344, 202, 254, 27);
		panel_1.add(ulabel);
		ulabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		ulabel.setForeground(new Color(255, 0, 0));
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBounds(114, 344, 143, 43);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(50, 205, 50));
		//btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFont(new Font("Segoe UI Variable", Font.BOLD, 22));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
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
					logindetails();
				
			//	s1.setString("username");	
			}
	}
});
		panel_1.setLayout(null);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel1 = new JLabel("USERNAME :-");
		lblNewLabel1.setBounds(125, 161, 167, 43);
		lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel1.setForeground(new Color(0, 0, 0));
		panel_1.add(lblNewLabel1);
		
		JLabel lblNewLabel_9 = new JLabel("PASSWORD :-");
		lblNewLabel_9.setBounds(125, 231, 167, 43);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_9.setForeground(new Color(0, 0, 0));
		panel_1.add(lblNewLabel_9);
		
		textField = new JTextField();
		textField.setBounds(291, 165, 241, 38);
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(textField);
		textField.setColumns(10);
		
		
		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.setBounds(358, 344, 129, 43);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				ulabel.setVisible(false);
				
				passwordField.setText(null);
				plabel.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 22));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		panel_1.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(291, 235, 246, 38);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(passwordField);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(57, 161, 58, 43);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Rashmi Sathe\\OneDrive\\Pictures\\Saved Pictures\\User.png"));
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(57, 232, 48, 54);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Rashmi Sathe\\OneDrive\\Pictures\\Saved Pictures\\Key.png"));
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("Login Page ");
		lblNewLabel_6.setBounds(0, 0, 598, 95);
		lblNewLabel_6.setOpaque(true);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Bookman Old Style", Font.BOLD, 40));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBackground(new Color(0, 128, 128));
		panel_1.add(lblNewLabel_6);
		

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(832, 527, 58, 53);
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage hp=new HomePage();
				hp.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Rashmi Sathe\\OneDrive\\Pictures\\Saved Pictures\\logout.png"));
		panel_1.add(lblNewLabel_5);
		

	
		
		setUndecorated(true);
		

	}
}