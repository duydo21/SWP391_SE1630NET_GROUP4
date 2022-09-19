/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Strongest
 */
public class UserNotification {
    private User UserID;
    private Notification NotiID;

    public UserNotification() {
    }

    public UserNotification(User UserID, Notification NotiID) {
        this.UserID = UserID;
        this.NotiID = NotiID;
    }

    public User getUserID() {
        return UserID;
    }

    public void setUserID(User UserID) {
        this.UserID = UserID;
    }

    public Notification getNotiID() {
        return NotiID;
    }

    public void setNotiID(Notification NotiID) {
        this.NotiID = NotiID;
    }
    
    
}
