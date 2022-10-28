/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DAOInterface.INotificationDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.Notification;

/**
 *
 * @author ACER
 */
public class NotificationDAO extends DBContext implements INotificationDAO{

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
        try{
            preparedStatement.setInt(1, t.getNotiID());
            preparedStatement.executeQuery();
        }catch(SQLException e){
        }finally{
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    @Override
    public Notification get(int NotiID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
