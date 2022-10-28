/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DAOInterface.IAdminDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Admin;
import model.Game;
import model.User;
import model.UserGameReport;

/**
 *
 * @author Strongest
 */
public class AdminDAO extends DBContext implements IAdminDAO{

    UserDAO ud = new UserDAO();
    GameDAO gd = new GameDAO();

    //lay report game cua user
    public List<UserGameReport> getReport() {
        List<UserGameReport> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[User-Game-Report]";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {
                User u = ud.findUserByID(resultSet.getInt("UserID"));
                Game g = gd.getGameById(resultSet.getInt("GameID"));
                UserGameReport ugr = new UserGameReport(u, g, resultSet.getString("Content"), resultSet.getDate("Date"));
                list.add(ugr);
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
        return list;
    }

    //Kiểm tra Account có tồn tại
    public Account checkAccountExist(String username) {
        String sql = "SELECT [Username]\n"
                + "      ,[Password]\n"
                + "      ,[Type]\n"
                + "  FROM [dbo].[Account] where [Username] = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            preparedStatement.setString(1, username);
            resultSet = getResultSet(preparedStatement);
            if (resultSet.next()) {
                Account a = new Account(resultSet.getString("Username"), resultSet.getString("Password"), false);
                return a;
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

    //tìm Admin bằng Name
    public Admin findAdminByName(String Username) {
        String sql = "SELECT * FROM [dbo].[Admin] where [Name] = ?";
        Admin ad = new Admin();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            preparedStatement.setString(1, Username);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Account a = checkAccountExist(resultSet.getString("Name"));
                ad.setAdminID(resultSet.getInt("AdminID"));
                ad.setName(a);
                ad.setEmail(resultSet.getString("Email"));
                return ad;
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

    @Override
    public List<Admin> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Admin t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Admin t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Admin t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
