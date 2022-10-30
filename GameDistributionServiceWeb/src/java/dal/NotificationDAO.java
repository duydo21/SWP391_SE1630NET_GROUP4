/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DAOInterface.INotificationDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Notification;

/**
 *
 * @author ACER
 */
public class NotificationDAO extends DBContext implements INotificationDAO {

    @Override
    public List<Notification> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Notification t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Notification t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Notification t) {
        String sql = "Delete from [Notification] where NotiID = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try {
            preparedStatement.setInt(1, t.getNotiID());
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

    @Override
    public Notification get(int NotiID) {
        String sql = "SELECT * FROM [dbo].[Notification] where NotiID = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            preparedStatement.setInt(1, NotiID);
            resultSet = getResultSet(preparedStatement);
            if (resultSet.next()) {
                Notification g = new Notification(resultSet.getInt("NotiID"),
                        resultSet.getInt("Type"), resultSet.getString("Content"),
                        resultSet.getDate("Date"));
                return g;
            }
        } catch (SQLException e) {
            return null;
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
        }
        return null;
    }

    public void createNotification(String context, int type) {
        String sql = "INSERT INTO [dbo].[Notification]\n"
                + "           ([Type]\n"
                + "           ,[Content]\n"
                + "           ,[Date])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try {
            preparedStatement.setInt(1, type);
            preparedStatement.setString(2, context);
            preparedStatement.setDate(3, date);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

}
