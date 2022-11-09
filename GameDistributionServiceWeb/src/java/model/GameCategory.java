/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Strongest
 */
public class GameCategory {
    private Game GameID;
    private Category CategoryID;

    public GameCategory() {
    }

    public GameCategory(Game GameID, Category CategoryID) {
        this.GameID = GameID;
        this.CategoryID = CategoryID;
    }

    public GameCategory(Category CategoryID) {
        this.CategoryID = CategoryID;
    }

    public Game getGameID() {
        return GameID;
    }

    public void setGameID(Game GameID) {
        this.GameID = GameID;
    }

    public Category getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(Category CategoryID) {
        this.CategoryID = CategoryID;
    }
    
    
}
