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
import com.project.dao.LastScheduleDatabase;
import com.project.dao.ReSechduleVaccineDatabase;
import com.project.utility.emailId;
import com.project.utility.lastEmailId;
import com.project.utility.reEmailId;

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

public class Last_Schedule extends JFrame {
	  private static String driver="com.mysql.jdbc.Driver"; 
	  private static String url="jdbc:mysql:///vaccination";
	  private static String user="root";
	  private static String pwd=null;
	  public static String ename3;
		private JRadioButton dose1btn,dose2btn,boosterbtn,CovishieldBtn,CovaxinBtn;
		private JLabel lblNewLabel_4,lblNewLabel_5,lblNewLabel_6,lblNewLabel_7,lblNewLabel_3_1,lblNewLabel_6_1;
		private JButton btnClear,btnNewButton,checkEmailIdBtn;
		
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
	private JLabel EmailidLabelError,VTypeLabelError,DoseLabelError,DateLabelError,CityLabelError;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Last_Schedule frame = new Last_Schedule();
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
	/**
	 * Create the frame.
	 */
	public void display() {
		checkEmailIdBtn.setVisible(false);
		lblNewLabel_4.setVisible(true);
		lblNewLabel_5.setVisible(true);
		lblNewLabel_6.setVisible(true);
		lblNewLabel_7.setVisible(true);
		lblNewLabel_6_1.setVisible(true);
		selectCity.setVisible(true);
		selectCentre.setVisible(true);
		dateOfAppointementField.setVisible(true);
		CovishieldBtn.setVisible(true);
		CovaxinBtn.setVisible(true);
		dose1btn.setVisible(true);
		dose2btn.setVisible(true);
		boosterbtn.setVisible(true);
		btnClear.setVisible(true);
		btnNewButton.setVisible(true);
	}
	
	public Last_Schedule() {
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
		
		JLabel lblNewLabel_2 = new JLabel("Re-Schedule  Vaccine ");
		lblNewLabel_2.setBounds(10, 10, 543, 36);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(72, 61, 139));
		lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		panel_2.add(lblNewLabel_2);
		
		lblNewLabel_4 = new JLabel("Date of Appointment : ");
		lblNewLabel_4.setVisible(false);
		lblNewLabel_4.setBounds(10, 264, 217, 29);
		lblNewLabel_4.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_2.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Vaccine Type : ");
		lblNewLabel_5.setVisible(false);
		lblNewLabel_5.setBounds(10, 317, 201, 35);
		lblNewLabel_5.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_2.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Vaccination Centre : ");
		lblNewLabel_6.setVisible(false);
		lblNewLabel_6.setBounds(10, 219, 201, 35);
		lblNewLabel_6.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_2.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Dose Number  : ");
		lblNewLabel_7.setVisible(false);
		lblNewLabel_7.setBounds(10, 368, 152, 35);
		lblNewLabel_7.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_2.add(lblNewLabel_7);
		
		dateOfAppointementField = new JTextField();
		dateOfAppointementField.setVisible(false);
		dateOfAppointementField.setBounds(231, 269, 313, 29);
		dateOfAppointementField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Date d=new Date();
				SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy");
				dateOfAppointementField.setText(sf.format(d));
			}
		});
		dateOfAppointementField.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		panel_2.add(dateOfAppointementField);
		dateOfAppointementField.setColumns(10);
		
		CovishieldBtn = new JRadioButton("Covishield");
		CovishieldBtn.setVisible(false);
		CovishieldBtn.setBounds(231, 324, 127, 25);
		CovishieldBtn.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		CovishieldBtn.setActionCommand("Covishield");
		panel_2.add(CovishieldBtn);
		
		CovaxinBtn = new JRadioButton("Covaxin");
		CovaxinBtn.setVisible(false);
		CovaxinBtn.setBounds(400, 322, 145, 28);
		CovaxinBtn.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		CovishieldBtn.setActionCommand("Covaxin");
		panel_2.add(CovaxinBtn);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(CovishieldBtn);
		buttonGroup.add(CovaxinBtn);
		
		dose1btn = new JRadioButton("Dose 1");
		dose1btn.setVisible(false);
		dose1btn.setBounds(233, 374, 86, 26);
		
		dose1btn.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		panel_2.add(dose1btn);
		
		
		dose2btn = new JRadioButton("Dose 2");
		dose2btn.setVisible(false);
		dose2btn.setBounds(344, 374, 86, 26);
		
		dose2btn.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		panel_2.add(dose2btn);
		
		boosterbtn = new JRadioButton("Booster ");
		boosterbtn.setVisible(false);
		boosterbtn.setBounds(451, 374, 94, 26);
		
		boosterbtn.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		panel_2.add(boosterbtn);
		
		ButtonGroup buttonGroup_1= new ButtonGroup();
		buttonGroup_1.add(dose1btn);
		buttonGroup_1.add(dose2btn);
		buttonGroup_1.add(boosterbtn);
		

		EmailidLabelError = new JLabel("*Required Field");
		EmailidLabelError.setBounds(431, 104, 122, 21);
		EmailidLabelError.setVisible(false);
		EmailidLabelError.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		EmailidLabelError.setForeground(new Color(255, 0, 0));
		panel_2.add(EmailidLabelError);
		
		VTypeLabelError = new JLabel("*Vaccine Type is not selected");
		VTypeLabelError.setVisible(false);
		VTypeLabelError.setBounds(344, 347, 217, 21);
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
		
		btnNewButton = new JButton("SUBMIT");
		btnNewButton.setVisible(false);
		btnNewButton.setBounds(77, 433, 193, 52);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				 
				 
				
				
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
							
							
						
						
				 
				if(emailIdField.getText().equals(null) &&  selectCity.getSelectedItem().equals(null) && dateOfAppointementField.getText().equals(null) && buttonGroup.isSelected(null) && buttonGroup_1.isSelected(null))
	        	 { 
       		     if(EmailidLabelError.isVisible() && CityLabelError.isVisible() && DateLabelError.isVisible() &&  VTypeLabelError.isVisible() && DoseLabelError.isVisible()) 
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
									 al.add(emailIdField.getText());
									
									 ename3=emailIdField.getText();
									 
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
							         
							     	if(!emailIdField.getText().equals(null) &&  !selectCity.getSelectedItem().equals(null) && !dateOfAppointementField.getText().equals(null) && !buttonGroup.isSelected(null) && !buttonGroup_1.isSelected(null))
						        	 { 
					       		     if(!EmailidLabelError.isVisible() && !CityLabelError.isVisible() && !DateLabelError.isVisible() &&  !VTypeLabelError.isVisible() && !DoseLabelError.isVisible()) 
						        		   {
					       		    	LastScheduleDatabase lsd=new LastScheduleDatabase();
									    lsd.insertIntoLVS(al);
									     JOptionPane.showMessageDialog(null," Submitted");
									 
											     lastEmailId.sendLastEmail(ename3);
									     
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
		
		btnNewButton.setBorderPainted(false);		
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(75, 0, 130));
		btnNewButton.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_2.add(btnNewButton);
		
		btnClear = new JButton("CLEAR");
		btnClear.setVisible(false);
		btnClear.setBounds(315, 433, 193, 52);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
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
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		btnClear.setBorderPainted(false);
		btnClear.setBackground(Color.RED);
		panel_2.add(btnClear);
		
		lblNewLabel_6_1 = new JLabel("Select City :");
		lblNewLabel_6_1.setVisible(false);
		lblNewLabel_6_1.setBounds(10, 174, 201, 35);
		lblNewLabel_6_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_2.add(lblNewLabel_6_1);
		
		String cityOptions[] = { "Solapur", "Mumbai", "Pune"};
		selectCity = new JComboBox(cityOptions);
		selectCity.setVisible(false);
		selectCity.setBounds(232, 172, 313, 35);
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
		panel_2.add(selectCity);
		
		
		selectCentre = new JComboBox();
		selectCentre.setVisible(false);
		selectCentre.setBounds(231, 230, 313, 29);
		selectCentre.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		panel_2.add(selectCentre);
		
		lblNewLabel_3_1 = new JLabel("Enter Email Id : ");
		lblNewLabel_3_1.setBounds(20, 56, 201, 38);
		lblNewLabel_3_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		panel_2.add(lblNewLabel_3_1);
		
		emailIdField = new JTextField();
		emailIdField.setBounds(231, 59, 313, 35);
		emailIdField.setColumns(10);
		panel_2.add(emailIdField);
		
		checkEmailIdBtn = new JButton("Check Email ID");
		checkEmailIdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Validation for Email Id  
				Boolean b;
				 b =Pattern.compile("^[a-zA-Z0-9+_.-]+@(.+)$").matcher(emailIdField.getText()).matches(); 
				 if(b==true) { 
					 EmailidLabelError.setVisible(false);
								}
				 else {
					 EmailidLabelError.setVisible(true);

				 }
				 
				String email=emailIdField.getText();
				String doseType="Dose 2";
				
				try 
				{
					con=Connectionz.getConnection();
					Statement stmt=con.createStatement();
					String sql="SELECT * FROM `rebooking_details` WHERE emailId='"+email+"'";
					rs=stmt.executeQuery(sql);
					
					if(rs.next())
					{
						String s1=rs.getString("emailId");
						String s2=rs.getString("doseNo");
						 if(s1.equals(email))
						 {
							 display();
							if(s2.equalsIgnoreCase(doseType)) {
								dose1btn.setEnabled(false);
								dose2btn.setEnabled(false);
							}
							
						 
					}
					}
					else 
					{
						 JOptionPane.showMessageDialog(null,"Enter correct emailId!!");
					}
				}
				catch(Exception ex)
				{
					System.out.println(" "+ex);
				}
				
			}
		});
		checkEmailIdBtn.setBorderPainted(false);
		checkEmailIdBtn.setBackground(new Color(51, 204, 0));
		checkEmailIdBtn.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		checkEmailIdBtn.setBounds(132, 107, 182, 38);
		panel_2.add(checkEmailIdBtn);
			
	
	}
}
	
