/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DAOInterface.IAccountDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;

/**
 *
 * @author ACER
 */
public class AccountDAO extends DBContext implements IAccountDAO {

    @Override
    public List<Account> getAll() {
        List<Account> list = new ArrayList<>();

        String sql = "SELECT * FROM [Account]";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {
                Account a = new Account(resultSet.getString("Username"), resultSet.getString("Password"), resultSet.getBoolean("Type"));
                list.add(a);
            }
        } catch (SQLException e) {
        } finally {
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
    public void insert(Account t) {
        String sql = "INSERT [Account] (Username, Password, Type)"
                + "VALUES (?, ?, ?)";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try{
            preparedStatement.setString(1, t.getUsername());
            preparedStatement.setString(2, t.getPassword());
            preparedStatement.setBoolean(3, t.isType());
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
    public void update(Account t) {
        String sql = "Update [Account] set Password = ? where Username = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try{
            preparedStatement.setString(1, t.getPassword());
            preparedStatement.setString(2, t.getUsername());
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
    public void delete(Account t) {
        String sql = "Delete from [Account] where Username = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try{
            preparedStatement.setString(1, t.getUsername());
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
    public Account get(String username) {
        String sql = "Select * from [Account] where Username = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try{
            preparedStatement.setString(1, username);
            resultSet = getResultSet(preparedStatement);
            if(resultSet.next()){
                Account a = new Account(resultSet.getString("Username"), resultSet.getString("Password"), resultSet.getBoolean("Type"));
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
