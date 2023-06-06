//package com.pm;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//
//import java.util.Properties;
//
//@Configuration
//public class MailConfig {
//    @Value("${email.host}")
//    private String host;
//
//    @Value("${email.port}")
//    private int port;
//
//    @Value("${email.username}")
//    private String username;
//
//    @Value("${email.password}")
//    private String password;
//
//    @Bean
//    public JavaMailSenderImpl javaMailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost(host);
//        mailSender.setPort(port);
//        mailSender.setUsername(username);
//        mailSender.setPassword(password);
//
//        Properties props = mailSender.getJavaMailProperties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.starttls.required", "true");
//        return mailSender;
//    }
//
//    @Bean
//    public SimpleMailMessage mailMessage() {
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setFrom(username.split("@")[0]);
//        return mailMessage;
//    }
//
//}
