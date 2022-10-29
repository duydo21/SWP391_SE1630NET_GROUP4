/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Strongest
 */
public class Notification {
    private int NotiID;
    private int Type;
    private String Content;
    private Date date;
    
    public Notification() {
        
    }

    public Notification(int NotiID, int Type, String Content, Date date) {
        this.NotiID = NotiID;
        this.Type = Type;
        this.Content = Content;
        this.date = date;
    }
    public Notification(String Context) {
        this.Content = Context;
    }

    public int getNotiID() {
        return NotiID;
    }

    public void setNotiID(int NotiID) {
        this.NotiID = NotiID;
    }

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
