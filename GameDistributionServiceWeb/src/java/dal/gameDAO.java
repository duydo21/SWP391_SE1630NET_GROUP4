/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.Category;
import model.Game;
import model.GameCategory;
import model.Media;
import model.UserGameComment;

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
//      ,[Discount]
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
                Game g = new Game(rs.getInt("GameID"), rs.getString("Name"),
                        rs.getFloat("Price"), rs.getString("PublishedBy"),
                        rs.getString("Developer"), rs.getInt("Download"),
                        rs.getInt("Discount"), rs.getFloat("Rate"),
                        rs.getInt("Status"), rs.getString("Description"),
                        rs.getDate("Date"), rs.getString("Poster"));
                list.add(g);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //sort gameList dc truyen vao by Download/price/discount
    public List<Game> sortGameList(List<Game> gameList, int sortType) {
//        sortType = 1,2,3 -> download, price, discount
        gameList.sort((Game g1, Game g2) -> {
            if (sortType == 1) {
                return Integer.compare(g1.getDownload(), g2.getDownload());
            } else if (sortType == 2) {
                return Float.compare(g1.getPrice(), g2.getPrice());
            }
            return Integer.compare(g1.getDiscount(), g2.getDiscount());
        });
        return gameList;
    }

    //Get all free game
    public List<Game> getFreeGames() {
        List<Game> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Game] where "
                + "[price] = 0";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Game g = new Game(rs.getInt("GameID"), rs.getString("Name"),
                        rs.getFloat("Price"), rs.getString("PublishedBy"),
                        rs.getString("Developer"), rs.getInt("Download"),
                        rs.getInt("Discount"), rs.getFloat("Rate"),
                        rs.getInt("Status"), rs.getString("Description"),
                        rs.getDate("Date"), rs.getString("Poster"));
                list.add(g);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Game> getBestSeller() {
        List<Game> list = new ArrayList<>();
        String sql = "select * from Game where [Status] != 2 order by Download desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Game g = new Game(rs.getInt("GameID"), rs.getString("Name"),
                        rs.getFloat("Price"), rs.getString("PublishedBy"),
                        rs.getString("Developer"), rs.getInt("Download"),
                        rs.getInt("Discount"), rs.getFloat("Rate"),
                        rs.getInt("Status"), rs.getString("Description"),
                        rs.getDate("Date"), rs.getString("Poster"));
                list.add(g);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public List<Game> getNewRelease() {
        List<Game> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Game] where [Status] != 2 order by [Date] desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Game g = new Game(rs.getInt("GameID"), rs.getString("Name"),
                        rs.getFloat("Price"), rs.getString("PublishedBy"),
                        rs.getString("Developer"), rs.getInt("Download"),
                        rs.getInt("Discount"), rs.getFloat("Rate"),
                        rs.getInt("Status"), rs.getString("Description"),
                        rs.getDate("Date"), rs.getString("Poster"));
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
                //(int GameID, String Name, float Price, String PublishedBy, String Developer, int Download, int Discount, float Rate, int Status, String Description, Date Date)
                Game g = new Game(rs.getInt("GameID"), rs.getString("Name"), rs.getFloat("Price"), rs.getString("PublishedBy"), rs.getString("Developer"), rs.getInt("Download"), rs.getInt("Discount"), rs.getFloat("Rate"), rs.getInt("Status"), rs.getString("Description"), rs.getDate("Date"), rs.getString("Poster"));
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

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
        gameDAO gdd = new gameDAO();
        List<Game> list = gdd.getGame();
        for(Game g: list){
            System.out.println(g);
        }
    }
}
