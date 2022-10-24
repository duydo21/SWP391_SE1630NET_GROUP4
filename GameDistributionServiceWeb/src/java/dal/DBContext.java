/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class DBContext {

    private final static String URL = "jdbc:sqlserver://localhost:1433;databaseName= SWP";
    private final static String USERNAME = "sa";
    private final static String PASSWORD = "123";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            return connection;
        }
    }
    
    public PreparedStatement getPreparedStatement(String sql, Connection connection){
        try{
            return connection.prepareStatement(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ResultSet getResultSet(PreparedStatement preparedStatement){
        try{
            return preparedStatement.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
