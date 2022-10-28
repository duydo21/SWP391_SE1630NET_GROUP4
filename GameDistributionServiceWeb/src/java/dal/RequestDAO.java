/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DAOInterface.IRequestDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Request;

/**
 *
 * @author ACER
 */
public class RequestDAO extends DBContext implements IRequestDAO{

    @Override
    public List<Request> getAll() {
        UserDAO userDAO  =new UserDAO();
        List<Request> list = new ArrayList<>();
        String sql = "Select * from [Request]";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try{
            resultSet = getResultSet(preparedStatement);
            while(resultSet.next()){
                Request a = new Request(resultSet.getInt("RequestID"), 
                        userDAO.get(resultSet.getInt("RequestBy")), 
                        resultSet.getInt("Status"), resultSet.getString("Content"), 
                        resultSet.getDate("Time"));
                list.add(a);
            }
        }catch(SQLException e){
        }finally{
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
            return list;
        }
    }

    @Override
    public void insert(Request t) {
        String sql = "INSERT [Request] (RequestBy, Status, Content, Time)"
                + "VALUES (?, ?, ?, ?)";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try{
            preparedStatement.setInt(1, t.getRequestBy().getUserID());
            preparedStatement.setInt(2, t.getStatus());
            preparedStatement.setString(3, t.getContext());
            preparedStatement.setDate(3, t.getTime());
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
    public void update(Request t) {
        String sql = "Update [Request] set Status = ? where RequestID = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try{
            preparedStatement.setInt(1, t.getStatus());
            preparedStatement.setInt(2, t.getRequestID());
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
    public void delete(Request t) {
        String sql = "Delete from [Request] where RequestID = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try{
            preparedStatement.setInt(1, t.getRequestID());
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
    public Request get(int RequestID) {
        UserDAO userDAO  =new UserDAO();
        String sql = "Select * from [Request] where RequestID = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try{
            preparedStatement.setInt(1, RequestID);
            resultSet = getResultSet(preparedStatement);
            if(resultSet.next()){
                Request a = new Request(RequestID, 
                        userDAO.get(resultSet.getInt("RequestBy")), 
                        resultSet.getInt("Status"), resultSet.getString("Content"), 
                        resultSet.getDate("Time"));
                return a;
            }
        }catch(SQLException e){
        }finally{
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
            return null;
        }
    }
    
}
