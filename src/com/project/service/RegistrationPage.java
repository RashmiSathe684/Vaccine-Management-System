package com.project.service;


import com.project.dao.*;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.util.ArrayList;
import java.util.regex.Pattern;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class RegistrationPage extends JFrame 
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel LastNameLabelError,PhoneNoLabelError,dobLabelError,GenderLabelError,AddressLabelError,PassLabelError,CPassLabelError,FirstNameLabelError,EmailidLabelError;
	private JTextField FnametextField;
	private JTextField LnametextField;
	private JTextField PhoneNotextField;
	private JTextField EmailIdtextField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	
	
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				try 
				{
					RegistrationPage frame = new RegistrationPage();
					frame.setVisible(true); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} 
	public RegistrationPage()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250,100,950,650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 950, 123);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Registration Page");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 35));
		lblNewLabel.setBounds(94, 36, 736, 65);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(122, 149, 213, 23);
		lblNewLabel_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name : ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(94, 197, 241, 23);
		lblNewLabel_2.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(59, 230, 270, 36);
		lblNewLabel_3.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		contentPane.add(lblNewLabel_3);
		
		FnametextField = new JTextField();
		
		FnametextField.setBounds(353, 154, 268, 23);
		contentPane.add(FnametextField);
		FnametextField.setColumns(10);
		
		LnametextField = new JTextField();
		LnametextField.setBounds(353, 201, 268, 20);
		contentPane.add(LnametextField);
		LnametextField.setColumns(10);
		
		PhoneNotextField = new JTextField();
		PhoneNotextField.setBounds(353, 242, 268, 23);
		contentPane.add(PhoneNotextField);
		PhoneNotextField.setColumns(10);
		
		JRadioButton radioButtonMale = new JRadioButton("Male");
		radioButtonMale.setForeground(new Color(0, 0, 0));
		radioButtonMale.setBackground(new Color(244, 164, 96));
		radioButtonMale.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		radioButtonMale.setBounds(353, 380, 139, 23);
		contentPane.add(radioButtonMale);
		
		JRadioButton RadioButtonFemale = new JRadioButton("Female");
		RadioButtonFemale.setBackground(new Color(244, 164, 96));
		RadioButtonFemale.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		RadioButtonFemale.setBounds(505, 380, 124, 23);
		contentPane.add(RadioButtonFemale);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(RadioButtonFemale);
		buttonGroup.add(radioButtonMale);
		
				
		JTextArea AddresstextArea = new JTextArea();
		AddresstextArea.setBounds(351, 420, 270, 89);
		contentPane.add(AddresstextArea);
		
		JLabel lblNewLabel_4 = new JLabel("Email Id : ");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(92, 276, 241, 36);
		lblNewLabel_4.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		contentPane.add(lblNewLabel_4);
		
		EmailIdtextField = new JTextField();
		EmailIdtextField.setBounds(351, 290, 274, 20);
		contentPane.add(EmailIdtextField);
		EmailIdtextField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Date of Birth : ");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setBounds(116, 322, 213, 36);
		lblNewLabel_7.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		contentPane.add(lblNewLabel_7);
		
		passwordField_1= new JPasswordField();
		passwordField_1.setBounds(351, 549, 270, 20);
		contentPane.add(passwordField_1);
		passwordField_1.setColumns(10);
		
		JDateChooser DateOfBirth = new JDateChooser();
		DateOfBirth.setBounds(351, 341, 273, 20);
		contentPane.add(DateOfBirth);
		
		JLabel lblNewLabel_5 = new JLabel("Gender : ");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblNewLabel_5.setBounds(103, 371, 226, 36);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Address : ");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblNewLabel_6.setBounds(94, 420, 241, 36);
		contentPane.add(lblNewLabel_6);
	
		
		passwordField = new JPasswordField();
		passwordField.setBounds(351, 519, 270, 20);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		
		JLabel lblNewLabel_9 = new JLabel("Password : ");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_9.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblNewLabel_9.setBounds(77, 505, 262, 36);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Confirm Password : ");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblNewLabel_10.setBounds(47, 535, 294, 36);
		contentPane.add(lblNewLabel_10);
		
		LastNameLabelError = new JLabel("*Last Name is Requied");
		LastNameLabelError.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		LastNameLabelError.setVisible(false);
		LastNameLabelError.setForeground(Color.RED);
		LastNameLabelError.setBounds(641, 202, 229, 17);
		contentPane.add(LastNameLabelError);
		
		PhoneNoLabelError = new JLabel("*Incorrect Phone Number");
		PhoneNoLabelError.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		PhoneNoLabelError.setForeground(Color.RED);
		PhoneNoLabelError.setBounds(640, 239, 230, 23);
		PhoneNoLabelError.setVisible(false);
		contentPane.add(PhoneNoLabelError);
		
		dobLabelError = new JLabel("*Select Date Of Birth");
		dobLabelError.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		dobLabelError.setForeground(Color.RED);
		dobLabelError.setBounds(641, 331, 218, 23);
		dobLabelError.setVisible(false);
		contentPane.add(dobLabelError);
		
		GenderLabelError = new JLabel("*Choose gender");
		GenderLabelError.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		GenderLabelError.setForeground(Color.RED);
		GenderLabelError.setBounds(641, 382, 229, 19);
		GenderLabelError.setVisible(false);
		contentPane.add(GenderLabelError);
		
		AddressLabelError = new JLabel("*Incorrect Address");
		AddressLabelError.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		AddressLabelError.setForeground(Color.RED);
		AddressLabelError.setBounds(641, 419, 218, 21);
		AddressLabelError.setVisible(false);
		contentPane.add(AddressLabelError);
		
		PassLabelError = new JLabel("*Incorrect Paassword");
		PassLabelError.setVisible(false);
		PassLabelError.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		PassLabelError.setForeground(Color.RED);
		PassLabelError.setBounds(641, 516, 229, 18);
		contentPane.add(PassLabelError); 
		
		CPassLabelError = new JLabel("*Password doesnt match");
		CPassLabelError.setVisible(false);
		CPassLabelError.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		CPassLabelError.setForeground(Color.RED);
		CPassLabelError.setBounds(641, 545, 236, 20);
		contentPane.add(CPassLabelError);
		
		FirstNameLabelError = new JLabel("*First Name is required");
		FirstNameLabelError.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		FirstNameLabelError.setForeground(Color.RED);
		FirstNameLabelError.setBackground(Color.WHITE);
		FirstNameLabelError.setBounds(641, 151, 203, 23);
		FirstNameLabelError.setVisible(false);
		contentPane.add(FirstNameLabelError);
		

		EmailidLabelError = new JLabel("*Incorrect Email ");
		EmailidLabelError.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		EmailidLabelError.setForeground(Color.RED);
		EmailidLabelError.setBounds(641, 285, 218, 23);
		EmailidLabelError.setVisible(false);
		contentPane.add(EmailidLabelError);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean b;
				//Validation for First Name 
				 b =Pattern.compile("^[A-Za-z]{2,29}$").matcher(FnametextField.getText()).matches(); 
				 if(b==true) 
				 { 
					 FirstNameLabelError.setVisible(false);
					}
				 else 
				 {
					 FirstNameLabelError.setVisible(true);

				 }
					//Validation for Last Name 
				 b =Pattern.compile("^[A-Za-z]{2,29}$").matcher(LnametextField.getText()).matches(); 
				 if(b==true) { 
					 LastNameLabelError.setVisible(false);
								}
				 else {
					 LastNameLabelError.setVisible(true);

				 }
			
					//Validation for Phone No 
					 b =Pattern.compile("^[6-9]{1}[0-9]{9}$").matcher(PhoneNotextField.getText()).matches(); 
					 if(b==true) { 
						 PhoneNoLabelError.setVisible(false);
									}
					 else {
						 PhoneNoLabelError.setVisible(true);

					 }
					 
					//Validation for Email Id  
					 b =Pattern.compile("^[a-zA-Z0-9+_.-]+@(.+)$").matcher(EmailIdtextField.getText()).matches(); 
					 if(b==true) { 
						 EmailidLabelError.setVisible(false);
									}
					 else {
						 EmailidLabelError.setVisible(true);

					 }
					 
					//Validation for date of birth
						if(((JTextField)DateOfBirth.getDateEditor().getUiComponent()).getText().isEmpty()) {
							dobLabelError.setVisible(true);
						}
						 else {
							 dobLabelError.setVisible(false);

						 }
						//Validation for Gender
						if(buttonGroup.isSelected(null))
						{
							GenderLabelError.setVisible(true);
						}
						else {
							GenderLabelError.setVisible(false);
						}
						
						 
						
						
						//Validation for Address 
			    	 b =Pattern.compile("^[A-Za-z]{2,29}$").matcher(AddresstextArea.getText()).matches(); 
						 if(b==true)
						 { 
							 AddressLabelError.setVisible(false);
									}
						 else {
							 AddressLabelError.setVisible(true);

						 }
							//Validation for Password
						 b =Pattern.compile("").matcher(String.valueOf(passwordField.getPassword())).matches(); 
						 if(b==true) { 
							 PassLabelError.setVisible(true);
										}
						 else {
							 PassLabelError.setVisible(false);

						 }
						 
						 //Validation for Confirm Password
						 b =Pattern.compile("").matcher(String.valueOf(passwordField_1.getPassword())).matches(); 
						 if(b==true)
						 { 
							 CPassLabelError.setVisible(true);
						 }
						 else if(!(Pattern.compile(String.valueOf(passwordField.getPassword())).matcher(String.valueOf(passwordField_1.getPassword())).matches()))
						 {
							 CPassLabelError.setVisible(true);
						 }
						 
						 else {
							 CPassLabelError.setVisible(false);
						 }
						 

						 if(FnametextField.getText().equals(null) && LnametextField.getText().equals(null) &&  PhoneNotextField.getText().equals(null) && EmailIdtextField.getText().equals(null) &&  ((JTextField)DateOfBirth.getDateEditor().getUiComponent()).getText().isEmpty()  &&  buttonGroup.isSelected(null) &&  AddresstextArea.getText().equals(null) && passwordField.getPassword().equals(null) &&  passwordField_1.getPassword().equals(null))
			        	 { 
		        		     if(FirstNameLabelError.isVisible() && LastNameLabelError.isVisible() && PhoneNoLabelError.isVisible() &&  EmailidLabelError.isVisible() && dobLabelError.isVisible() && GenderLabelError.isVisible() && AddressLabelError.isVisible() && PassLabelError.isVisible() && CPassLabelError.isVisible()) 
			        		   {

				        	 JOptionPane.showMessageDialog(null,"Not Submitted");
			        		   }
				         
		        		 }
						
		        		 else
		        		 {
		        			 ArrayList<String> al=new ArrayList<String>();
							 		 al.add(FnametextField.getText());
							         al.add(LnametextField.getText());
							         al.add(PhoneNotextField.getText());
							         al.add(EmailIdtextField.getText());
							         //get the email id
							      //   ename=EmailIdtextField.getText();
							         
							         al.add(((JTextField)DateOfBirth.getDateEditor().getUiComponent()).getText());
								
							         if(radioButtonMale.isSelected())
									{
										 al.add(radioButtonMale.getText());
									 }
									 else {
										 al.add(RadioButtonFemale.getText());
									 }
										
							         
							         al.add(AddresstextArea.getText());
							         al.add(String.valueOf(passwordField.getPassword()));
							         
							         if(String.valueOf(passwordField.getPassword()).equals((String.valueOf(passwordField_1.getPassword()))))
							         {
							        	 al.add(String.valueOf(passwordField_1.getPassword()));
							         }
							         else 
							         {
							        	 CPassLabelError.setVisible(true);
							         }
		        	   	 
							         
						        	 if(!FnametextField.getText().equals(null) && !LnametextField.getText().equals(null) &&  !PhoneNotextField.getText().equals(null) && !EmailIdtextField.getText().equals(null) &&  !((JTextField)DateOfBirth.getDateEditor().getUiComponent()).getText().isEmpty()  &&  !buttonGroup.isSelected(null) &&  !AddresstextArea.getText().equals(null) && !passwordField.getPassword().equals(null) &&  !passwordField_1.getPassword().equals(null))
						        	 { 
						        		 if(!FirstNameLabelError.isVisible() && !LastNameLabelError.isVisible() && !PhoneNoLabelError.isVisible() &&  !EmailidLabelError.isVisible() && !dobLabelError.isVisible() && !GenderLabelError.isVisible() && !AddressLabelError.isVisible() && !PassLabelError.isVisible() && !CPassLabelError.isVisible()) 
						        		   {

								    	 DataBase ig=new DataBase();
									     ig.insertIntoReg(al);
									     JOptionPane.showMessageDialog(null," Submitted");
									     LoginPage lp=new LoginPage();
									     lp.setVisible(true);
									     dispose();
						        		   }
						        	 else 
					        		 {
					        			 JOptionPane.showMessageDialog(null,"Not Submitted");
					        		 }
		        		 }
		        		 }		        		
			}
		});
		btnSubmit.setBorderPainted(false);
		btnSubmit.setBackground(Color.GREEN);
		btnSubmit.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		btnSubmit.setBounds(213, 594, 122, 38);
		contentPane.add(btnSubmit);
		
		JLabel LoginLabel = new JLabel(" Already have an account?\r\nclick here to login");
		LoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LoginLabel.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				LoginPage lp=new LoginPage();
				lp.setVisible(true);
				dispose();
			}
		});
		LoginLabel.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		LoginLabel.setBounds(164, 642, 560, 36);
		contentPane.add(LoginLabel);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{			
				HomePage hp=new HomePage();
				hp.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		btnNewButton.setBounds(558, 594, 111, 38);
		contentPane.add(btnNewButton);
		
		JButton ResetNewButton = new JButton("Reset");
		ResetNewButton.setBackground(new Color(255, 99, 71));
		ResetNewButton.setBorderPainted(false);
		ResetNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				FnametextField.setText(null);
	        	FirstNameLabelError.setVisible(false);

	        	LnametextField.setText(null);
				LastNameLabelError.setVisible(false);

				PhoneNotextField.setText(null);
				PhoneNoLabelError.setVisible(false);

				EmailIdtextField.setText(null);
				EmailidLabelError.setVisible(false);

				DateOfBirth.setToolTipText(null);
				dobLabelError.setVisible(false);
				
				passwordField.setText(null);
				PassLabelError.setVisible(false);;

				passwordField_1.setText(null);
				CPassLabelError.setVisible(false);

				buttonGroup.clearSelection();								    
				GenderLabelError.setVisible(false);
				
				DateOfBirth.setCalendar(null);
				dobLabelError.setVisible(false);
				
				AddresstextArea.setText(null);
				AddressLabelError.setVisible(false);	
			}	
		});
		
		ResetNewButton.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		ResetNewButton.setBounds(371, 594, 121, 38);
		contentPane.add(ResetNewButton);
		setUndecorated(true);
	} 
}
//DONE ///////////////////////////