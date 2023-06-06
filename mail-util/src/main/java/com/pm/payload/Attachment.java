package com.pm.payload;

import lombok.Data;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author PM
 * @Created 05/06/2023
 * <p>
 * created by sayr G
 */
@Data
public class Attachment {
   private String filename;
   private InputStreamSource inputStreamSource;

   public static Attachment fromFile(String filename, String filePath) throws IOException {
      Attachment attachment = new Attachment();
      attachment.setFilename(filename);
      attachment.setInputStreamSource(createFreshInputStream(new FileInputStream(filePath)));
      return attachment;
   }

   static ByteArrayResource createFreshInputStream(InputStream inputStream) throws IOException {
      return new ByteArrayResource(toByteArray(inputStream));
   }

   static byte[] toByteArray(InputStream in) throws IOException {
      ByteArrayOutputStream os = new ByteArrayOutputStream();

      byte[] buffer = new byte[1024];
      int len;

      // read bytes from the input stream and store them in the buffer
      while ((len = in.read(buffer)) != -1) {
         // write bytes from the buffer into the output stream
         os.write(buffer, 0, len);
      }

      return os.toByteArray();
   }
}
