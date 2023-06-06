package com.pm;

import com.pm.payload.MailPayload;

import javax.mail.MessagingException;

/**
 * @author PM
 * @Created 05/06/2023
 * <p>
 * created by sayr G
 */
public interface IMailUtils {
   void send(MailPayload payload) ;

   void sendWithHtml(MailPayload payload) throws MessagingException;
}
