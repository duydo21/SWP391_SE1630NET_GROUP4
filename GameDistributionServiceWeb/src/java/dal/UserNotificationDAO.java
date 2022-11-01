/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DAOInterface.IUserNotificationDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Notification;
import model.User;
import model.UserNotification;

/**
 *
 * @author ACER
 */
public class UserNotificationDAO extends DBContext implements IUserNotificationDAO {

    @Override
    public List<UserNotification> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(UserNotification t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(UserNotification t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(UserNotification t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void adminCreateNotification(String context) {
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
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, context);
            preparedStatement.setDate(3, date);
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
    public void NotificationToUserByID(int notiID, int userID) {
        String sql = "INSERT INTO [dbo].[User-Notification]\n"
                + "           ([NotiID]\n"
                + "           ,[UserID])\n"
                + "     VALUES\n"
                + "           (?,?)";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try {
            preparedStatement.setInt(1, notiID);
            preparedStatement.setInt(1, userID);
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
    public Notification getNotificationByNotiID(int notiID) {
        String sql = "SELECT * FROM [dbo].[Notification] WHERE [NotiID] = ?";
        NotificationDAO nd = new NotificationDAO();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            preparedStatement.setInt(1, notiID);
            resultSet = getResultSet(preparedStatement);
            if (resultSet.next()) {
                Notification n = new Notification(resultSet.getInt("NotiID"), resultSet.getInt("Type"), resultSet.getString("Content"), resultSet.getDate("Date"));
                return n;
            }
        } catch (SQLException e) {
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
}
