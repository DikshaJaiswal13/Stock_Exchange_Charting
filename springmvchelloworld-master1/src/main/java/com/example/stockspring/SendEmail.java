package com.example.stockspring;
import java.util.Properties;
import java.util.Random;

import javax.mail.*;
import javax.mail.internet.*;  
  
public class SendEmail  
{  
	public int sendMail(String email)
	{
		int num=0;
	String host="smtp.gmail.com";  
	  final String user="javasmtp1234@gmail.com";//change accordingly  --refer javatpoint for the code
	  final String password="java#1234";//change accordingly  
	    
	  //String to="dikshajaiswal033@gmail.com";//change accordingly  
	  
	   //Get the session object  
	   Properties props = new Properties();  
	   props.put("mail.smtp.host",host);  
	   props.put("mail.smtp.socketFactory.port", "587");
	   props.put("mail.smtp,socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	   props.put("mail.smtp.auth", "true"); 
	   props.put("mail.smtp.port", 587);
	   props.put("mail.transport.protocol", "smtp");
	   props.put("mail.smtp.starttls.enable", "true");
	   props.put("mail.debug", "true");
	   //props.put("mail.setTLS","true");
	   //props.put("mail.smtp.STARTTLS","true");
	     
	   Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {  
	      protected PasswordAuthentication getPasswordAuthentication() {  
	    return new PasswordAuthentication(user,password);  
	      }  
	    }); 
	   session.setDebug(true);
	  
	   //Compose the message  
	    try {  
	     Message message = new MimeMessage(session);  
	     message.setFrom(new InternetAddress(user));  
	     message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email));  
	     message.setSubject("OTP VERIFICATION");  
	     Random r=new Random();
	      num=r.nextInt(90000)+10000;
	     message.setText("Your OTP is: "+num);  
	       
	    //send the message  
	     Transport.send(message);  
	  
	     System.out.println("message sent successfully...");  
	   
	     } catch (MessagingException e) {e.printStackTrace();} 
	    return num;
	}
}  