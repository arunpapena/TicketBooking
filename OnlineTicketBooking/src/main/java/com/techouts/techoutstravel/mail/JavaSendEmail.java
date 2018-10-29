package com.techouts.techoutstravel.mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaSendEmail {
	
public void sendMail(String name,String email){
	final String username = "noreply.techouts@gmail.com";
	final String password = "Techouts@123";
	

	Session session = Session.getInstance(new PropertiesFactory().getProperties(),
	  new javax.mail.Authenticator() {
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	  });

	try {

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("noreply.techouts@gmail.com"));
		message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse("siddharth.n@techouts.com"));
		message.setSubject("Password Reset!!!!!!!");
		StringBuilder defaultPassword=DefaultPasswordFactory.generateRandomPassword();
		email=email.toLowerCase();
		message.setContent("<html><head></head><body><h3>Dear "+name.substring(0,1).toUpperCase()+name.substring(1,name.length()).toLowerCase()
		+",</h3><br/>\n Thank you for registering with TechoutsTravel"
			+ "\n\n Please use below email and password to reset your account password! "
			+ "<br/><br/><b>UserId : "+email
			+ "<br/><br/><b>Password : "+defaultPassword.toString()+"</b></body></html>","text/html");

		Transport.send(message);
		new DefaultPasswordInsertImpl().insert(email, defaultPassword);

	} catch (MessagingException e) {
		throw new RuntimeException(e);
	}
}
}
