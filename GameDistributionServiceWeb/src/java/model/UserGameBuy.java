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
public class UserGameBuy {
    private User UserID;
    private Game GameID;
    private Date date;

    public UserGameBuy() {
    }

    public UserGameBuy(User UserID, Game GameID, Date date) {
        this.UserID = UserID;
        this.GameID = GameID;
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

    public Date getContent() {
        return date;
    }

    public void setContent(Date date) {
        this.date = date;
    }
    
    
}
