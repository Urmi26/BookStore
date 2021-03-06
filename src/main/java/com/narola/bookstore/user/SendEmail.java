package com.narola.bookstore.user;

import java.util.*;
import javax.mail.*;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	public static void main(String[] args) {
		String to = "urminayaka@gmail.com";
		String from = "abc@gmail.com";
		String host = "127.0.0.1";

		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties);

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("This is the subject line!");
			message.setText("This is actual message");
			Transport.send(message);
			System.out.println("Sent message successfully.....");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
