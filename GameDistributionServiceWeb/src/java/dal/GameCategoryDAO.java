/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DAOInterface.IGameCategoryDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.GameCategory;

/**
 *
 * @author ACER
 */
public class GameCategoryDAO extends DBContext implements IGameCategoryDAO {

    @Override
    public List<GameCategory> getAll() {
        List<GameCategory> list = new ArrayList<>();
        GameDAO g_Dao = new GameDAO();
        CategoryDAO c_Dao = new CategoryDAO();
        String sql = "Select * From [dbo].[Game-Category]";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        resultSet = getResultSet(preparedStatement);
        try {
            while (resultSet.next()) {
                GameCategory u = new GameCategory(g_Dao.getGameById(resultSet.getInt("GameID")), c_Dao.getCategoryByID(resultSet.getInt("CategoryID")));
                list.add(u);
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

    @Override
    public void insert(GameCategory t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(GameCategory t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(GameCategory t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertGameCategory(GameCategory gc) {
        String sql = "INSERT INTO [dbo].[Game-Category]\n"
                + "           ([GameID]\n"
                + "           ,[CategoryID])\n"
                + "     VALUES\n"
                + "           (?,?)";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
            preparedStatement.setInt(1, gc.getGameID().getGameID());
            preparedStatement.setInt(2, gc.getCategoryID().getCategoryID());
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        GameCategoryDAO gc = new GameCategoryDAO();
        List<GameCategory> list = gc.getAll();
        for (GameCategory g : list) {
            System.out.println(g.getGameID().getGameID() + " " + g.getCategoryID().getCategoryID());

        }
    }
}
