package com.techouts.techoutstravel.mail;

import java.util.Properties;

public class PropertiesFactory {
	public Properties getProperties(){
		 Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("user", "root");
			props.put("password", "root");
			props.put("useSSL", "false");
			props.put("autoReconnect", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
		return props;
	 }
	
}
