/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import model.Game;
import model.User;
import model.UserGameBuy;

/**
 *
 * @author ACER
 */
public class UserGameBuyDAO extends DBContext {

    public UserGameBuy isGameIDBoughtByUserID(int userID, int gameID) {
        GameDAO g_Dao = new GameDAO();
        UserDAO u_Dao = new UserDAO();
        String sql = "SELECT * FROM [dbo].[User-Game-Buy]"
                + "  where [GameID]=? and [UserID] =?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            preparedStatement.setInt(1, gameID);
            preparedStatement.setInt(2, userID);
            resultSet = getResultSet(preparedStatement);;
            if (resultSet.next()) {
                return new UserGameBuy(u_Dao.findUserByID(resultSet.getInt(1)),
                         g_Dao.getGameById(resultSet.getInt(2)), resultSet.getDate(3));
            }
        } catch (SQLException e) {
            System.out.println(e);
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

    public void addBuyGame(User u, Game g) {
        String sql = "INSERT [dbo].[User-Game-Buy] "
                + "VALUES (?, ?,?)";
        Connection connection = getConnection();
        Date todayDate = new Date();
        java.sql.Date d = new java.sql.Date(todayDate.getTime());
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try {
            preparedStatement.setInt(1, u.getUserID());
            preparedStatement.setInt(2, g.getGameID());
            preparedStatement.setDate(3, d);
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

}
