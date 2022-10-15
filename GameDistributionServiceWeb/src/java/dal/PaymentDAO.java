/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Payment;

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
    
}
