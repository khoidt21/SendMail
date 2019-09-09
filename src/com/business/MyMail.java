/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.business;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import com.entity.MailMessage;
import com.entity.SMTPServer;
import java.io.IOException;
import java.net.MalformedURLException;


/**
 *
 * @author ADMIN
 */
public class MyMail {
    
         Multipart multipart;
        // ham getMailSession
        public Session getMailSession(SMTPServer smtpServer,String from,String password){
            Properties props = new Properties();
            props.put("mail.smtp.host",smtpServer.getServer());
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port",smtpServer.getPort());
            props.put("mail.smtp.socketFactory.port",smtpServer.getPort());
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
          
            // Get the Session object 
            Session session = Session.getInstance(props,new javax.mail.Authenticator(){
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(from,password);
                }
            });
            return session;
        }
        // ham SendMail 
        public boolean SendMail(MailMessage mailMessage,Session session) throws Exception{
           
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailMessage.getFrom()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailMessage.getTo()));
            message.setSubject(mailMessage.getSubject());
            message.setText(mailMessage.getMessage());
            
            // attrack file dinh kem 
           
            MimeBodyPart messageBodyPart = new MimeBodyPart();            
            String attrackFile = mailMessage.getFileAttrack(); // File Path
            
            messageBodyPart.setText(mailMessage.getMessage());
            multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            if(attrackFile.length() > 0) 
            {
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(attrackFile);
            messageBodyPart.setDataHandler(new DataHandler(source));
            String fileName = attrackFile.substring(attrackFile.lastIndexOf('\\')+1, attrackFile.length());

            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);
            }
            message.setContent(multipart);
            // send message        
            Transport.send(message);
            return true;
           
        }
}
