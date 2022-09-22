/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;
import model.User;

/**
 *
 * @author Strongest
 */
public class userDAO extends DBContext {

    public void createAccount(Account a) {
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "           ([Username]\n"
                + "           ,[Password]\n"
                + "           ,[Type])\n"
                + "     VALUES(?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, a.getUsername());
            st.setString(2, a.getPassword());
            st.setBoolean(3, true);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Account checkAccountExist(String username) {
        String sql = "SELECT [Username]\n"
                + "      ,[Password]\n"
                + "      ,[Type]\n"
                + "  FROM [dbo].[Account] where [Username] = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                Account a = new Account(rs.getString("Username"), rs.getString("Password"), true);
                return a;
            }
        }
        catch(SQLException e){
            
        }
        return null;
    }
    public Account checkLogin(String username , String password) {
        String sql = "SELECT [Username]\n"
                + "      ,[Password]\n"
                + "      ,[Type]\n"
                + "  FROM [dbo].[Account] where [Username] = ? AND [Password] = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                Account a = new Account(rs.getString("Username"), rs.getString("Password"), true);
                return a;
            }
        }
        catch(SQLException e){
            
        }
        return null;
    }
}
