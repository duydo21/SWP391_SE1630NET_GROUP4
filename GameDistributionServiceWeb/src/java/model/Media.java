/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Strongest
 */
public class Media {
    private Game GameID;
    private String Link;
    private int Type;

    public Media() {
    }

    public Media(Game GameID, String Link, int Type) {
        this.GameID = GameID;
        this.Link = Link;
        this.Type = Type;
    }

    public Game getGameID() {
        return GameID;
    }

    public void setGameID(Game GameID) {
        this.GameID = GameID;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String Link) {
        this.Link = Link;
    }

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }
    
    
}
