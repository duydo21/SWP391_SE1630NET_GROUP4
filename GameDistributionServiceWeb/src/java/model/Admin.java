/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Strongest
 */
public class Admin {
    private int AdminID;
    private String Email;
    private Account Name;

    public Admin() {
    }

    public Admin(String Email, Account Name) {
        this.Email = Email;
        this.Name = Name;
    }

    public Admin(int AdminID, String Email, Account Name) {
        this.AdminID = AdminID;
        this.Email = Email;
        this.Name = Name;
    }

    public int getAdminID() {
        return AdminID;
    }

    public void setAdminID(int AdminID) {
        this.AdminID = AdminID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Account getName() {
        return Name;
    }

    public void setName(Account Name) {
        this.Name = Name;
    }


    
}
