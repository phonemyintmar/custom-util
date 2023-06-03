package com.pm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @author PM
 * @Created 03/06/2023
 * <p>
 * created by sayr G
 */
@Configuration
public class MailConfig {

    @Value("${pm.mail.utils.email.host}")
    private String host;

    @Value("${pm.mail.utils.email.port}")
    private int port;

    @Value("${pm.mail.utils.email.username}")
    private String username;

    //learn jasypt
    @Value("${pm.mail.utils.email.password}")
    private String password;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        return mailSender;
    }

    // d lo lote tr ka config nae creation process twy paw mhr po pee control shi tl tae. in case you want to
    // config external properties br nyr, for now, just comment because we have component already
//    @Bean
//    public MailUtils mailUtils(JavaMailSender mailSender) {
//        return new MailUtils(mailSender);
//    }

}
