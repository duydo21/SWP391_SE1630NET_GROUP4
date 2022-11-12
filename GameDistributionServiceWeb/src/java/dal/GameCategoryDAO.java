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
import model.Category;
import model.Game;
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

    @Override
    public List<GameCategory> getGameIDbyCateID(int[] cate) {
        List<GameCategory> game = new ArrayList<>();
        CategoryDAO cd = new CategoryDAO();
        GameDAO gd = new GameDAO();
        String sql = "select * from [Game-Category] where 1=1 and";
        if (cate != null) {
            sql += " (CategoryID = '" + cate[0] + "'";
            for (int i = 1; i < cate.length; i++) {
                sql = sql + " or CategoryID = '" + cate[i] + "'";
            }
            sql = sql + ")";
        }
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        System.out.println(sql);
        try {
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {
                Category c = cd.getCategoryByID(resultSet.getInt("CategoryID"));
                Game g = gd.getGameById(resultSet.getInt("GameID"));
                GameCategory gc = new GameCategory(g, c);
                game.add(gc);
            }
        } catch (SQLException ex) {

        } finally {

        }
        return game;
    }

    public static void main(String[] args) {
        GameCategoryDAO gc = new GameCategoryDAO();
//        List<GameCategory> list = gc.getAll();
//        for (GameCategory g : list) {
//            System.out.println(g.getGameID().getGameID() + " " + g.getCategoryID().getCategoryID());
//        }
        int[] cate = {1, 4};
        List<GameCategory> game = gc.getGameIDbyCateID(cate);
        for (int i = 0; i < game.size(); i++) {
            System.out.println(game.get(i).getGameID().getGameID());
        }
    }
}
