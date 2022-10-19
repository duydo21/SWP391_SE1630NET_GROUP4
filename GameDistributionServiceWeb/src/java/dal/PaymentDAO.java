/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Game;
import model.Payment;
import model.User;

/**
 *
 * @author ACER
 */
public class PaymentDAO extends DBContext{

    public void insertPayment(Payment payment) {
        String sql = "INSERT [dbo].[Payment] "
                + "([Paidby], [PaymentMethod], [Money]) "
                + "VALUES (?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, payment.getUserID().getUserID());
            st.setInt(2, payment.getPaymentMethod());
            st.setFloat(3, payment.getMoney());
            st.executeQuery();
        } catch (SQLException e) {

        }
    
    }
    
    public List<Payment> getAllTransactionHistory(User u) {
        List<Payment> list = new ArrayList<>();
        String sql = "select * from Payment where Paidby = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, u.getUserID());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Payment c = new Payment(rs.getInt("PaymentID"),
                        u,
                        rs.getInt("PaymentMethod"),
                        rs.getFloat("Money"),
                        rs.getDate("Date"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public void addPaymentBuyGame(User u, Game g) {
        Payment p = new Payment();
        p.setUserID(u);
        p.setPaymentMethod(4);
        p.setMoney(-g.getPriceAfterDiscount());
        insertPayment(p);
    }
    
}
