package com.project.utility;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class lastEmailId 
{
	 
	static String message="Hello Dear....\nYour Vaccination for Booster  is successfully scheduled for covid-19";
	   static String subject="Vaccination Appointement: Confirmation ";
	   static String from="pritiathawale111@gmail.com";
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		 System.out.println("Preparing to send Message....");
  // String to="athawalepriti21@gmail.com";
   
  
   
}

public static void sendLastEmail(String to) {
	// TODO Auto-generated method stub
	String host="smtp.gmail.com";
	
	Properties properties= System.getProperties();
	System.out.println("Properties "+properties);
	//host set
	properties.put("mail.smtp.host",host);
	properties.put("mail.smtp.port","465");
	properties.put("mail.smtp.ssl.enable",true);
	properties.put("mail.smtp.auth",true);
	
	//to get session object
	Session session=Session.getInstance(properties,new Authenticator() {
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("pritiathawale222@gmail.com","gdghculifzjgkdlq");
		//	return new PasswordAuthentication("pritiathawale111@gmail.com","kvzooosrloxrckxf");
			
		}
	});
	
	session.setDebug(true);

	//step 2 compose the message
	MimeMessage m=new MimeMessage(session);
	try {
	//from
	m.setFrom(from);
	
	//add recepient to
	m.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
	
	//adding subject to message
	
	m.setSubject(subject);
	
	//adding text to message
	
	m.setText(message);
	
	//send
	//step 3 send message using transport class
	Transport.send(m);
	
	System.out.println("Message sent successfully");
	
	}catch(Exception e) {
		e.printStackTrace();
	}
 }
}