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
                        rs.getDate("Date"));
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
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Game getGameById(int id) {
        String sql = "SELECT * FROM [dbo].[Game] where GameID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                    //(int GameID, String Name, float Price, String PublishedBy, String Developer, int Download, int Discount, float Rate, int Status, String Description, Date Date)
                Game g = new Game(rs.getInt("GameID"), rs.getString("Name"), rs.getFloat("Price"), rs.getString("PublishedBy"), rs.getString("Developer"), rs.getInt("Download"),rs.getInt("Discount"), rs.getFloat("Rate"), rs.getInt("Status"), rs.getString("Description"), rs.getDate("Date"));
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

    public Media getGamePosterByGameID(int id) {
        String sql = "SELECT * FROM [dbo].[Media] where Type = 2 AND GameID = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Game g = getGameById(rs.getInt("GameID"));
                Media m = new Media(g, rs.getString("Link"), rs.getInt("Type"));
                return m;
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    public static void main(String[] args) {
        gameDAO gdd = new gameDAO();
        List<Game> list = gdd.getGame();
        Media m = gdd.getGamePosterByGameID(3);
        for(Game g : list){
            System.out.println(g.getName());
        }
        
    }
}
