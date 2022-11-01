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
public class User {
    private int UserID;
    private Account Username;
    private String Nickname;
    private String Country;
    private float AccountBalance;
    private String Email;
    private String Avatar;
    private boolean IsDev;
    private Date date;
    private String Decription;
    private boolean IsPrivate;
    
    public User() {
    }

    public User(int UserID, String Nickname, String Country, String Email, String Avatar, Date date, String Decription, boolean IsPrivate) {
        this.UserID = UserID;
        this.Nickname = Nickname;
        this.Country = Country;
        this.Email = Email;
        this.Avatar = Avatar;
        this.date = date;
        this.Decription = Decription;
        this.IsPrivate = IsPrivate;
    }

   

    
    public User(int UserID, Account Username, String Nickname, String Country, float AccountBalance, String Email, String Avatar, boolean IsDev, Date date, String Decription, boolean IsPrivate) {
        this.UserID = UserID;
        this.Username = Username;
        this.Nickname = Nickname;
        this.Country = Country;
        this.AccountBalance = AccountBalance;
        this.Email = Email;
        this.Avatar = Avatar;
        this.IsDev = IsDev;
        this.date = date;
        this.Decription = Decription;
        this.IsPrivate = IsPrivate;
    }

    public User(int UserID, String Nickname, String Country, String Email, String Avatar, String Decription, boolean IsPrivate) {
        this.UserID = UserID;
        this.Nickname = Nickname;
        this.Country = Country;
        this.Email = Email;
        this.Avatar = Avatar;
        this.Decription = Decription;
        this.IsPrivate = IsPrivate;
    }
   

    public User(int UserID, Account Username, String Nickname, String Country, float AccountBalance, String Email, String Avatar, boolean IsDev, Date date) {
        this.UserID = UserID;
        this.Username = Username;
        this.Nickname = Nickname;
        this.Country = Country;
        this.AccountBalance = AccountBalance;
        this.Email = Email;
        this.Avatar = Avatar;
        this.IsDev = IsDev;
        this.date = date;
    }

    public User(String Nickname, String Country, String Email, String Avatar) {
        this.Nickname = Nickname;
        this.Country = Country;
        this.Email = Email;
        this.Avatar = Avatar;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public Account getUsername() {
        return Username;
    }

    public void setUsername(Account Username) {
        this.Username = Username;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String Nickname) {
        this.Nickname = Nickname;
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

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String Avatar) {
        this.Avatar = Avatar;
    }

    public boolean isIsDev() {
        return IsDev;
    }

    public void setIsDev(boolean IsDev) {
        this.IsDev = IsDev;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDecription() {
        return Decription;
    }

    public void setDecription(String Decription) {
        this.Decription = Decription;
    }

    public boolean isIsPrivate() {
        return IsPrivate;
    }

    public void setIsPrivate(boolean IsPrivate) {
        this.IsPrivate = IsPrivate;
    }

    
    
}
