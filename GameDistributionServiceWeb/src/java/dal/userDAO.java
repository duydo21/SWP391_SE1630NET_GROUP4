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

//    public Account getAccountByName(String username) {
//        String sql = "SELECT [Username]\n"
//                + "      ,[Password]\n"
//                + "     ,[Type\n]"
//                + "  FROM [dbo].[Account]\n"
//                + "  where [Username]=?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setString(1, username);
//            ResultSet rs = st.executeQuery();
//            if (rs.next()) {
//                Account a = new Account(rs.getString("Username"), rs.getString("Password"), rs.getBoolean("Type"));
//                return a;
//            }
//        } catch (SQLException e) {
//
//        }
//        return null;
//    }
    public Account checkAccountExist(String username) {
        String sql = "SELECT [Username]\n"
                + "      ,[Password]\n"
                + "      ,[Type]\n"
                + "  FROM [dbo].[Account] where [Username] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a = new Account(rs.getString("Username"), rs.getString("Password"), true);
                return a;
            }
        } catch (SQLException e) {

        }
        return null;
    }

    public Account checkLogin(String username, String password) {
        String sql = "SELECT [Username]\n"
                + "      ,[Password]\n"
                + "      ,[Type]\n"
                + "  FROM [dbo].[Account] where [Username] = ? AND [Password] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a = new Account(rs.getString("Username"), rs.getString("Password"), true);
                return a;
            }
        } catch (SQLException e) {

        }
        return null;
    }

    public void createUser(String name) {
        String sql = "INSERT INTO [dbo].[User]\n"
                + "           ([Name]\n"
                + "           ,[Nickname]\n"
                + "           ,[Country]\n"
                + "           ,[AccountBalance]\n"
                + "           ,[Email]\n"
                + "           ,[Avatar]\n"
                + "           ,[IsDev])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, "No information");
            st.setString(3, "No information");
            st.setFloat(4, 0);
            st.setString(5, "No information");
            st.setString(6, "image/Default Avatar.jpg");
            st.setBoolean(7, false);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public User findUserByName(String Username) {
        String sql = "SELECT * FROM [dbo].[User] where [Name] = ?";
        User u = new User();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, Username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a = checkAccountExist(rs.getString("Name"));
                u.setUserID(rs.getInt("UserID"));
                u.setUsername(a);
                u.setNickname(rs.getString("Nickname"));
                u.setCountry(rs.getString("Country"));
                u.setAccountBalance(rs.getFloat("AccountBalance"));
                u.setEmail(rs.getString("Email"));
                u.setAvatar(rs.getString("Avatar"));
                u.setIsDev(rs.getBoolean("IsDev"));
                return u;
            }

        } catch (SQLException e) {

        }
        return null;
    }

    public User findUserByID(int id) {
        String sql = "SELECT * FROM [dbo].[User] where [UserID] = ?";
        User u = new User();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a = checkAccountExist(rs.getString("Name"));
                u.setUserID(rs.getInt("UserID"));
                u.setUsername(a);
                u.setNickname(rs.getString("Nickname"));
                u.setCountry(rs.getString("Country"));
                u.setAccountBalance(rs.getFloat("AccountBalance"));
                u.setEmail(rs.getString("Email"));
                u.setAvatar(rs.getString("Avatar"));
                u.setIsDev(rs.getBoolean("IsDev"));
            }
            return u;
        } catch (SQLException e) {

        }
        return null;
    }

    public int updateProfileUser(User u) {
        int count = 0;
        String sql = "update [User] set  "
                + "Nickname=?,  Country =?,  [Email] =?,"
                + "Avatar =?, [Description] = ?, IsPrivate = ?  "
                + "where UserID=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, u.getNickname());
            ps.setString(2, u.getCountry());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getAvatar());
            ps.setString(5, u.getDecription());
            ps.setBoolean(6, u.isIsPrivate());
            ps.setInt(7, u.getUserID());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
        }
        return count;
    }

    public int changePassUser(Account a) {
        int count = 0;
        String sql = "update [Account] set Username = ? , "
                + "[Password] = ? where Username=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, a.getUsername());
            ps.setString(2, a.getPassword());
            ps.setString(3, a.getUsername());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
        }
        return count;
    }
    
    public void updateisDevUser(User u) {
        int count = 0;
        String sql = "update [User] set  "
                + "IsDev = ?  "
                + "where UserID=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setBoolean(1, true);
            ps.setInt(2, u.getUserID());
            count = ps.executeUpdate();
        } catch (SQLException e) {

        }
//        return count;
    }

//    public static void main(String[] args) {
//        userDAO ud = new userDAO();
//        Account a = ud.updateProfileUser(u);
//        
//    }
    
}
