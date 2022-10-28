/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DAOInterface.ICategoryDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.GameCategory;

/**
 *
 * @author ACER
 */
public class CategoryDAO extends DBContext implements ICategoryDAO{

    //get Category by ID
    @Override
    public Category getCategoryByID(int id) {
        String sql = "SELECT * FROM [dbo].[Category]"
                + "  where [CategoryID]=?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            preparedStatement.setInt(1, id);
            resultSet = getResultSet(preparedStatement);
            if (resultSet.next()) {
                return new Category(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
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

    //Lấy list Category
    @Override
    public List<Category> getCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Category]";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {
                Category c = new Category(resultSet.getInt("CategoryID"), resultSet.getString("CategoryName"), resultSet.getString("Cover"));
                list.add(c);
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

    //lấy list Game-Category bằng GameID
    @Override
    public List<Category> getCategoryOfA_Game(int gameID) {
        GameDAO gameDao = new GameDAO();
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Game-Category] where GameID = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            preparedStatement.setInt(1, gameID);
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {
                Category c = new GameCategory(gameDao.getGameById(gameID),
                        getCategoryByID(resultSet.getInt("CategoryID")))
                        .getCategoryID();
                list.add(c);
            }
            return list;
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

    public static void main(String[] args) {
        CategoryDAO cd = new CategoryDAO();

        List<Category> list = cd.getCategory();

        System.out.println(list.size());
    }

    @Override
    public List<Category> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Category t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Category t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Category t) {
        String sql = "Delete from [Category] where CategoryID = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try{
            preparedStatement.setInt(1, t.getCategoryID());
            preparedStatement.executeQuery();
        }catch(SQLException e){
        }finally{
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    @Override
    public Category get(int CategoryID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
