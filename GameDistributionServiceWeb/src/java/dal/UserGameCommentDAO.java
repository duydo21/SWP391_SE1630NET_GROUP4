/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DAOInterface.IUserGameCommentDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.UserGameComment;

/**
 *
 * @author ACER
 */
public class UserGameCommentDAO extends DBContext implements IUserGameCommentDAO{

    @Override
    public List<UserGameComment> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(UserGameComment t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(UserGameComment t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(UserGameComment t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UserGameComment getUserCommentOfAGame(int userID, int gameID) {
        String sql = "Select * from [User-Game-Comment] where UserID =? and GameID = ?";
        UserDAO userDAO = new UserDAO();
        GameDAO gameDAO = new GameDAO();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try{
            preparedStatement.setInt(1, userID);
            preparedStatement.setInt(2, gameID);
            resultSet = getResultSet(preparedStatement);
            if(resultSet.next()){
                UserGameComment ugm = new UserGameComment(userDAO.findUserByID(userID),
                        gameDAO.get(gameID), resultSet.getString("Content"));
                return ugm;
            }
        }catch(SQLException e){
        }finally{
            try{
                resultSet.close();
                preparedStatement.close();
                connection.close();
            }catch(SQLException e){
            }
        }
        return null;
    }
    
}
