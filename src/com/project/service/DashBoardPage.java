package com.project.service;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class DashBoardPage extends JFrame
{
	//private JFrame frame;
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoardPage dframe = new DashBoardPage();
					dframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con=null;
	PreparedStatement ps=null;
	Statement st=null;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public DashBoardPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250,100,950,650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 950, 123);
		contentPane.add(panel);
		panel.setLayout(null);
		

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 121, 307, 529);
		contentPane.add(panel_1); 
		panel_1.setLayout(null); 
		
		JPanel panel_2 = new JPanel();
		panel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		panel_2.setBackground(new Color(255, 228, 225));
		panel_2.setBounds(305, 121, 645, 529);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(0, 71, 479, 458);
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Rashmi Sathe\\OneDrive\\Pictures\\Saved Pictures\\img.png"));
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel(" Welcome to covid -19 vaccination centre..");
		lblNewLabel_7.setForeground(new Color(0, 0, 128));
		lblNewLabel_7.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 32));
		lblNewLabel_7.setBounds(0, 0, 645, 72);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("The");
		lblNewLabel_8.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_8.setBounds(489, 204, 124, 49);
		panel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Vaccines");
		lblNewLabel_9.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_9.setBounds(489, 250, 129, 49);
		panel_2.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("protects");
		lblNewLabel_10.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_10.setBounds(489, 297, 129, 49);
		panel_2.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("you..!!");
		lblNewLabel_11.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_11.setBounds(489, 341, 129, 55);
		panel_2.add(lblNewLabel_11);
		
		JLabel lblNewLabel = new JLabel("MAHA VACCINATION PORTAL");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 35));
		lblNewLabel.setBounds(94, 36, 736, 65);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Schedule Vaccine ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VaccineOption vp=new VaccineOption();
				vp.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		btnNewButton.setBounds(70, 143, 225, 45);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Appointment ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewBookedAppointement Vframe=new ViewBookedAppointement();
				Vframe.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		btnNewButton_1.setBounds(70, 215, 225, 45);
		panel_1.add(btnNewButton_1);
		setUndecorated(true);
		
		
		

		JLabel lblNewLabel_1 = new JLabel("Profile");
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1.addMouseListener(new MouseAdapter() 
		{
				public void mouseClicked(MouseEvent e)
				{
					ProfilePage Profileframe = new ProfilePage();
					Profileframe.setVisible(true);	
					dispose();				}
			});
		lblNewLabel_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 25));
		lblNewLabel_1.setBounds(83, 16, 94, 33);
		panel_1.add(lblNewLabel_1);
	
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage lp=new HomePage();
				lp.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Rashmi Sathe\\OneDrive\\Pictures\\Saved Pictures\\logout.png"));
		lblNewLabel_6.setBounds(10, 466, 76, 53);
		panel_1.add(lblNewLabel_6); 
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Rashmi Sathe\\OneDrive\\Pictures\\Saved Pictures\\schedule.png"));
		lblNewLabel_2.setBounds(10, 143, 65, 45);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Rashmi Sathe\\OneDrive\\Pictures\\Saved Pictures\\view.png"));
		lblNewLabel_3.setBounds(10, 215, 70, 45);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Rashmi Sathe\\OneDrive\\Pictures\\Saved Pictures\\person.png"));
		lblNewLabel_4.setBounds(10, 10, 76, 64);
		panel_1.add(lblNewLabel_4);
		setUndecorated(true);
		
		
	
	}
}
