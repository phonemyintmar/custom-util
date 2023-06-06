package com.pm.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author PM
 * @Created 05/06/2023
 * <p>
 * created by sayr G
 */
@Getter
@Setter
@ToString
public class MailPayload {
   private List<String> toMails;
   private List<String> ccMails;
   private String subject;
   private String content;
   private List<Attachment> attachments;
}
