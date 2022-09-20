/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Strongest
 */
public class Payment {
    private int PaymentID;
    private User UserID;
    private int PaymentMethod;

    public Payment() {
    }

    public Payment(int PaymentID, User UserID, int PaymentMethod) {
        this.PaymentID = PaymentID;
        this.UserID = UserID;
        this.PaymentMethod = PaymentMethod;
    }

    public Payment(int PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
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
    
    
}
