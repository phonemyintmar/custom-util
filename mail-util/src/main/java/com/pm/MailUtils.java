package com.pm;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @author PM
 * @Created 03/06/2023
 * <p>
 * created by sayr G
 */
@Component
public class MailUtils {
    private final JavaMailSender mailSender;

    public MailUtils(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String recipient, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("your_email@example.com");
        message.setTo(recipient);
        message.setSubject(subject);
        message.setText(content);

        try {
            System.out.println(mailSender.getClass().getField("port").get(mailSender));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

//      mailSender.send(message);
    }


}
