/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DAOInterface.IUserGameRateDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Game;
import model.User;
import model.UserGameRate;

/**
 *
 * @author ACER
 */
public class UserGameRateDAO extends DBContext implements IUserGameRateDAO{

    //get list UserRateOfGame by userId and GAmeid
    @Override
    public UserGameRate getUserRateOfGame(User user, Game game) {
        String sql = "Select * from [User-Game-Rate] where UserID=? and GameID=?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        UserGameRate userGameRate = null;
        try {
            preparedStatement.setInt(1, user.getUserID());
            preparedStatement.setInt(2, game.getGameID());
            resultSet = getResultSet(preparedStatement);
            if (resultSet.next()) {
                userGameRate = new UserGameRate(user, game, resultSet.getInt("Rate"));
            }
            return userGameRate;
        } catch (SQLException e) {
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
        }
        return userGameRate;
    }

    //Insert in UserGameRate
    @Override
    public void insert(UserGameRate userGameRate) {
        String sql = "Insert [User-Game-Rate] (UserID, GameID, Rate) "
                + "VALUES (?,?,?)";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try {
            preparedStatement.setInt(1, userGameRate.getUserID().getUserID());
            preparedStatement.setInt(2, userGameRate.getGameID().getGameID());
            preparedStatement.setInt(3, userGameRate.getRate());
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

    //Update UserGameRate
    @Override
    public void update(UserGameRate userGameRate) {
        String sql = "Update [User-Game-Rate] set "
                + "Rate =? where UserID =? and GameID=?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try {
            preparedStatement.setInt(1, userGameRate.getRate());
            preparedStatement.setInt(2, userGameRate.getUserID().getUserID());
            preparedStatement.setInt(3, userGameRate.getGameID().getGameID());
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

    @Override
    public List<UserGameRate> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(UserGameRate t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
