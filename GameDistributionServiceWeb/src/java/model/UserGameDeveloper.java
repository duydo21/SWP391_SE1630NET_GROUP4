/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class UserGameDeveloper {
    private User UserID;
    private Game GameID;

    public UserGameDeveloper() {
    }

    public UserGameDeveloper(User UserID, Game GameID) {
        this.UserID = UserID;
        this.GameID = GameID;
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
    
    
    
}
