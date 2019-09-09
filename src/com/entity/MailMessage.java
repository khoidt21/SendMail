/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

/**
 *
 * @author ADMIN
 */
public class MailMessage {
    
    private String from;
    private String to;
    private String subject;
    private String message;
    private String fileAttrack;
   
    
    public MailMessage(){}
    
    public MailMessage(String from,String to,String subject,String message,String fileAttrack){
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.message = message;
        this.fileAttrack = fileAttrack;
        
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getFileAttrack() {
        return fileAttrack;
    }

    public void setFileAttrack(String fileAttrack) {
        this.fileAttrack = fileAttrack;
    }
    
}
