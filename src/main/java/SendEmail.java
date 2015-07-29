
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;



import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class SendEmail {




	public boolean sendMail(String to) throws IOException {
		Logger logger=Logger.getLogger(SendEmail.class.getName());

		Boolean bool = false;
		
		final String from, username, password;
		EmailGetProperty mailProp=new EmailGetProperty();
		Properties props = mailProp.getProp();


		

			// reading values from config.property file
		    logger.info("reading SMTP server details from property file");
			from = props.getProperty("sender");
			username = props.getProperty("username");
			password = props.getProperty("password");
			

			
			
			
			//System.out.println(props);
			


			// Get the Session object.
			Session session = Session.getInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username,
									password);
						}
					});

			try {
				// Create a default MimeMessage object.
				Message message = new MimeMessage(session);

				// Set From: header field of the header.
				message.setFrom(new InternetAddress(from));

				// Set To: header field of the header.
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(to));

				// Set Subject: header field
				MessageFormat msg=new MessageFormat();
				message.setSubject(msg.getSubject());

				// Now set the actual message

				
				
				message.setText(msg.getText());

				// Send message
				Transport.send(message);

				logger.info("Sent message successfully....");

				bool = true;

			} catch (MessagingException e) {
				logger.severe("Not able to create a message");
			}
			return bool;
		} 
			


		
		

		// props.put("mail.smtp.debug", "true");
		
		


	public static void main(String[] args) throws IOException{
		// Recipient's email ID needs to be mentioned.
		Scanner in = new Scanner(System.in);
		System.out.println("Enter recipient mail id");
		String to = in.nextLine();
		SendEmail mail = new SendEmail();

		try
		{
			mail.sendMail(to);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		
		mail.sendMail(to);
		in.close();
		

		

		// Sender's email ID needs to be mentioned

	}
}
