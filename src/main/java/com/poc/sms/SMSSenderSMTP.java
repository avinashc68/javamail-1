package com.poc.sms;

import java.util.Properties;

public class SMSSenderSMTP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String username = "username@gmail.com";
		final String password = "password";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
//		session session = Session.getInstance(props,
//		  new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(username, password);
//			}
//		  });
// 
//		try {
// 
//			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress("from-email@gmail.com"));
//			message.setRecipients(Message.RecipientType.TO,
//				InternetAddress.parse("to-email@gmail.com"));
//			message.setSubject("Testing Subject");
//			message.setText("Dear Mail Crawler,"
//				+ "\n\n No spam to my email, please!");
// 
//			Transport.send(message);
// 
//			System.out.println("Done");
// 
//		} catch (MessagingException e) {
//			throw new RuntimeException(e);
//		}
//	}
	}

}