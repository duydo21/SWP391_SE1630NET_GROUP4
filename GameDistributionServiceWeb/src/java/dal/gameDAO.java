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
import model.UserGameComment;
import model.UserGameRate;

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

    public List<Media> getGameMediaByGameID(int id) {
        String sql = "SELECT * FROM [dbo].[Media] where GameID = ?";
        List<Media> mediaList = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Media m = new Media(getGameById(rs.getInt("GameID")), rs.getString("Link"), rs.getInt("Type"));
                mediaList.add(m);
            }
        } catch (SQLException e) {

        }
        return mediaList;
    }

    public List<UserGameComment> getGameCommentByGameID(int id) {
        String sql = "SELECT * FROM [dbo].[User-Game-Comment] where GameID = ?";
        List<UserGameComment> list = new ArrayList<>();
        userDAO userDao = new userDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                UserGameComment cmt = new UserGameComment(userDao.findUserByID(rs.getInt("UserIDs")), getGameById(rs.getInt("GameID")), rs.getString("Content"));
                list.add(cmt);
            }
        } catch (SQLException e) {

        }
        return list;
    }

    public float getGameRateByID(int id) {
        String sql = "SELECT * FROM [dbo].[User-Game-Rate] where GameID = ?";
        List<UserGameRate> list = new ArrayList<>();
        userDAO userDao = new userDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                UserGameRate rate = new UserGameRate(userDao.findUserByID(rs.getInt("UserIDs")), getGameById(rs.getInt("GameID")), rs.getInt("Rate"));
                list.add(rate);
            }
        } catch (SQLException e) {

        }
        float r = 0;
        for (UserGameRate i : list) {
            r += i.getRate();
        }
        return r / list.size();
    }

    public List<Game> getGameByCategory(Category category) {
        //list chua game
        List<Game> list = new ArrayList<>();
        //list chua game-category
        List<GameCategory> list_gameID = new ArrayList<>();
        categoryDAO cat_DAO = new categoryDAO();
        String sql = "SELECT * FROM [dbo].[Game-Category] where CategoryID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, category.getCategoryID());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                GameCategory gc = new GameCategory(getGameById(rs.getInt("GameID")), cat_DAO.getCategoryByID(rs.getInt("CategoryID")));
                list_gameID.add(gc);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        for (GameCategory gameCategory : list_gameID) {
            list.add(gameCategory.getGameID());
        }
        return list;
    }
    
    public List<Game> searchGamesByName(String name) {
        List<Game> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Game] where [Name] like '%" + name + "%'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Game g = new Game(rs.getInt("GameID"), rs.getString("Name"), rs.getFloat("Price"), rs.getString("PublishedBy"), rs.getString("Developer"), rs.getInt("Download"), rs.getInt("Discount"), rs.getFloat("Rate"), rs.getInt("Status"), rs.getString("Description"), rs.getDate("Date"), rs.getString("Poster"));
                list.add(g);
            }
        } catch (Exception ex) {

        }
        return list;
    }

    public static void main(String[] args) {
        gameDAO gdd = new gameDAO();
        List<Game> list = gdd.searchGamesByName("asdasdasdsa");
        for (Game g : list) {
            System.out.println(g.getName());
        }
        System.out.println(list.size());
    }

}
