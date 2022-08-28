package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DataBase {
	private static String driver="com.mysql.jdbc.Driver"; 
	  private static String url="jdbc:mysql:///vaccination";
	  private static String user="root";
	  private static String pwd=null;
	
		String query;
		Connection con=null;
		PreparedStatement ps=null;
	//	ResultSet rs=null;
		Statement st=null;
		//   int a = 0;
	public void insertIntoReg(ArrayList<String> al)
	{
		
		try{
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pwd);
			st=con.createStatement();
			
			query = "INSERT INTO `reg_details` (`firstname`, `lastName`, `phoneNo`, `emailId`, `dob`, `gender`, `address`, `password`, `confirmPassword`) VALUES (?,?,?,?,?,?,?,?,?)";
			
			ps=con.prepareStatement(query);
			
			ps.setString(1,al.get(0));      
			ps.setString(2,al.get(1));
			ps.setString(3,al.get(2));
			ps.setString(4,al.get(3));
			ps.setString(5,al.get(4));
			 
			ps.setString(6,al.get(5));
			ps.setString(7,al.get(6));
			ps.setString(8,al.get(7));
			ps.setString(9,al.get(8));
			ps.executeUpdate();
			}
		
			catch(Exception ex) 
			{
				JOptionPane.showMessageDialog(null,ex);
			}	
		//return a;						   
	}
				
}