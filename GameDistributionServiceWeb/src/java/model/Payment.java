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
public class Payment {
    private int PaymentID;
    private User UserID;
    private int PaymentMethod;
    private float Money;
    private Date Date;
    public Payment() {
    }

    public Payment(int PaymentID, User UserID, int PaymentMethod, float Money, Date Date) {
        this.PaymentID = PaymentID;
        this.UserID = UserID;
        this.PaymentMethod = PaymentMethod;
        this.Money = Money;
        this.Date = Date;
    }

    public Payment(int PaymentMethod, float Money) {
        this.PaymentMethod = PaymentMethod;
        this.Money = Money;
    }

    public int getPaymentID() {
        return PaymentID;
    }

    public void setPaymentID(int PaymentID) {
        this.PaymentID = PaymentID;
    }

    public User getUserID() {
        return UserID;
    }

    public void setUserID(User UserID) {
        this.UserID = UserID;
    }

    public int getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(int PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }

    public float getMoney() {
        return Money;
    }

    public void setMoney(float Money) {
        this.Money = Money;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    
}
