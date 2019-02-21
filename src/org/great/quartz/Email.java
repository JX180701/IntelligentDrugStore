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
		//邮件发送方
		String from = "1074301995@qq.com";
		
		// 指定发送邮件的主机为 localhost
		String host = "smtp.qq.com";
		// 获取系统属性
		Properties properties = System.getProperties();

		// 设置邮件服务器
		properties.setProperty("mail.host", host);
		// 授权邮箱
		properties.put("mail.smtp.auth", "true");
		Authenticator aut = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("1074301995","itjejearcwvciiab");
 
            }
        };
		
		// 获取默认session对象
		Session session = Session.getDefaultInstance(properties,aut);
		try {
			// 创建默认的 MimeMessage 对象
			MimeMessage message = new MimeMessage(session);
			// Set From: 头部头字段
			message.setFrom(new InternetAddress(from));
			// Set To: 头部头字段
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// Set Subject: 头部头字段
			message.setSubject(title);
			// 设置消息体
			message.setText(content);
			// 发送消息
			Transport.send(message);
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}

	}
}
