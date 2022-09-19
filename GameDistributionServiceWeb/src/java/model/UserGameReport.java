/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Strongest
 */
public class UserGameReport {
    private User UserID;
    private Game GameID;
    private String content;

    public UserGameReport() {
    }

    public UserGameReport(User UserID, Game GameID, String content) {
        this.UserID = UserID;
        this.GameID = GameID;
        this.content = content;
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
    
    
}
