/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Strongest
 */
public class Request {
    private int RequestID;
    private User RequestBy;
    private int Status;
    private String Context;
    
    
    public Request() {
    }

    public Request(int RequestID, User RequestBy, int Status, String Context) {
        this.RequestID = RequestID;
        this.RequestBy = RequestBy;
        this.Status = Status;
        this.Context = Context;
    }

    public Request(String Context) {
        this.Context = Context;
    }

    public int getRequestID() {
        return RequestID;
    }

    public void setRequestID(int RequestID) {
        this.RequestID = RequestID;
    }

    public User getRequestBy() {
        return RequestBy;
    }

    public void setRequestBy(User RequestBy) {
        this.RequestBy = RequestBy;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getContext() {
        return Context;
    }

    public void setContext(String Context) {
        this.Context = Context;
    }
    
    
}
