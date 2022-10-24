/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
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
public class PaymentDAO extends DBContext {

    public void insertPayment(Payment payment) {
        String sql = "INSERT [dbo].[Payment] "
                + "([Paidby], [PaymentMethod], [Money], [Date]) "
                + "VALUES (?, ?, ?, ?)";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try {
            java.util.Date utilDate = new Date();
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            preparedStatement.setInt(1, payment.getUserID().getUserID());
            preparedStatement.setInt(2, payment.getPaymentMethod());
            preparedStatement.setFloat(3, payment.getMoney());
            preparedStatement.setDate(4, date);
            preparedStatement.executeQuery();
        } catch (SQLException e) {

        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {

            }
        }

    }

    public List<Payment> getAllTransactionHistory(User u) {
        List<Payment> list = new ArrayList<>();
        String sql = "select * from Payment where Paidby = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        
        try {
            preparedStatement.setInt(1, u.getUserID());
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {
                Payment c = new Payment(resultSet.getInt("PaymentID"),
                        u,
                        resultSet.getInt("PaymentMethod"),
                        resultSet.getFloat("Money"),
                        resultSet.getDate("Date"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {

            }
        }
        return list;
    }

    public List<Payment> searchPaymentbyKey(User u, String key) {
        List<Payment> list = new ArrayList<>();
        String sql = "Select * from Payment where (PaymentMethod like '%"+key+"%' or Money like '%"+key+
                "%' or YEAR([Date]) like '%"+key+"%' or MONTH([Date]) like '%"+key+"%' or DAY([Date]) like '%"+key+"%') and Paidby = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            while (resultSet.next()) {
                Payment c = new Payment(resultSet.getInt("PaymentID"),
                        u,
                        resultSet.getInt("PaymentMethod"),
                        resultSet.getFloat("Money"),
                        resultSet.getDate("Date"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {

            }
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
