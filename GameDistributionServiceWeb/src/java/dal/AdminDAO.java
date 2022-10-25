/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;
import model.Admin;
import model.User;

/**
 *
 * @author ADMIN
 */
public class AdminDAO extends DBContext {

    //Kiểm tra Account có tồn tại
    public Account checkAccountExist(String username) {
        String sql = "SELECT [Username]\n"
                + "      ,[Password]\n"
                + "      ,[Type]\n"
                + "  FROM [dbo].[Account] where [Username] = ?";
        Connection connection = getConnection();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a = new Account(rs.getString("Username"), rs.getString("Password"), false);
                return a;
            }
        } catch (SQLException e) {

        } finally {
            try {
                connection.close();
            } catch (SQLException e) {

            }
        }
        return null;
    }
    
    
    //tìm Admin bằng Name
    public Admin findAdminByName(String Username) {
        String sql = "SELECT * FROM [dbo].[Admin] where [Name] = ?";
        Admin ad = new Admin();
        Connection connection = getConnection();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, Username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a = checkAccountExist(rs.getString("Name"));
                ad.setAdminID(rs.getInt("AdminID"));
                ad.setName(a);
                ad.setEmail(rs.getString("Email"));
                return ad;
            }

        } catch (SQLException e) {

        } finally {
            try {
                connection.close();
            } catch (SQLException e) {

            }
        }
        return null;
    }
}
