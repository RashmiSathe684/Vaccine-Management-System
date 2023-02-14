package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LastScheduleDatabase {
	  private static String driver="com.mysql.jdbc.Driver"; 
	  private static String url="jdbc:mysql:///vaccination";
	  private static String user="root";
	  private static String pwd=null;
	

		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Statement st=null;
		Statement stmt=null;
		
	public void insertIntoLVS(ArrayList<String> al)
	{
		
		try{
		
			
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pwd);
			st=con.createStatement();
			
			String query = "INSERT INTO `boosterbooking_details`(`emailId`,`city`, `centre`,`date`,`type`,`doseNo`) VALUES (?,?,?,?,?,?)";
			ps=con.prepareStatement(query);
			
			ps.setString(1,al.get(0));      
			ps.setString(2,al.get(1));
			ps.setString(3,al.get(2));
			ps.setString(4,al.get(3));
			ps.setString(5,al.get(4));	
			ps.setString(6,al.get(5));
			ps.executeUpdate();

			}
			catch(Exception ex) 
			{
				JOptionPane.showMessageDialog(null,ex);
			}	
		  								   
	}
}			
