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

    
    //insert payment to database
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

    //get all transaction of an user
    public List<Payment> getAllTransactionHistory(User user) {
        List<Payment> list = new ArrayList<>();
        String sql = "select * from Payment where Paidby = ?";                          //chon toan bo cac giao dich voi id la cua tai khoan duoc truyen vao
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;

        try {
            preparedStatement.setInt(1, user.getUserID());
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {                                                  //doc du lieu va truyen vao list
                Payment payment = new Payment(resultSet.getInt("PaymentID"),
                        user,
                        resultSet.getInt("PaymentMethod"),
                        resultSet.getFloat("Money"),
                        resultSet.getDate("Date"));
                list.add(payment);
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
        return list;                                                                    //tra ve list
    }

    //
    public List<Payment> pagingTransactionHistory(int index, User user) {
        List<Payment> list = new ArrayList<>();
        String sql = "select * from Payment where Paidby = ? order by PaymentID offset ? row fetch next 5 rows only";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            preparedStatement.setInt(1, user.getUserID());
            preparedStatement.setInt(2, (index - 1) * 5);
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {                                                  //doc du lieu va truyen vao list
                Payment payment = new Payment(resultSet.getInt("PaymentID"),
                        user,
                        resultSet.getInt("PaymentMethod"),
                        resultSet.getFloat("Money"),
                        resultSet.getDate("Date"));
                list.add(payment);
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

    //
    public List<Payment> searchPaymentbyKey(User u, String key) {
        List<Payment> list = new ArrayList<>();
        String sql = "Select * from Payment where (Money like '%" + key + "%' or YEAR([Date]) like '%" + key + 
                "%' or MONTH([Date]) like '%" + key + "%' or DAY([Date]) like '%" + key + "%') and Paidby = ?";
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

    //insert payment which is buying game by user to the database
    public void addPaymentBuyGame(User user, Game game) {
        Payment payment = new Payment();
        payment.setUserID(user);
        //payment method 4 = buy game
        payment.setPaymentMethod(4);
        payment.setMoney(-game.getPriceAfterDiscount());
        insertPayment(payment);
    }

}
