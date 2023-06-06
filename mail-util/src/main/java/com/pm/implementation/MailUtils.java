package com.pm.implementation;

import com.pm.IMailUtils;
import com.pm.payload.Attachment;
import com.pm.payload.MailPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 * @author PM
 * @Created 03/06/2023
 * <p>
 * created by sayr G
 */
@Slf4j
@Service
public class MailUtils implements IMailUtils {
    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String senderMail;

    public MailUtils(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    private void _send(MailPayload payload, boolean withAttachment, boolean withHtml) throws MessagingException {
        List<String> toMails = payload.getToMails();
        List<String> ccMails = payload.getCcMails();
        log.info("[MailService] From {} -> to {}, cc {}, subject {}, with attachment {}",
                senderMail, toMails, ccMails, payload.getSubject(), withAttachment);

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, withAttachment);
        helper.setSubject(payload.getSubject());
        helper.setFrom(senderMail);

//        if (MytelUtil.isNotNull(toMails) && !toMails.isEmpty()) helper.setTo(toMails.toArray(new String[0]));
//        if (MytelUtil.isNotNull(ccMails) && !ccMails.isEmpty()) helper.setCc(ccMails.toArray(new String[0]));

        helper.setText(payload.getContent(), withHtml);

        if (withAttachment) {
            for (Attachment attachment: payload.getAttachments()) {
                try {
                    helper.addAttachment(attachment.getFilename(), attachment.getInputStreamSource());
                } catch (MessagingException e) {
                    log.error("[{}] {}", e.getClass().getSimpleName(), e.getMessage());
                }
            }
        }

        mailSender.send(message);
    }

    @Override
    public void send(MailPayload payload) {
        try {
            _send(payload, false, false);

        }catch (Exception e){

        }
    }

    @Override
    public void sendWithHtml(MailPayload payload) throws MessagingException {
        _send(payload, false, true);
    }
}
