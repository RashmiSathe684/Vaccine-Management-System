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

import com.project.dao.Connectionz;
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

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;

public class BookingVaccineCurrently extends JFrame {
	  private static String driver="com.mysql.jdbc.Driver"; 
	  private static String url="jdbc:mysql:///vaccination";
	  private static String user="root";
	  private static String pwd=null;
	  public static String ename;
	  String Vaccine;
	  String sql1;
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement pst=null;
		ResultSet rs1=null;
		Statement stmt=null;
		ResultSet rs=null;
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField dateOfAppointementField;
	static JComboBox selectCity,selectCentre;
	private JTextField emailIdField;
	private JTextField aadharNoField;
	private JLabel EmailidLabelError,AadharLabelError,VTypeLabelError,DoseLabelError,DateLabelError,CityLabelError;
	private ButtonGroup buttonGroup_1;
	private JRadioButton dose1btn,dose2btn,boosterbtn;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingVaccineCurrently frame = new BookingVaccineCurrently();
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
		dateOfAppointementField.setText(sf.format(d));
	}
	
	public BookingVaccineCurrently() {
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
		
		JLabel lblNewLabel_2 = new JLabel("Book  Vaccine ");
		lblNewLabel_2.setBounds(10, 10, 543, 29);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(72, 61, 139));
		lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Date of Appointment : ");
		lblNewLabel_4.setBounds(10, 264, 217, 29);
		lblNewLabel_4.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Vaccine Type : ");
		lblNewLabel_5.setBounds(10, 317, 201, 35);
		lblNewLabel_5.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Vaccination Centre : ");
		lblNewLabel_6.setBounds(10, 219, 201, 35);
		lblNewLabel_6.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Dose Number  : ");
		lblNewLabel_7.setBounds(10, 368, 152, 35);
		lblNewLabel_7.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_2.add(lblNewLabel_7);
		
		dateOfAppointementField = new JTextField();
		dateOfAppointementField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Date d=new Date();
				SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy");
				dateOfAppointementField.setText(sf.format(d));
			}
		});
		dateOfAppointementField.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		dateOfAppointementField.setBounds(231, 269, 313, 29);
		panel_2.add(dateOfAppointementField);
		dateOfAppointementField.setColumns(10);
		
		JRadioButton CovishieldBtn = new JRadioButton("Covishield");
		CovishieldBtn.setBounds(231, 324, 127, 25);
		CovishieldBtn.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		CovishieldBtn.setActionCommand("Covishield");
		panel_2.add(CovishieldBtn);
		
		JRadioButton CovaxinBtn = new JRadioButton("Covaxin");
		CovaxinBtn.setBounds(400, 322, 145, 28);
		CovaxinBtn.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		CovishieldBtn.setActionCommand("Covaxin");
		panel_2.add(CovaxinBtn);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(CovishieldBtn);
		buttonGroup.add(CovaxinBtn);
		
		dose1btn = new JRadioButton("Dose 1");
		dose1btn.setBounds(233, 374, 86, 26);
		
		dose1btn.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		panel_2.add(dose1btn);
		
		
		dose2btn = new JRadioButton("Dose 2");
		dose2btn.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
			dose2btn.setEnabled(false);
			}
		});
		dose2btn.setBounds(344, 374, 86, 26);
		
		dose2btn.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		panel_2.add(dose2btn);
		
		boosterbtn = new JRadioButton("Booster ");
		boosterbtn.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				boosterbtn.setEnabled(false);
			}
		});
		boosterbtn.setBounds(451, 374, 94, 26);
		
		boosterbtn.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		panel_2.add(boosterbtn);
		
		buttonGroup_1= new ButtonGroup();
		buttonGroup_1.add(dose1btn);
		buttonGroup_1.add(dose2btn);
		buttonGroup_1.add(boosterbtn);
		

		EmailidLabelError = new JLabel("*Required Field");
		EmailidLabelError.setBounds(431, 151, 122, 21);
		EmailidLabelError.setVisible(false);
		EmailidLabelError.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		EmailidLabelError.setForeground(new Color(255, 0, 0));
		panel_2.add(EmailidLabelError);
		
		AadharLabelError = new JLabel("*Incorrect Aadhar Card No");
		AadharLabelError.setBounds(344, 88, 206, 21);
		AadharLabelError.setVisible(false);
		AadharLabelError.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		AadharLabelError.setForeground(new Color(255, 0, 0));
		panel_2.add(AadharLabelError);
		
		VTypeLabelError = new JLabel("*Vaccine Type is not selected");
		VTypeLabelError.setBounds(344, 347, 217, 21);
		VTypeLabelError.setVisible(false);
		VTypeLabelError.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		VTypeLabelError.setForeground(new Color(255, 0, 0));
		panel_2.add(VTypeLabelError);
		
		DoseLabelError = new JLabel("*Dose Number is not selected ");
		DoseLabelError.setBounds(336, 400, 217, 23);
		DoseLabelError.setVisible(false);
		DoseLabelError.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		DoseLabelError.setForeground(new Color(255, 0, 0));
		panel_2.add(DoseLabelError);
		
		DateLabelError = new JLabel("*Required Field");
		DateLabelError.setBounds(412, 295, 146, 21);
		DateLabelError.setVisible(false);
		DateLabelError.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		DateLabelError.setForeground(new Color(255, 0, 0));
		panel_2.add(DateLabelError);
		

		CityLabelError = new JLabel("*City is not selected");
		CityLabelError.setBounds(397, 205, 164, 21);
		CityLabelError.setVisible(false);
		CityLabelError.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		CityLabelError.setForeground(new Color(255, 0, 0));
		panel_2.add(CityLabelError);
		
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
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean b;
				//Validation for Aadhar Card No 
				 b =Pattern.compile("^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$").matcher(aadharNoField.getText()).matches(); 
				 if(b==true) { 
					 AadharLabelError.setVisible(false);
						}
				 else {
					 AadharLabelError.setVisible(true);

				 }
				 
				 
				//Validation for Email Id  
				 b =Pattern.compile("^[a-zA-Z0-9+_.-]+@(.+)$").matcher(emailIdField.getText()).matches(); 
				 if(b==true) { 
					 EmailidLabelError.setVisible(false);
								}
				 else {
					 EmailidLabelError.setVisible(true);

				 }
				
				//Validation for vaccine city
					if(selectCentre.getSelectedItem()== null)
					{
						CityLabelError.setVisible(true);
					}
					else {
						CityLabelError.setVisible(false);
					}
					

					//Validation for Date of Appointement
					if(dateOfAppointementField.getText().equals(""))
					{
						DateLabelError.setVisible(true);
					}
					else {
						DateLabelError.setVisible(false);
					}
					
						//Validation for vaccine type
						if(buttonGroup.isSelected(null))
						{
							VTypeLabelError.setVisible(true);
						}
						else {
							VTypeLabelError.setVisible(false);
						}
						
					
						//Validation for Dose No
						if(buttonGroup.isSelected(null)) {
							DoseLabelError.setVisible(true);
						}
						else {
							DoseLabelError.setVisible(false);
						}
							
							
						
						
				 
				if(aadharNoField.getText().equals(null) && emailIdField.getText().equals(null) &&  selectCity.getSelectedItem().equals(null) && dateOfAppointementField.getText().equals(null) && buttonGroup.isSelected(null) && buttonGroup_1.isSelected(null))
	        	 { 
       		     if(AadharLabelError.isVisible() && EmailidLabelError.isVisible() && CityLabelError.isVisible() && DateLabelError.isVisible() &&  VTypeLabelError.isVisible() && DoseLabelError.isVisible()) 
	        		   {

       		    	 	JOptionPane.showMessageDialog(null,"Not Submitted");
	        		   }
		      
		        
		        
       		 }
				 else
       		 {
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
								 if(stock>0)
								 {
									//update stock code
									 sql1="UPDATE stocks set stock=stock-1 WHERE vaccineName='"+Vaccine+"'";
									 stmt.executeUpdate(sql1);
									 
									 ArrayList<String> al=new ArrayList<String>();
									 al.add(aadharNoField.getText());
									 al.add(emailIdField.getText());
									 
									 ename=emailIdField.getText();
									 
							 		 al.add((String) selectCity.getSelectedItem());
							         al.add((String) selectCentre.getSelectedItem());
							         al.add(dateOfAppointementField.getText());
							         
							         if(CovishieldBtn.isSelected())
									 {
										 al.add(CovishieldBtn.getText());
									 }
									 else 
									 {
										 al.add(CovaxinBtn.getText());
									 }
							         
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
							         
							     	if(!aadharNoField.getText().equals(null) && !emailIdField.getText().equals(null) &&  !selectCity.getSelectedItem().equals(null) && !dateOfAppointementField.getText().equals(null) && !buttonGroup.isSelected(null) && !buttonGroup_1.isSelected(null))
						        	 { 
					       		     if(!AadharLabelError.isVisible() && !EmailidLabelError.isVisible() && !CityLabelError.isVisible() && !DateLabelError.isVisible() &&  !VTypeLabelError.isVisible() && !DoseLabelError.isVisible()) 
						        		   {
						        			
								    	 DataBaseScheduleAppointement ig=new DataBaseScheduleAppointement();
									     ig.insertIntoSV(al);
									     JOptionPane.showMessageDialog(null," Submitted");
									 
											     emailId.sendEmail(ename);
									     
						        		   }
						        	 else 
					        		 {
					        			 JOptionPane.showMessageDialog(null,"Not Submitted");
					        		 }
						        	 }									
								} 
								 else 
									{
										 JOptionPane.showMessageDialog(null,"Insuffiecient stock!!");
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
		btnNewButton.setBounds(77, 433, 193, 52);
		
		btnNewButton.setBorderPainted(false);		
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(75, 0, 130));
		btnNewButton.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_2.add(btnNewButton);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aadharNoField.setText(null);
				AadharLabelError.setVisible(false);
				
				emailIdField.setText(null);
				EmailidLabelError.setVisible(false);

				//selectCity.setSelectedItem(null);
				CityLabelError.setVisible(false);

				selectCentre.setSelectedItem(null);
				
				dateOfAppointementField.setText(null);
				DateLabelError.setVisible(false);
				
				buttonGroup.clearSelection();								    
				VTypeLabelError.setVisible(false);
												
				buttonGroup_1.clearSelection();
				DoseLabelError.setVisible(false);
			}
		});
		btnClear.setBounds(315, 433, 193, 52);
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		btnClear.setBorderPainted(false);
		btnClear.setBackground(Color.RED);
		panel_2.add(btnClear);
		
		JLabel lblNewLabel_6_1 = new JLabel("Select City :");
		lblNewLabel_6_1.setBounds(10, 174, 201, 35);
		lblNewLabel_6_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_2.add(lblNewLabel_6_1);
		
		String cityOptions[] = { "Solapur", "Mumbai", "Pune"};
		selectCity = new JComboBox(cityOptions);
		selectCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						if(selectCity.getSelectedItem().equals("Solapur")) {
							selectCentre.removeAllItems();
							selectCentre.setSelectedItem(null);
							selectCentre.addItem("Shahu Hospital");
							selectCentre.addItem("Ashwini Sahakari Rugnalaya");
							selectCentre.addItem("Monarch Hospital");
							selectCentre.addItem("Darasha Maternity Hospital");
							selectCentre.addItem("Care Hospital");
							selectCentre.addItem("Shri Chhatrapati Shivaji Maharaj Sarvopchar Rugnalay");
						}
						else if(selectCity.getSelectedItem().equals("Mumbai")) {
							selectCentre.removeAllItems();
							selectCentre.setSelectedItem(null);
							selectCentre.addItem("Lifeline Medicare Hospital");
							selectCentre.addItem("Shree Sai Clinic");
							selectCentre.addItem("Nanavati Max Super Speciality Hospital");
							selectCentre.addItem("Breach Candy Hospital");
							selectCentre.addItem("Global Hospital");
						}else if(selectCity.getSelectedItem().equals("Pune")) {
							selectCentre.removeAllItems();
								selectCentre.setSelectedItem(null);
								selectCentre.addItem("Manipal Hospital");
								selectCentre.addItem("Villoo Poonawalla Memorial Hospital");
								selectCentre.addItem("Medicare Hospital - Multi Speciality Hospita");
								selectCentre.addItem("Ruby Hall Clinic");
								selectCentre.addItem("Noble Hospitals & Research Centre");
						}
			}
		});
		selectCity.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		selectCity.setBounds(232, 172, 313, 35);
		panel_2.add(selectCity);
		
		
		selectCentre = new JComboBox();
		selectCentre.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		selectCentre.setBounds(231, 230, 313, 29);
		panel_2.add(selectCentre);
		
		JLabel lblNewLabel_3_1 = new JLabel("Enter Email Id : ");
		lblNewLabel_3_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(10, 113, 233, 29);
		panel_2.add(lblNewLabel_3_1);
		
		emailIdField = new JTextField();
		emailIdField.setColumns(10);
		emailIdField.setBounds(232, 115, 313, 35);
		panel_2.add(emailIdField);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Aadhar Card No : ");
		lblNewLabel_3.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 55, 233, 29);
		panel_2.add(lblNewLabel_3);
		
		aadharNoField = new JTextField();
		aadharNoField.setColumns(10);
		aadharNoField.setBounds(231, 59, 310, 32);
		panel_2.add(aadharNoField);
			
		
	}
}
	
