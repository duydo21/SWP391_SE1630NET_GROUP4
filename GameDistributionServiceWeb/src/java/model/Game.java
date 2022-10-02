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
public class Game {
    private int GameID;
    private String Name;
    private float Price;
    private String PublishedBy;
    private String Developer;
    private int Download;
    private int Discount;
    private float Rate;
    private int Status;
    private String Description;
    private Date Date;
    
    
    public Game() {
        
    }

    public Game(int GameID, String Name, float Price, String PublishedBy, String Developer, 
            int Download, int Discount, float Rate, int Status, String Description, Date Date) {
        this.GameID = GameID;
        this.Name = Name;
        this.Price = Price;
        this.PublishedBy = PublishedBy;
        this.Developer = Developer;
        this.Download = Download;
        this.Rate = Rate;
        this.Status = Status;
        this.Description = Description;
        this.Date = Date;
    }



    public int getGameID() {
        return GameID;
    }

    public void setGameID(int GameID) {
        this.GameID = GameID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public String getPublishedBy() {
        return PublishedBy;
    }

    public void setPublishedBy(String PublishedBy) {
        this.PublishedBy = PublishedBy;
    }

    public String getDeveloper() {
        return Developer;
    }

    public void setDeveloper(String Developer) {
        this.Developer = Developer;
    }

    public int getDownload() {
        return Download;
    }

    public void setDownload(int Download) {
        this.Download = Download;
    }

    public float getRate() {
        return Rate;
    }

    public void setRate(float Rate) {
        this.Rate = Rate;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public int getDiscount() {
        return Discount;
    }

    public void setDiscount(int Discount) {
        this.Discount = Discount;
    }
    
    
}
