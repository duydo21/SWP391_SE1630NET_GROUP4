/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

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
public class CategoryDAO extends DBContext {

    //get Category by ID
    public Category getCategoryByID(int id) {
        String sql = "SELECT * FROM [dbo].[Category]"
                + "  where [CategoryID]=?";
        Connection connection = getConnection();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Category(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {

            }
        }
        return null;
    }
    //Lấy list Category
    public List<Category> getCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Category]";
        Connection connection = getConnection();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("CategoryID"), rs.getString("CategoryName"), rs.getString("Cover"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {

            }
        }
        return list;
    }
    
    //lấy list Game-Category bằng GameID
    public List<Category> getCategoryOfA_Game(int gameID) {
        GameDAO gameDao = new GameDAO();
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Game-Category] where GameID = ?";
        Connection connection = getConnection();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, gameID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new GameCategory(gameDao.getGameById(gameID),
                        getCategoryByID(rs.getInt("CategoryID")))
                        .getCategoryID();
                list.add(c);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
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
}
