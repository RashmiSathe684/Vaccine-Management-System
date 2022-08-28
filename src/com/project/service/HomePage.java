package com.project.service;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class HomePage extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					HomePage frame = new HomePage();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	public HomePage() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250,100,950,650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 952, 123);
		panel.setBackground(new Color(0, 0, 51));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO VACCINATION DRIVE");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 35));
		lblNewLabel.setBounds(94, 36, 736, 65);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 230, 140));
		panel_1.setBounds(0, 122, 952, 528);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrationPage rg=new RegistrationPage();
				rg.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(854, 0, 98, 39);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(186, 85, 211));
		btnNewButton.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		panel_1.add(btnNewButton);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage lp=new LoginPage();
				lp.setVisible(true);
				dispose();
			}
		});
		btnLogin.setBounds(753, 0, 98, 39);
		btnLogin.setBorderPainted(false);
		btnLogin.setBackground(new Color(0, 128, 0));
		btnLogin.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		panel_1.add(btnLogin);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLoginPage ap=new AdminLoginPage();
				ap.setVisible(true);
				dispose();
			}
		});
		btnAdmin.setBounds(651, 0, 98, 39);
		btnAdmin.setBorderPainted(false);
		btnAdmin.setBackground(new Color(255, 140, 0));
		btnAdmin.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		panel_1.add(btnAdmin);
		
		JLabel lblNewLabel_1 = new JLabel("Home : ");
		lblNewLabel_1.setBounds(0, 0, 653, 39);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 37, 340, 491);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Rashmi Sathe\\OneDrive\\Pictures\\Saved Pictures\\bgd.jpg"));
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(339, 179, 613, 349);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Rashmi Sathe\\OneDrive\\Pictures\\Saved Pictures\\dose2.jpg"));
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Protect yourself and other's !!!");
		lblNewLabel_4.setBounds(395, 64, 511, 72);
		lblNewLabel_4.setForeground(new Color(0, 0, 128));
		lblNewLabel_4.setFont(new Font("Segoe UI Variable", Font.BOLD | Font.ITALIC, 35));
		panel_1.add(lblNewLabel_4);
		
		setUndecorated(true);
	}
}
