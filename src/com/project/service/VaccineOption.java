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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class VaccineOption extends JFrame
{
	//private JFrame frame;
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VaccineOption dframe = new VaccineOption();
					dframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
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
	private JLabel profilename;
	
	public void profile_display() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pwd);
			st=con.createStatement();
			String query="select firstname from reg_details ORDER BY reg_id DESC LIMIT 1";
			rs=st.executeQuery(query);
			while(rs.next()) {
				
				String a=rs.getString("firstname");
				
				profilename.setText(a);
				
				
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
	
	public VaccineOption() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250,100,950,650);
		contentPane = new JPanel();
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
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBounds(0, 125, 950, 525);
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("Dose 1");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(65, 242, 209, 92);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookingVaccineCurrently bp=new BookingVaccineCurrently();
				bp.setVisible(true);
				dispose();
			}
		});
		panel_1.setLayout(null);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Segoe UI Variable", Font.BOLD, 30));
		panel_1.add(btnNewButton);
		
		JButton btnDose = new JButton("Dose 2");
		btnDose.setForeground(Color.WHITE);
		btnDose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NextSchedule ns=new NextSchedule();
				ns.setVisible(true);
				dispose();
			}
		});
		btnDose.setBounds(353, 242, 209, 92);
		btnDose.setBorderPainted(false);
		btnDose.setBackground(new Color(0, 0, 128));
		btnDose.setFont(new Font("Segoe UI Variable", Font.BOLD, 30));
		panel_1.add(btnDose);
		
		JButton btnDose_1 = new JButton("Booster");
		btnDose_1.setForeground(Color.WHITE);
		btnDose_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Last_Schedule ls=new Last_Schedule();
				ls.setVisible(true);
				dispose();
			}
		});
		btnDose_1.setBounds(649, 242, 209, 92);
		btnDose_1.setBackground(new Color(0, 0, 139));
		btnDose_1.setBorderPainted(false);
		btnDose_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 30));
		panel_1.add(btnDose_1);
		
		JLabel lblNewLabel_2 = new JLabel("Select the Vaccine Type : -");
		lblNewLabel_2.setBounds(69, 140, 533, 79);
		lblNewLabel_2.setForeground(new Color(0, 0, 139));
		lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.BOLD, 35));
		panel_1.add(lblNewLabel_2);
		
		

		
	
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(10, 466, 76, 53);
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DashBoardPage dp=new DashBoardPage();
				dp.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Rashmi Sathe\\OneDrive\\Pictures\\Saved Pictures\\logout.png"));
		panel_1.add(lblNewLabel_6); 
		
		
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(10, 10, 76, 64);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Rashmi Sathe\\OneDrive\\Pictures\\Saved Pictures\\person.png"));
		panel_1.add(lblNewLabel_4);
		
		profilename = new JLabel("");
		profilename.setForeground(new Color(0, 0, 128));
		profilename.setFont(new Font("Segoe UI Variable", Font.BOLD, 30));
		profilename.setBounds(83, 10, 175, 52);
		panel_1.add(profilename);
		setUndecorated(true);
		profile_display();
		
	
	}
}
