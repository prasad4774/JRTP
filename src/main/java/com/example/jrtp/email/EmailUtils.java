package com.example.jrtp.email;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {
	
	
	@Autowired
	JavaMailSender javaMailSender;
	
	
	public boolean sendEmail(String subject , String body, String to, File f)
	{
		try {
			
			   MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			   
			      MimeMessageHelper helper= new MimeMessageHelper(mimeMessage, true);
			      helper.setSubject(subject);
			      helper.setText(body,true);
			      helper.setTo("prasadjadhav4747@gmail.com");
//			      for Execel format
//			      helper.addAttachment("Plans.xls", f);
//			      for PDF 
			      helper.addAttachment("Plans.xls", f);
			      
			      javaMailSender.send(mimeMessage);
			    		  
			
			
			
		} catch (Exception e) {
		  System.out.println(e.getMessage());
		}
		return true;
		
	}

}
