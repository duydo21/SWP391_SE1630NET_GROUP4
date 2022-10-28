/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DAOInterface.IMediaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.Media;

/**
 *
 * @author ACER
 */
public class MediaDAO extends DBContext implements IMediaDAO{

    @Override
    public List<Media> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Media t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Media t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Media t) {
        String sql = "Delete from [Media] where Link = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try{
            preparedStatement.setString(1, t.getLink());
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
    public Media get(String link) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
