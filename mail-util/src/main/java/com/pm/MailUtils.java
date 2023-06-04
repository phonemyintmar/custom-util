package com.pm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @author PM
 * @Created 03/06/2023
 * <p>
 * created by sayr G
 */
@Slf4j
public class MailUtils {

    private final Environment environment;

    @Value("${pm.mail.utils.email.host}")
    private String host;

    @Value("${pm.mail.utils.email.port}")
    private int port;

    @Value("${pm.mail.utils.email.username}")
    private String username;

    @Value("${pm.mail.utils.email.password}")
    private String password;

    public MailUtils(Environment environment) {
        this.environment = environment;
    }

    private JavaMailSenderImpl javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(environment.getProperty("name.test"));
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        return mailSender;
    }

    public void sendEmail(String recipient, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("your_email@example.com");
        message.setTo(recipient);
        message.setSubject(subject);
        message.setText(content);

        log.info("mail sender host {}", javaMailSender().getHost());
    }
}
