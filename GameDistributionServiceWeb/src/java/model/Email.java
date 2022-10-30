/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Email {

    private String From;
    private String To;
    private String FromPassword;
    private String content;
    private String subject;

    public Email() {
    }

    
    public Email(String From, String To, String FromPassword, String content, String subject) {
        this.From = From;
        this.To = To;
        this.FromPassword = FromPassword;
        this.content = content;
        this.subject = subject;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String From) {
        this.From = From;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String To) {
        this.To = To;
    }

    public String getFromPassword() {
        return FromPassword;
    }

    public void setFromPassword(String FromPassword) {
        this.FromPassword = FromPassword;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    
}
