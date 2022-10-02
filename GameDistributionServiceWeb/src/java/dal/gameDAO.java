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
import model.Game;
import model.GameCategory;
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

    //Get all discount game
    public List<Game> getDiscountedGames() {
        List<Game> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Game] where "
                + "[Discount] != 0";
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

    //get games by category
    public List<Game> getGameByCategory(int categoryID) {
        List<Game> listGame = new ArrayList<>();
        categoryDAO caDAO = new categoryDAO();
        String sql = "SELECT * FROM [dbo].[Game-Category]"
                + "where [CategoryID]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, categoryID);
            ResultSet rs = st.executeQuery();
            List<GameCategory> listGameCategory = new ArrayList<>();
            while (rs.next()) {
                listGameCategory.add(new GameCategory(getGameById(rs.getInt(1)),
                        caDAO.getCategoryByID(rs.getInt(2))));
            }
            for (int i = 0; i < listGameCategory.size(); i++) {
                //2 cai getGameID vi 2 model Game va GameCategory co 1 method trung ten
                listGame.add(getGameById(listGameCategory.get(i).getGameID().getGameID()));
            }
            return listGame;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    //get game by id
    public Game getGameById(int gameID) {
        String sql = "SELECT * FROM [dbo].[Game]"
                + "  where [GameID]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, gameID);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Game(rs.getInt("GameID"), rs.getString("Name"),
                        rs.getFloat("Price"), rs.getString("PublishedBy"),
                        rs.getString("Developer"), rs.getInt("Download"),
                        rs.getInt("Discount"), rs.getFloat("Rate"),
                        rs.getInt("Status"), rs.getString("Description"),
                        rs.getDate("Date"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    //get game by name(contain)
    public List<Game> getGameByName(String name) {
        List<Game> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Game]"
                + "where [Name] like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + name + "%");
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

    //get user comment of a game
    public List<UserGameComment> getUserComment(int gameID) {
        List<UserGameComment> list = new ArrayList<>();
        userDAO uDao = new userDAO();
        String sql = "SELECT * FROM [dbo].[User-Game-Comment]"
                + "where [GameID] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, gameID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                UserGameComment comment = new UserGameComment(uDao.findUserByID(
                        rs.getInt(1)), getGameById(rs.getInt(2)), rs.getString(3));
                list.add(comment);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
