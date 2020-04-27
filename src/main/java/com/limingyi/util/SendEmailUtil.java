package com.limingyi.util;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Component;
//邮箱验证防止恶意注册用户
@Component
	public class SendEmailUtil {

	     /*
	      *发送邮件
	      * @param toEmail 目的地
	      * @param code 唯一激活码
	      * @return
	      */
	    public int send_email(String toEmail,String code) throws IOException, AddressException, MessagingException{

	        String to = toEmail;
	        String subject = "邮箱验证";
	/* String content = "<html><head></head><body><h1>这是一封激活邮件,激活请点击以下链接</h1><h3><a href='http://localhost:8888/GraduationDesign/emailverify?code="
	                + code + "'>http://localhost:8888/GraduationDesign/emailverify?code=" + code
	                + "</href></h3></body></html>";                  //链接验证*/     
	        String content ="<html><head></head><body><h1>这是一封激活邮件验证码,</h1><h3>验证码为:"+code
	        		                +"</href></h3></body></html>";
	       
	        Properties properties = new Properties();
	        properties.put("mail.smtp.host", "smtp.qq.com");
	        properties.put("mail.smtp.port", "25");
	        properties.put("mail.smtp.auth", "true");

	        //发送者的邮箱和授权码
	        Authenticator authenticator = new Email_Authenticator("2891721433@qq.com", "zzycvejanafudghg");
	        Session sendMailSession = javax.mail.Session.getDefaultInstance(properties, authenticator);
	        MimeMessage mailMessage = new MimeMessage(sendMailSession);
	        //邮箱的发送者
	        try {
	            mailMessage.setFrom(new InternetAddress("2891721433@qq.com"));
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }

	        //邮箱接收
	        // Message.RecipientType.TO属性表示接收者的类型为TO
	        mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
	        //发送邮件的标题
	        mailMessage.setSubject(subject, "UTF-8");
	        //发送邮件的日期
	        mailMessage.setSentDate(new Date());

	        //MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
	        Multipart mainPart = new MimeMultipart();

	        //创建一个包含HTML内容的MimeBodyPart
	        BodyPart html = new MimeBodyPart();
	        //设置邮件的内容的格式和字节码
	        html.setContent(content.trim(), "text/html; charset=utf-8");
	        mainPart.addBodyPart(html);
	        mailMessage.setContent(mainPart);
	        Transport.send(mailMessage);
	        return 1;
	    }
	}

