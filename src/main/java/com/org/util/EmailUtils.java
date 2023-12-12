package com.org.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {

	  @Autowired
	  private JavaMailSender javaMailSender;
	  
	  public boolean sendMail(String subject, String body, String to , File file) {
		  try {
			  MimeMessage message = javaMailSender.createMimeMessage();
			     
			    MimeMessageHelper helper = new MimeMessageHelper(message, true);
			    
			    helper.setFrom("virat.heart.18@gmail.com");
			    helper.setTo(to);
			    helper.setSubject(subject);
			    helper.setText(body);
			        
			    helper.addAttachment(to, file);

			    javaMailSender.send(message);
			  
		  }catch (Exception e) {
			System.out.println(e.getMessage());
		}
		  return true;
	  }
}
