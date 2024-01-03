package com.rentatrip.Services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;

@Configuration
public class EmailService {
//
//    @Autowired
//    private JavaMailSender emailSender;
//
//
//    @Value("${spring.mail.properties.mail.smtp.from}")
//    private String senderEmail;
//
// 
//
//    public EmailService(JavaMailSender emailSender, String senderEmail) {
//        super();
//        this.emailSender = emailSender;
//        this.senderEmail = senderEmail;
//    }
//
//    @Async
//    public void sendEmail(String to, String subject, String text) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
//        emailSender.send(message);
//    }
//    
//
//    
//    
//    @Async
//    public void sendMimeEmail(String to, String subject, String htmlContent) {
//        MimeMessage mimeMessage = emailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
//
//        try {
//            helper.setTo(to);
//            helper.setSubject(subject);
//            helper.setText(htmlContent, true); // Set the second parameter to true to enable HTML content
//            emailSender.send(mimeMessage);
//        } catch (MessagingException e) {
//            // Handle exception
//            e.printStackTrace();
//        }
//    }
//
//    @Async
//    public void sendPasswordResetEmail(String recipientEmail, String token) throws MessagingException {
//
//        MimeMessage mimeMessage = emailSender.createMimeMessage();
//        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
//
//        messageHelper.setSubject("Password Reset Request");
//
//        String resetLink = "http://localhost:4200/api/reset-password?token=" + token;
//
//
//        String message = String.format(
//        				"Hello, <br><br>"
//                		
//                		+"You have requested to reset your password.<br><br> "
//                        + "Please click on the link below to reset your password.<br><br>"
//                        + "<a href=\"%s\">Reset Password</a> <br><br>" 
//                       
//						+ "If you did not request this reset, please ignore this email.<br><br><br>" 
//						+ "Please note that the password reset link will expire in 15 mins.<br><br><br>" 
//                        +"Best regards,<br><br>" 
//
//                       + "rent-a-trip Support Team",
//                resetLink);
//
//        messageHelper.setTo(recipientEmail);
//        messageHelper.setFrom(senderEmail);
//        messageHelper.setText(message, true);
//
//        emailSender.send(mimeMessage);
//    }

    

}
