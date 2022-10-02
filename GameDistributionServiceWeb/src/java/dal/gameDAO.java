/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Game;
import model.GameCategory;
import model.Media;

/**
 *
 * @author Strongest
 */
public class gameDAO extends DBContext {

//    [GameID]
//      ,[Name]
//      ,[Price]
//      ,[PublishedBy]
//      ,[Download]
//      ,[Rate]
//      ,[Status]
//      ,[Description]
//      ,[Developer]
//      ,[Date]
//        private int GameID;
//    private String Name;
//    private float Price;
//    private String PublishedBy;
//    private String Developer;
//    private int Download;
//    private float Rate;
//    private int Status;
//    private String Description;
//    private Date Date;
    public List<Game> getGame() {
        List<Game> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Game]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Game g = new Game(rs.getInt("GameID"), rs.getString("Name"), rs.getFloat("Price"), rs.getString("PublishedBy"), rs.getString("Developer"), rs.getInt("Download"), rs.getFloat("Rate"), rs.getInt("Status"), rs.getString("Description"), rs.getDate("Date"));
                list.add(g);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Game getGameById(int id) {
        String sql = "SELECT * FROM [dbo].[Game] where GameID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Game g = new Game(rs.getInt("GameID"), rs.getString("Name"), rs.getFloat("Price"), rs.getString("PublishedBy"), rs.getString("Developer"), rs.getInt("Download"), rs.getFloat("Rate"), rs.getInt("Status"), rs.getString("Description"), rs.getDate("Date"));
                return g;
            }
        } catch (SQLException e) {

        }
        return null;
    }

    public Category getCateById(int id) {
        String sql = "SELECT [CategoryID]\n"
                + "      ,[CategoryName]\n"
                + "  FROM [dbo].[Category] where CatagoryID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Category c = new Category(rs.getInt("CategoryID"), rs.getString("CategoryName"));
                return c;
            }
        } catch (SQLException e) {

        }
        return null;
    }

    public List<GameCategory> getCategory() {
        List<GameCategory> list = new ArrayList<>();
        String sql = "SELECT [GameID]\n"
                + "      ,[CategoryID]\n"
                + "  FROM [dbo].[Game-Category]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Game g = getGameById(rs.getInt("GameID"));
                Category c = getCateById(rs.getInt("CategoryID"));
                GameCategory gc = new GameCategory(g, c);
                list.add(gc);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Media getGamePosterByGameID(int GameID) {
        String sql = "SELECT [GameID]\n"
                + "      ,[Link]\n"
                + "      ,[Type]\n"
                + "  FROM [dbo].[Media] where [GameID] = ? AND [Type] = 2";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, GameID);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                Game g = getGameById(rs.getInt("GameID"));
                Media m = new Media(g, rs.getString("Link"), rs.getInt("Type"));
                return m;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        gameDAO gd = new gameDAO();
        List<Game> list = gd.getGame();
        for (Game g : list) {
            System.out.println(g.getName());
        }
        boolean isFirst = false;
        String out = isFirst ? "Yes" : "No";
        System.out.println(out);
        
        Media m = gd.getGamePosterByGameID(3);
        System.out.println(m.getLink());
    }
}
