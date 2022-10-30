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
public class UserGameComment {
    private User UserID;
    private Game GameID;
    private String content;
    private Date date;

    public UserGameComment() {
    }

    public UserGameComment(User UserID, Game GameID) {
        this.UserID = UserID;
        this.GameID = GameID;
    }
    
    public UserGameComment(User UserID, Game GameID, String content) {
        this.UserID = UserID;
        this.GameID = GameID;
        this.content = content;
    }

    public UserGameComment(User UserID, Game GameID, String content, Date date) {
        this.UserID = UserID;
        this.GameID = GameID;
        this.content = content;
        this.date = date;
    }

    public User getUserID() {
        return UserID;
    }

    public void setUserID(User UserID) {
        this.UserID = UserID;
    }

    public Game getGameID() {
        return GameID;
    }

    public void setGameID(Game GameID) {
        this.GameID = GameID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
