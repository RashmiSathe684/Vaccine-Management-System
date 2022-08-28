package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connectionz {
	static Connection con;
	
	 private static String url="jdbc:mysql:///vaccination";
     private static String user="root";
     private static String pwd=null;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection(url,user,pwd);
			 return con;
		}catch(Exception ex){
			System.out.println(" "+ex);
			
			}
		return con;
	}

}
