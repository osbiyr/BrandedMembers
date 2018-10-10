package q;

// this class is for sending the email

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailing {

	public static void mail(double Mprice,String Mmail) {
		String first = "70 nis for one month";
		String second = "50 nis/per month for 6 months";
		String third = "40 nis/per month for 12 months";	

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.starttls.enable", "ture");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("osbiyr@gmail.com","Aa16542006");
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("osbiyr@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(Mmail));
			message.setSubject("For Mr.Customer");
			message.setText("Dear customer");

			//checks all possibilities for the price and send a message respectively

			if(Mprice == 70.0 ||  Mprice == 66.5)  message.setText(first + "\n\n"+ "your total price is:" + Mprice);
			if(Mprice == 300.0 || Mprice == 275.0)  message.setText(second + "\n\n"+ "your total price is:" + Mprice);
			if(Mprice == 480.0 || Mprice == 456.0) message.setText(third + "\n\n"+ "your total price is:" + Mprice);


			// send email

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}