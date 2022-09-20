/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Strongest
 */
public class User {
    private int UserID;
    private Account Name;
    private String Country;
    private float AccountBalance;
    private String Email;

    public User() {
    }

    public User(int UserID, Account Name, String Country, float AccountBalance, String Email) {
        this.UserID = UserID;
        this.Name = Name;
        this.Country = Country;
        this.AccountBalance = AccountBalance;
        this.Email = Email;
    }

    public User(Account Name, String Country, String Email) {
        this.Name = Name;
        this.Country = Country;
        this.Email = Email;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public Account getName() {
        return Name;
    }

    public void setName(Account Name) {
        this.Name = Name;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public float getAccountBalance() {
        return AccountBalance;
    }

    public void setAccountBalance(float AccountBalance) {
        this.AccountBalance = AccountBalance;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
}
