package org.great.quartz;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	
	public static String to = "1309481844@qq.com";
	public static String title = "title";
	public static String content = "content";
	
	public static void send() {
		//�ʼ����ͷ�
		String from = "1074301995@qq.com";
		
		// ָ�������ʼ�������Ϊ localhost
		String host = "smtp.qq.com";
		// ��ȡϵͳ����
		Properties properties = System.getProperties();

		// �����ʼ�������
		properties.setProperty("mail.host", host);
		// ��Ȩ����
		properties.put("mail.smtp.auth", "true");
		Authenticator aut = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("1074301995","itjejearcwvciiab");
 
            }
        };
		
		// ��ȡĬ��session����
		Session session = Session.getDefaultInstance(properties,aut);
		try {
			// ����Ĭ�ϵ� MimeMessage ����
			MimeMessage message = new MimeMessage(session);
			// Set From: ͷ��ͷ�ֶ�
			message.setFrom(new InternetAddress(from));
			// Set To: ͷ��ͷ�ֶ�
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// Set Subject: ͷ��ͷ�ֶ�
			message.setSubject(title);
			// ������Ϣ��
			message.setText(content);
			// ������Ϣ
			Transport.send(message);
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}

	}
}
