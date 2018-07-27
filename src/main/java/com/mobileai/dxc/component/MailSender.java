package com.mobileai.dxc.component;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;


/**
 * 提供邮件发送服务
 */
@Component
public class MailSender {
    private static String FromEmail = "mobile_dxc@sina.com";
    private static String EmailPassword = "MobileAI403";
    private static String EmailSMTPhost = "smtp.sina.com";
    
    public void sendMail(String toEmail , String identifyCode){
        Properties props = new Properties();

        props.setProperty("smtp.debug", "true");
        props.setProperty("mail.smtp.auth", "true");
        props.put("mail.smtp.port", 25);
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", EmailSMTPhost);

        Session session = Session.getInstance(props);
        session.setDebug(true);

        Message msg = new MimeMessage(session);
        try {
			msg.setSubject("验证码");
			msg.setText(identifyCode);
			msg.setSentDate(new Date());
			msg.setFrom(new InternetAddress(FromEmail,"稻香村","UTF-8"));

			Transport transport = session.getTransport();
			transport.connect(EmailSMTPhost,FromEmail,EmailPassword);

			transport.sendMessage(msg, new Address[] {new InternetAddress(toEmail)});

			transport.close();
		} catch (UnsupportedEncodingException | MessagingException e) {
			e.printStackTrace();
		}
    }
}