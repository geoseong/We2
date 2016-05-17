package com.we2.pjtMake;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.io.*;
import java.util.*;

public class MailSend{
	
	public static void main(String[] args) {
		Properties p = new Properties();
		p.put("mail.smtp.user", "hyuk9658@gmail.com"); // Google���� ���̵�@gmail.com���� ����
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");

		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");

		// Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

		try {
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getDefaultInstance(p, auth);
			session.setDebug(true); // ������ ������ �� ���� ��Ȳ�� �ֿܼ� ����Ѵ�.

			// session = Session.getDefaultInstance(p);
			MimeMessage msg = new MimeMessage(session);
			String message = "Gmail SMTP ������ �̿��� JavaMail �׽�Ʈ";
			msg.setSubject("OOO���� ����� �ʴ��մϴ�. We2");
			Address fromAddr = new InternetAddress("hyuk9658@gmail.com"); // ������ ����� �����ּ�
			msg.setFrom(fromAddr);
			Address toAddr = new InternetAddress("hyuk9658@naver.com"); // �޴� ����� �����ּ�
			msg.addRecipient(Message.RecipientType.TO, toAddr);
			/*
			 * msg.setContent(message, "text/plain;charset=KSC5601");
			 * System.out.println("Message: " + msg.getContent());
			 * Transport.send(msg);
			 */
			BodyPart messageBodyPart = new MimeBodyPart();

			// Fill the message
			messageBodyPart.setText("We2 ������Ʈ�� ����� �ʴ��մϴ�. www.naver.com"); //�޽��� ���� ��
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			File file = new File("C:/a.jpg"); //���� ������ 
			FileDataSource fds = new FileDataSource(file);
			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setFileName(fds.getName());
			multipart.addBodyPart(messageBodyPart);

			// Put parts in message
			// HTML�� �޽����� ������ ���� setContent()�� Ư������ �����ϸ� �ȴ�.
			// ���� : msg.setContent(multipart, "text/plain;charset=KSC5601");
			String htmlText=null;
			msg.setContent(htmlText, "text/html");

			// Send the message
			Transport.send(msg);
			System.out.println("Gmail SMTP������ �̿��� ���Ϻ����� ����");
		} catch (Exception mex) { // Prints all nested (chained) exceptions as
									// well
			System.out.println("I am here??? ");
			mex.printStackTrace();
		}
	}
	public static class SMTPAuthenticator extends javax.mail.Authenticator{
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("hyuk9658@gmail.com", "password"); // Google id, pwd
		}
	}
}