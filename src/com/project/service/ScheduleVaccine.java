package com.project.service;
import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import com.project.dao.DataBaseScheduleAppointement;
import com.project.utility.emailId;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScheduleVaccine extends JFrame {
	  private static String driver="com.mysql.jdbc.Driver"; 
	  private static String url="jdbc:mysql:///vaccination";
	  private static String user="root";
	  private static String pwd=null;
	  public static String ename;
	  String Vaccine;
	  String sql1;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs1=null;
		Statement stmt=null;
		ResultSet rs=null;
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScheduleVaccine frame = new ScheduleVaccine();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void showDate()
	{
		Date d=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy");
		textField_1.setText(sf.format(d));
	}
	/**
	 * Create the frame.
	 */
	public ScheduleVaccine() {
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 123, 228, 95);
		panel.add(panel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 160, 122));
		panel_1.setBounds(0, 122, 950, 528);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(206, 10, 568, 508);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Schedule Vaccine ");
		lblNewLabel_2.setBounds(10, 10, 543, 35);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(72, 61, 139));
		lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Aadhar Card No : ");
		lblNewLabel_3.setBounds(10, 104, 233, 29);
		lblNewLabel_3.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date of Appointment : ");
		lblNewLabel_4.setBounds(10, 170, 217, 29);
		lblNewLabel_4.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Vaccine Type : ");
		lblNewLabel_5.setBounds(10, 213, 201, 35);
		lblNewLabel_5.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Vaccination Centre : ");
		lblNewLabel_6.setBounds(10, 276, 201, 35);
		lblNewLabel_6.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Dose Number  : ");
		lblNewLabel_7.setBounds(10, 339, 152, 35);
		lblNewLabel_7.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("*Incorrect Aadhar Card No");
		lblNewLabel_8.setBounds(347, 141, 206, 21);
		lblNewLabel_8.setVisible(false);
		lblNewLabel_8.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		lblNewLabel_8.setForeground(new Color(255, 0, 0));
		panel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("*Vaccine Type is not selected");
		lblNewLabel_9.setBounds(336, 253, 217, 21);
		lblNewLabel_9.setVisible(false);
		lblNewLabel_9.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		lblNewLabel_9.setForeground(new Color(255, 0, 0));
		panel_2.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("*Incorrect Vaccination centre - Re Enter ");
		lblNewLabel_10.setBounds(263, 317, 295, 24);
		lblNewLabel_10.setVisible(false);
		lblNewLabel_10.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		lblNewLabel_10.setForeground(new Color(255, 0, 0));
		panel_2.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("*Dose Number is not selected ");
		lblNewLabel_11.setBounds(336, 373, 217, 24);
		lblNewLabel_11.setVisible(false);
		lblNewLabel_11.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		lblNewLabel_11.setForeground(new Color(255, 0, 0));
		panel_2.add(lblNewLabel_11);
		
		
		textField = new JTextField();
		textField.setBounds(248, 108, 305, 32);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(248, 172, 305, 27);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JRadioButton CovishieldBtn = new JRadioButton("Covishield");
		CovishieldBtn.setBounds(248, 220, 122, 24);
		CovishieldBtn.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		CovishieldBtn.setActionCommand("Covishield");
		panel_2.add(CovishieldBtn);
		
		JRadioButton CovaxinBtn = new JRadioButton("Covaxin");
		CovaxinBtn.setBounds(408, 216, 145, 28);
		CovaxinBtn.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		CovishieldBtn.setActionCommand("Covaxin");
		panel_2.add(CovaxinBtn);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(CovishieldBtn);
		buttonGroup.add(CovaxinBtn);
		
		textField_2 = new JTextField();
		textField_2.setBounds(248, 280, 305, 27);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JRadioButton dose1btn = new JRadioButton("Dose 1");
		dose1btn.setBounds(242, 346, 96, 21);
		
		dose1btn.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		panel_2.add(dose1btn);
		
		
		JRadioButton dose2btn = new JRadioButton("Dose 2");
		dose2btn.setBounds(347, 346, 96, 21);
		
		dose2btn.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		panel_2.add(dose2btn);
		
		JRadioButton boosterbtn = new JRadioButton("Booster ");
		boosterbtn.setBounds(450, 346, 103, 21);
		
		boosterbtn.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		panel_2.add(boosterbtn);
		
		ButtonGroup buttonGroup_1= new ButtonGroup();
		buttonGroup_1.add(dose1btn);
		buttonGroup_1.add(dose2btn);
		buttonGroup_1.add(boosterbtn);
		
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DashBoardPage dbp=new DashBoardPage();
				dbp.setVisible(true);
				dispose();
				
			}
		});
		lblNewLabel_13.setBounds(10, 464, 48, 54);
		lblNewLabel_13.setIcon(new ImageIcon("C:\\Users\\Rashmi Sathe\\OneDrive\\Pictures\\Saved Pictures\\logout.png"));
		panel_1.add(lblNewLabel_13);
		
		JLabel profilenamelabel= new JLabel("");
		profilenamelabel.setBounds(83, 10, 131, 29);
		panel_1.add(profilenamelabel);
		
		JLabel lblNewLabel_3_1 = new JLabel("Enter Email Id : ");
		lblNewLabel_3_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(10, 54, 233, 29);
		panel_2.add(lblNewLabel_3_1);
		
		JLabel EmailidLabelError = new JLabel("*Required Field");
		EmailidLabelError.setBounds(431, 83, 122, 21);
		EmailidLabelError.setVisible(false);
		EmailidLabelError.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		EmailidLabelError.setForeground(new Color(255, 0, 0));
		panel_2.add(EmailidLabelError);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(237, 55, 305, 32);
		panel_2.add(textField_3);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setBounds(84, 418, 193, 52);
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				showDate();
				boolean b;
				//Validation for Email Id  
				 b =Pattern.compile("^[a-zA-Z0-9+_.-]+@(.+)$").matcher(textField_3.getText()).matches(); 
				 if(b==true) { 
					 EmailidLabelError.setVisible(false);
								}
				 else {
					 EmailidLabelError.setVisible(true);

				 }
				
				//Validation for Aadhar Card No 
				 b =Pattern.compile("^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$").matcher(textField.getText()).matches(); 
				 if(b==true) { 
					 lblNewLabel_8.setVisible(false);
						}
				 else {
					 lblNewLabel_8.setVisible(true);

				 }
				 //No Validation for Date of Appointement 
				//Validation for vaccine type
					if(buttonGroup.isSelected(null))
					{
						lblNewLabel_9.setVisible(true);
					}
					else {
						lblNewLabel_9.setVisible(false);
					}
					
					//Validation for Vaccine Centre
					 b =Pattern.compile("^[A-Za-z]{2,29}$").matcher(textField_2.getText()).matches(); 
					 if(b==true) { 
						 lblNewLabel_10.setVisible(false);
							}
					 else {
						 lblNewLabel_10.setVisible(true);
					 }
					 
					 
					//Validation for Dose No
						if(buttonGroup_1.isSelected(null))
						{
							lblNewLabel_11.setVisible(true);
						}
						else {
							lblNewLabel_11.setVisible(false);
						}
						

						 if(textField.getText().equals(null) &&  buttonGroup.isSelected(null) &&  textField_2.getText().equals(null) && buttonGroup_1.isSelected(null))
			        	 { 
		        		     if(lblNewLabel_8.isVisible() && lblNewLabel_9.isVisible() && lblNewLabel_10.isVisible() &&  lblNewLabel_11.isVisible()) 
			        		   {

		        		    	 	JOptionPane.showMessageDialog(null,"Not Submitted");
			        		   }
				      
				        
				        
		        		 }
						 else
		        		 {

					      /*   String Vaccine=buttonGroup.getSelection().getActionCommand();
					         String center=textField_2.getText();
					         String Adhar=textField.getText();
					         String date=textField_1.getText();
					         
					         avaiblity a=new avaiblity();
					         a.avaiblityStock(Vaccine,center,Adhar,date);
					         */
							 
							 try 
								{
								 	int stock=0;
								 	Class.forName(driver);
									con=DriverManager.getConnection(url,user,pwd);
									stmt=con.createStatement();
									
							
								 	if(CovishieldBtn.isSelected())
									 {
								 		Vaccine=CovishieldBtn.getText();
								 		String sql="SELECT stock FROM `stocks` WHERE vaccineName='"+Vaccine+"'";
										rs=stmt.executeQuery(sql);
										 // String sql1="UPDATE stocks set stock=stock-1 WHERE vaccineName='"+Vaccine+"'";
											
									 }
									 else 
									 {
										 Vaccine=CovaxinBtn.getText();
										 String sql="SELECT stock FROM `stocks` WHERE vaccineName='"+Vaccine+"'";
											rs=stmt.executeQuery(sql);
											// String sql1="UPDATE stocks set stock=stock-1 WHERE vaccineName='"+Vaccine+"'";
												//rs1=stmt.executeQuery(sql1);
									 }
									if(rs.next())
									{
										String s1=rs.getString("stock");
										stock=Integer.parseInt(s1);
										//String s3=rs.getString("firstname");
										 if(stock>0)
										 {
											//update stock code
											 sql1="UPDATE stocks set stock=stock-1 WHERE vaccineName='"+Vaccine+"'";
											 stmt.executeUpdate(sql1);
											 
											//JOptionPane.showMessageDialog(null,"Username password Matched");
											 ArrayList<String> al=new ArrayList<String>();
											 al.add(textField_3.getText());
											 
											 ename=textField_3.getText();
											 
									 		 al.add(textField.getText());
									         al.add(textField_1.getText());
									         
									         if(CovishieldBtn.isSelected())
											 {
												 al.add(CovishieldBtn.getText());
											 }
											 else 
											 {
												 al.add(CovaxinBtn.getText());
											 }
									         
									         al.add(textField_2.getText());
									         
									         if(dose1btn.isSelected())
											{
												 al.add(dose1btn.getText());
											 }
											 else if(dose2btn.isSelected())
											 {
												 al.add(dose2btn.getText());
											 }
											 else
											 {
												 al.add(boosterbtn.getText());
											 }
									         
									         
									     
									         
								        	 if(!textField.getText().equals(null) && !buttonGroup.isSelected(null) &&  !textField_2.getText().equals(null) && !buttonGroup_1.isSelected(null) )
								        	 { 
								        		 if(!lblNewLabel_8.isVisible() && !lblNewLabel_9.isVisible() && !lblNewLabel_10.isVisible() &&  !lblNewLabel_11.isVisible()) 
								        		   {
								        			
										    	 DataBaseScheduleAppointement ig=new DataBaseScheduleAppointement();
											     ig.insertIntoSV(al);
											     JOptionPane.showMessageDialog(null," Submitted");
											     
											//   emailId e1=new emailId()
;											     emailId.sendEmail(ename);
											     
								        		   }
								        	 else 
							        		 {
							        			 JOptionPane.showMessageDialog(null,"Not Submitted");
							        		 }
								        	 }									
										}
										 else 
											{
												 JOptionPane.showMessageDialog(null,"	Insuffiecient stock!!");
											}
									}
									
								}
								catch(Exception ex)
								{
									ex.printStackTrace();
								}
					         
		        			
		        		 }	
						 
			}
		});  
		btnNewButton.setBorderPainted(false);		
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(75, 0, 130));
		btnNewButton.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_2.add(btnNewButton);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(315, 418, 193, 52);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setText(null);
				EmailidLabelError.setVisible(false);
				
				textField.setText(null);
				lblNewLabel_8.setVisible(false);

				textField_1.setText(null);
				//.setVisible(false);

				buttonGroup.clearSelection();								    
				lblNewLabel_9.setVisible(false);
				
				textField_2.setText(null);
				lblNewLabel_10.setVisible(false);
				
				buttonGroup_1.clearSelection();
				lblNewLabel_11.setVisible(false);
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		btnClear.setBorderPainted(false);
		btnClear.setBackground(Color.RED);
		panel_2.add(btnClear);
		

		//showDate();
		
	}
}
	
