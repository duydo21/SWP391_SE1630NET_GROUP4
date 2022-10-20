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
import model.User;
import model.UserGameBuy;
import model.UserGameComment;
import model.UserGameRate;

/**
 *
 * @author Strongest
 */
public class GameDAO extends DBContext {

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
    
    //lay danh sach game
    public List<Game> getGame() {
        List<Game> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Game]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Game g = new Game(rs.getInt("GameID"), rs.getString("Name"),
                        rs.getFloat("Price"), rs.getInt("Download"),
                        rs.getInt("Discount"), rs.getFloat("Rate"),
                        rs.getInt("Status"), rs.getString("Description"),
                        rs.getDate("Date"), rs.getString("Poster"));
                list.add(g);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            return list;
        }

    }
    //lay danh sach game theo trang
    public List<Game> getGameByPage(List<Game> list, int start, int end) {
        List<Game> pGame = new ArrayList<>();
        for (int i = start; i < end; i++) {
            pGame.add(list.get(i));
        }
        return pGame;
    }
    //lay danh sach game dua tren category theo trang
    public List<GameCategory> getGameByCategoryByPage(List<GameCategory> list, int start, int end) {
        List<GameCategory> cGame = new ArrayList<>();
        for (int i = start; i < end; i++) {
            cGame.add(list.get(i));
        }
        return cGame;
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
                        rs.getFloat("Price"), rs.getInt("Download"),
                        rs.getInt("Discount"), rs.getFloat("Rate"),
                        rs.getInt("Status"), rs.getString("Description"),
                        rs.getDate("Date"), rs.getString("Poster"));
                list.add(g);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            return list;
        }
    }
    
    //lay top ban chay
    public List<Game> getBestSeller() {
        List<Game> list = new ArrayList<>();
        String sql = "select * from Game where [Status] != 2 order by Download desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Game g = new Game(rs.getInt("GameID"), rs.getString("Name"),
                        rs.getFloat("Price"), rs.getInt("Download"),
                        rs.getInt("Discount"), rs.getFloat("Rate"),
                        rs.getInt("Status"), rs.getString("Description"),
                        rs.getDate("Date"), rs.getString("Poster"));
                list.add(g);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            return list;
        }
    }

    //lay 10 game top ban chay
    public List<Game> get10BestSeller() {
        List<Game> list = new ArrayList<>();
        String sql = "select top 10 * from Game where [Status] != 2 order by Download desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Game g = new Game(rs.getInt("GameID"), rs.getString("Name"),
                        rs.getFloat("Price"), rs.getInt("Download"),
                        rs.getInt("Discount"), rs.getFloat("Rate"),
                        rs.getInt("Status"), rs.getString("Description"),
                        rs.getDate("Date"), rs.getString("Poster"));
                list.add(g);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            return list;
        }
    }

    //lay game moi nhat
    public List<Game> getNewRelease() {
        List<Game> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Game] where [Status] != 2 order by [Date] desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Game g = new Game(rs.getInt("GameID"), rs.getString("Name"),
                        rs.getFloat("Price"), rs.getInt("Download"),
                        rs.getInt("Discount"), rs.getFloat("Rate"),
                        rs.getInt("Status"), rs.getString("Description"),
                        rs.getDate("Date"), rs.getString("Poster"));
                list.add(g);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            return list;
        }
    }

    //lay 10 game moi nhat
    public List<Game> get10NewRelease() {
        List<Game> list = new ArrayList<>();
        String sql = "SELECT top 10 * FROM [dbo].[Game] where [Status] != 2 order by [Date] desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Game g = new Game(rs.getInt("GameID"), rs.getString("Name"),
                        rs.getFloat("Price"), rs.getInt("Download"),
                        rs.getInt("Discount"), rs.getFloat("Rate"),
                        rs.getInt("Status"), rs.getString("Description"),
                        rs.getDate("Date"), rs.getString("Poster"));
                list.add(g);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            return list;
        }
    }

    //lay game dua theo id
    public Game getGameById(int id) {
        String sql = "SELECT * FROM [dbo].[Game] where GameID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                //(int GameID, String Name, float Price, int Download, int Discount, float Rate, int Status, String Description, Date Date)
                Game g = new Game(rs.getInt("GameID"), rs.getString("Name"), rs.getFloat("Price"), rs.getInt("Download"), rs.getInt("Discount"), rs.getFloat("Rate"), rs.getInt("Status"), rs.getString("Description"), rs.getDate("Date"), rs.getString("Poster"));
                return g;
            }
        } catch (SQLException e) {

        } finally {
            return null;
        }
    }

    //lay anh demo, video dua tren game id
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

        } finally {
            return mediaList;
        }
    }

    //lay comment nguoi dung dua tren game id
    public List<UserGameComment> getGameCommentByGameID(int id) {
        String sql = "SELECT * FROM [dbo].[User-Game-Comment] where GameID = ?";
        List<UserGameComment> list = new ArrayList<>();
        UserDAO userDao = new UserDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                UserGameComment cmt = new UserGameComment(userDao.findUserByID(rs.getInt("UserIDs")), getGameById(rs.getInt("GameID")), rs.getString("Content"));
                list.add(cmt);
            }
        } catch (SQLException e) {

        } finally {
            return list;
        }
    }

    //lay danh gia nguoi dung dua tren game id
    public float getGameRateByID(int id) {
        String sql = "SELECT * FROM [dbo].[User-Game-Rate] where GameID = ?";
        List<UserGameRate> list = new ArrayList<>();
        UserDAO userDao = new UserDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                UserGameRate rate = new UserGameRate(userDao.findUserByID(rs.getInt("UserIDs")), getGameById(rs.getInt("GameID")), rs.getInt("Rate"));
                list.add(rate);
            }
        } catch (SQLException e) {

        } finally {
            float r = 0;
            for (UserGameRate i : list) {
                r += i.getRate();
            }
            return r / list.size();
        }
    }

    //lay game dua theo category cua game hien tai
    public List<Game> getRecomendByCategory(Category category) {
        //list chua game
        List<Game> list = new ArrayList<>();
        //list chua game-category
        List<GameCategory> list_gameID = new ArrayList<>();
        CategoryDAO cat_DAO = new CategoryDAO();
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
        } finally {
            for (GameCategory gameCategory : list_gameID) {
                list.add(gameCategory.getGameID());
            }
            return list;
        }
    }

    //lay game dua theo category
    public List<GameCategory> getGameByCategory(int cate) {
        //list chua game-category
        List<GameCategory> list = new ArrayList<>();
        CategoryDAO cat_DAO = new CategoryDAO();
        String sql = "SELECT * FROM [dbo].[Game-Category] where CategoryID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cate);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                GameCategory gc = new GameCategory(getGameById(rs.getInt("GameID")), cat_DAO.getCategoryByID(rs.getInt("CategoryID")));
                list.add(gc);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            return list;
        }
    }

    //tim game theo teen
    public List<Game> searchGamesByName(String name) {
        List<Game> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Game] where [Name] like '%" + name + "%'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Game g = new Game(rs.getInt("GameID"), rs.getString("Name"), rs.getFloat("Price"), rs.getInt("Download"), rs.getInt("Discount"), rs.getFloat("Rate"), rs.getInt("Status"), rs.getString("Description"), rs.getDate("Date"), rs.getString("Poster"));
                list.add(g);
            }
        } catch (Exception ex) {

        } finally {
            return list;
        }
    }

    //sap xep danh sach game theo ten
    public List<Game> sortGameByName() {
        String sql = "SELECT * FROM [dbo].[Game] order by Name ASC";
        List<Game> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Game g = new Game(rs.getInt("GameID"), rs.getString("Name"),
                        rs.getFloat("Price"), rs.getInt("Download"),
                        rs.getInt("Discount"), rs.getFloat("Rate"),
                        rs.getInt("Status"), rs.getString("Description"),
                        rs.getDate("Date"), rs.getString("Poster"));
                list.add(g);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            return list;
        }
    }

    //sap xep danh sach game theo gia tien
    public List<Game> sortGameByPrice() {
        String sql = "SELECT * FROM [dbo].[Game] order by Price ASC";
        List<Game> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Game g = new Game(rs.getInt("GameID"), rs.getString("Name"),
                        rs.getFloat("Price"), rs.getInt("Download"),
                        rs.getInt("Discount"), rs.getFloat("Rate"),
                        rs.getInt("Status"), rs.getString("Description"),
                        rs.getDate("Date"), rs.getString("Poster"));
                list.add(g);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            return list;
        }
    }

    //lay lich su mua game cua user dua theo id
    public List<UserGameBuy> getUserGameBuybyId(int userid) {
        UserDAO usAO = new UserDAO();
        GameDAO gAO = new GameDAO();
        List<UserGameBuy> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[User-Game-Buy] where UserID =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User u = usAO.findUserByID(rs.getInt("UserID"));
                Game g = gAO.getGameById(rs.getInt("GameID"));

                UserGameBuy ug = new UserGameBuy(u, g, rs.getDate("Date"));
                list.add(ug);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            return list;
        }
    }

    //lay tat ca giao dich cua user
    public List<UserGameBuy> getUserGameBuy() {
        UserDAO usAO = new UserDAO();
        List<UserGameBuy> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[User-Game-Buy]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User u = usAO.findUserByID(rs.getInt("UserID"));
                Game g = getGameById(rs.getInt("GameID"));

                UserGameBuy ug = new UserGameBuy(u, g, rs.getDate("Date"));
                list.add(ug);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            return list;
        }
    }

    //lay game co giam gia
    public List<Game> getDeals() {
        List<Game> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Game] where "
                + "[Discount] != 0";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Game g = new Game(rs.getInt("GameID"), rs.getString("Name"),
                        rs.getFloat("Price"), rs.getInt("Download"),
                        rs.getInt("Discount"), rs.getFloat("Rate"),
                        rs.getInt("Status"), rs.getString("Description"),
                        rs.getDate("Date"), rs.getString("Poster"));
                list.add(g);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            return list;
        }
    }

    public static void main(String[] args) {
        GameDAO gdd = new GameDAO();

        List<UserGameBuy> list = gdd.getUserGameBuy();
        for (UserGameBuy g : list) {
            System.out.println(g.getUserID().getUserID());
            System.out.println(g.getGameID().getGameID());
            System.out.println(g.getContent());
        }
        System.out.println(list.size());
    }

}