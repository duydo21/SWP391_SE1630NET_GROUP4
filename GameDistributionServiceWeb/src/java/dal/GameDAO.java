/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DAOInterface.IGameDAO;
import java.sql.Connection;
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
public class GameDAO extends DBContext implements IGameDAO{

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

    //lay danh sach game
    @Override
    public List<Game> getGame() {
        List<Game> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Game]";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {
                Game g = new Game(resultSet.getInt("GameID"), resultSet.getString("Name"),
                        resultSet.getFloat("Price"), resultSet.getInt("Download"),
                        resultSet.getInt("Discount"), resultSet.getFloat("Rate"),
                        resultSet.getInt("Status"), resultSet.getString("Description"),
                        resultSet.getDate("Date"), resultSet.getString("Poster"));
                list.add(g);
            }
        } catch (SQLException e) {
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
            return list;
        }
    }

    //lay danh sach game theo trang
    @Override
    public List<Game> getGameByPage(List<Game> list, int start, int end) {
        List<Game> pGame = new ArrayList<>();
        for (int i = start; i < end; i++) {
            pGame.add(list.get(i));
        }
        return pGame;
    }

    //lay danh sach game dua tren category theo trang
    @Override
    public List<GameCategory> getGameByCategoryByPage(List<GameCategory> list, int start, int end) {
        List<GameCategory> cGame = new ArrayList<>();
        for (int i = start; i < end; i++) {
            cGame.add(list.get(i));
        }
        return cGame;
    }

    //sort gameList dc truyen vao by Download/price/discount
    @Override
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
    @Override
    public List<Game> getFreeGames() {
        List<Game> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Game] where "
                + "[price] = 0";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {
                Game g = new Game(resultSet.getInt("GameID"), resultSet.getString("Name"),
                        resultSet.getFloat("Price"), resultSet.getInt("Download"),
                        resultSet.getInt("Discount"), resultSet.getFloat("Rate"),
                        resultSet.getInt("Status"), resultSet.getString("Description"),
                        resultSet.getDate("Date"), resultSet.getString("Poster"));
                list.add(g);
            }
        } catch (SQLException e) {
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
            return list;
        }
    }

    //lay 10 game mien phi
    @Override
    public List<Game> get10FreeGames() {
        List<Game> list = new ArrayList<>();
        String sql = "select top 10 * FROM [dbo].[Game] where "
                + "[price] = 0";
        Connection connection = getConnection();
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
            try {
                connection.close();
            } catch (SQLException e) {

            }
            return list;
        }
    }

    //lay top ban chay
    @Override
    public List<Game> getBestSeller() {
        List<Game> list = new ArrayList<>();
        String sql = "select * from Game where [Status] != 2 order by Download desc";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {
                Game g = new Game(resultSet.getInt("GameID"), resultSet.getString("Name"),
                        resultSet.getFloat("Price"), resultSet.getInt("Download"),
                        resultSet.getInt("Discount"), resultSet.getFloat("Rate"),
                        resultSet.getInt("Status"), resultSet.getString("Description"),
                        resultSet.getDate("Date"), resultSet.getString("Poster"));
                list.add(g);
            }
        } catch (SQLException e) {
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
            return list;
        }
    }

    //lay 10 game top ban chay
    @Override
    public List<Game> get10BestSeller() {
        List<Game> list = new ArrayList<>();
        String sql = "select top 10 * from Game where [Status] != 2 order by Download desc";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {
                Game g = new Game(resultSet.getInt("GameID"), resultSet.getString("Name"),
                        resultSet.getFloat("Price"), resultSet.getInt("Download"),
                        resultSet.getInt("Discount"), resultSet.getFloat("Rate"),
                        resultSet.getInt("Status"), resultSet.getString("Description"),
                        resultSet.getDate("Date"), resultSet.getString("Poster"));
                list.add(g);
            }
        } catch (SQLException e) {
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
            return list;
        }
    }

    //lay game moi nhat
    @Override
    public List<Game> getNewRelease() {
        List<Game> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Game] where [Status] != 2 order by [Date] desc";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {
                Game g = new Game(resultSet.getInt("GameID"), resultSet.getString("Name"),
                        resultSet.getFloat("Price"), resultSet.getInt("Download"),
                        resultSet.getInt("Discount"), resultSet.getFloat("Rate"),
                        resultSet.getInt("Status"), resultSet.getString("Description"),
                        resultSet.getDate("Date"), resultSet.getString("Poster"));
                list.add(g);
            }
        } catch (SQLException e) {
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
            return list;
        }
    }

    //lay 10 game moi nhat
    @Override
    public List<Game> get10NewRelease() {
        List<Game> list = new ArrayList<>();
        String sql = "SELECT top 10 * FROM [dbo].[Game] where [Status] != 2 order by [Date] desc";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {
                Game g = new Game(resultSet.getInt("GameID"), resultSet.getString("Name"),
                        resultSet.getFloat("Price"), resultSet.getInt("Download"),
                        resultSet.getInt("Discount"), resultSet.getFloat("Rate"),
                        resultSet.getInt("Status"), resultSet.getString("Description"),
                        resultSet.getDate("Date"), resultSet.getString("Poster"));
                list.add(g);
            }
        } catch (SQLException e) {
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
            return list;
        }
    }

    //lay game dua theo id
    @Override
    public Game getGameById(int id) {
        String sql = "SELECT * FROM [dbo].[Game] where GameID = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            preparedStatement.setInt(1, id);
            resultSet = getResultSet(preparedStatement);
            if (resultSet.next()) {
                //(int GameID, String Name, float Price, int Download, int Discount, float Rate, int Status, String Description, Date Date)
                Game g = new Game(resultSet.getInt("GameID"), resultSet.getString("Name"), resultSet.getFloat("Price"), resultSet.getInt("Download"), resultSet.getInt("Discount"), resultSet.getFloat("Rate"), resultSet.getInt("Status"), resultSet.getString("Description"), resultSet.getDate("Date"), resultSet.getString("Poster"));
                return g;
            }
        } catch (SQLException e) {
            return null;
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

    //lay anh demo, video dua tren game id
    @Override
    public List<Media> getGameMediaByGameID(int id) {
        String sql = "SELECT * FROM [dbo].[Media] where GameID = ?";
        List<Media> mediaList = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            preparedStatement.setInt(1, id);
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {
                Media m = new Media(getGameById(resultSet.getInt("GameID")), resultSet.getString("Link"), resultSet.getInt("Type"));
                mediaList.add(m);
            }
        } catch (SQLException e) {
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
            return mediaList;
        }
    }

    //lay comment nguoi dung dua tren game id
    @Override
    public List<UserGameComment> getGameCommentByGameID(int id) {
        String sql = "SELECT * FROM [dbo].[User-Game-Comment] where GameID = ?";
        Connection connection = getConnection();
        PreparedStatement  preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        List<UserGameComment> list = new ArrayList<>();
        UserDAO userDao = new UserDAO();
        try {
            preparedStatement.setInt(1, id);
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {
                UserGameComment cmt = new UserGameComment(userDao.findUserByID(resultSet.getInt("UserID")), getGameById(resultSet.getInt("GameID")), resultSet.getString("Content"));
                list.add(cmt);
            }
        } catch (SQLException e) {
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
            return list;
        }
    }

    //lay danh gia nguoi dung dua tren game id
    @Override
    public float getGameRateByID(int id) {
        String sql = "SELECT * FROM [dbo].[User-Game-Rate] where GameID = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        List<UserGameRate> list = new ArrayList<>();
        UserDAO userDao = new UserDAO();
        try {
            preparedStatement.setInt(1, id);
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {
                UserGameRate rate = new UserGameRate(userDao.findUserByID(resultSet.getInt("UserID")), getGameById(resultSet.getInt("GameID")), resultSet.getInt("Rate"));
                list.add(rate);
            }
        } catch (SQLException e) {
        } finally {
            float r = 0;
            for (UserGameRate i : list) {
                if (i.getRate() == 1) {
                    r += i.getRate();
                }
            }
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            } finally {
                return r / list.size() * 10;
            }
        }
    }

    //lay game dua theo category cua game hien tai
    @Override
    public List<Game> getRecomendByCategory(Category category) {
        //list chua game
        List<Game> list = new ArrayList<>();
        //list chua game-category
        List<GameCategory> list_gameID = new ArrayList<>();
        CategoryDAO cat_DAO = new CategoryDAO();
        String sql = "SELECT * FROM [dbo].[Game-Category] where CategoryID = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            preparedStatement.setInt(1, category.getCategoryID());
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {
                GameCategory gc = new GameCategory(getGameById(resultSet.getInt("GameID")), cat_DAO.getCategoryByID(resultSet.getInt("CategoryID")));
                list_gameID.add(gc);
            }
        } catch (SQLException e) {
        } finally {
            for (GameCategory gameCategory : list_gameID) {
                list.add(gameCategory.getGameID());
            }
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
            return list;
        }
    }

    //lay game dua theo category
    @Override
    public List<GameCategory> getGameByCategory(int cate) {
        //list chua game-category
        List<GameCategory> list = new ArrayList<>();
        CategoryDAO cat_DAO = new CategoryDAO();
        String sql = "SELECT * FROM [dbo].[Game-Category] where CategoryID = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            preparedStatement.setInt(1, cate);
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {
                GameCategory gc = new GameCategory(getGameById(resultSet.getInt("GameID")), cat_DAO.getCategoryByID(resultSet.getInt("CategoryID")));
                list.add(gc);
            }
        } catch (SQLException e) {
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
            return list;
        }
    }

    //tim game theo teen
    @Override
    public List<Game> searchGamesByName(String name) {
        List<Game> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Game] where [Name] like '%" + name + "%'";
        Connection connection = getConnection();
        PreparedStatement preparedStatement= getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {
                Game g = new Game(resultSet.getInt("GameID"), resultSet.getString("Name"), resultSet.getFloat("Price"), resultSet.getInt("Download"), resultSet.getInt("Discount"), resultSet.getFloat("Rate"), resultSet.getInt("Status"), resultSet.getString("Description"), resultSet.getDate("Date"), resultSet.getString("Poster"));
                list.add(g);
            }
        } catch (SQLException ex) {
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
            return list;
        }
    }

    //sap xep danh sach game theo ten
    @Override
    public List<Game> sortGameByName() {
        String sql = "SELECT * FROM [dbo].[Game] order by Name ASC";
        Connection connection = getConnection();
         PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
         ResultSet resultSet = null;
        List<Game> list = new ArrayList<>();
        try {
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {
                Game g = new Game(resultSet.getInt("GameID"), resultSet.getString("Name"),
                        resultSet.getFloat("Price"), resultSet.getInt("Download"),
                        resultSet.getInt("Discount"), resultSet.getFloat("Rate"),
                        resultSet.getInt("Status"), resultSet.getString("Description"),
                        resultSet.getDate("Date"), resultSet.getString("Poster"));
                list.add(g);
            }
        } catch (SQLException e) {
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
            return list;
        }
    }

    //sap xep danh sach game theo gia tien
    @Override
    public List<Game> sortGameByPrice() {
        String sql = "SELECT * FROM [dbo].[Game] order by Price ASC";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        List<Game> list = new ArrayList<>();
        try {
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {
                Game g = new Game(resultSet.getInt("GameID"), resultSet.getString("Name"),
                        resultSet.getFloat("Price"), resultSet.getInt("Download"),
                        resultSet.getInt("Discount"), resultSet.getFloat("Rate"),
                        resultSet.getInt("Status"), resultSet.getString("Description"),
                        resultSet.getDate("Date"), resultSet.getString("Poster"));
                list.add(g);
            }
        } catch (SQLException e) {
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
            return list;
        }
    }

    //lay lich su mua game cua user dua theo id
    @Override
    public List<UserGameBuy> getUserGameBuybyId(int userid) {
        UserDAO usAO = new UserDAO();
        GameDAO gAO = new GameDAO();
        List<UserGameBuy> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[User-Game-Buy] where UserID =?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet =null;
        try {
            preparedStatement.setInt(1, userid);
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {
                User u = usAO.findUserByID(resultSet.getInt("UserID"));
                Game g = gAO.getGameById(resultSet.getInt("GameID"));

                UserGameBuy ug = new UserGameBuy(u, g, resultSet.getDate("Date"));
                list.add(ug);
            }

        } catch (SQLException e) {
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
            return list;
        }
    }

    //lay tat ca giao dich cua user
    @Override
    public List<UserGameBuy> getUserGameBuy() {
        UserDAO usAO = new UserDAO();
        List<UserGameBuy> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[User-Game-Buy]";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {
                User u = usAO.findUserByID(resultSet.getInt("UserID"));
                Game g = getGameById(resultSet.getInt("GameID"));

                UserGameBuy ug = new UserGameBuy(u, g, resultSet.getDate("Date"));
                list.add(ug);
            }
        } catch (SQLException e) {
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
            return list;
        }
    }

    //lay game co giam gia
    @Override
    public List<Game> getDeals() {
        List<Game> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Game] where "
                + "[Discount] != 0";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {
                Game g = new Game(resultSet.getInt("GameID"), resultSet.getString("Name"),
                        resultSet.getFloat("Price"), resultSet.getInt("Download"),
                        resultSet.getInt("Discount"), resultSet.getFloat("Rate"),
                        resultSet.getInt("Status"), resultSet.getString("Description"),
                        resultSet.getDate("Date"), resultSet.getString("Poster"));
                list.add(g);
            }
        } catch (SQLException e) {
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
            return list;
        }
    }
        //lay game co giam gia
    @Override
    public List<Game> get10Deals() {
        List<Game> list = new ArrayList<>();
        String sql = "SELECT TOP 10 * FROM [dbo].[Game] where "
                + "[Discount] != 0";
        Connection connection = getConnection();
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
            try {
                connection.close();
            } catch (SQLException e) {

            }
            return list;
        }
    }

    //Insert +1 download when a game is bought
    @Override
    public void insertDownloadToGame(Game game) {
        String sql = "Update [Game] set Download = ? where GameID = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try {
            preparedStatement.setInt(1, game.getDownload());
            preparedStatement.setInt(2, game.getGameID());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    public static void main(String[] args) {
        GameDAO gdd = new GameDAO();

        List<Game> list = gdd.get10NewRelease();
        for (Game g : list) {
            System.out.println(g.getDate());
        }
        System.out.println(list.size());
    }

    @Override
    public int getLikesOrDislikes(Game game, int voteType) {
        String sql = "Select count(GameID) From [User-Game-rate] "
                + "where GameID = ? and Rate = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            preparedStatement.setInt(1, game.getGameID());
            preparedStatement.setInt(2, voteType);
            resultSet = getResultSet(preparedStatement);
            if (resultSet.next()) {
                return resultSet.getInt(1);
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
        return -1;
    }

    @Override
    public int getUserVoteOfAGame(User user, Game game) {
        String sql = "Select Rate from [SWP].[dbo].[User-Game-Rate] "
                + " where UserID =? and GameID =?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            preparedStatement.setInt(1, user.getUserID());
            preparedStatement.setInt(2, game.getGameID());
            resultSet = getResultSet(preparedStatement);
            if (resultSet.next()) {
                return resultSet.getInt(1);
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
        return -1;
    }

    @Override
    public Game get(int GameID) {
        String sql = "SELECT * FROM [dbo].[Game] where GameID = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            preparedStatement.setInt(1, GameID);
            resultSet = getResultSet(preparedStatement);
            if (resultSet.next()) {
                //(int GameID, String Name, float Price, int Download, int Discount, float Rate, int Status, String Description, Date Date)
                Game g = new Game(resultSet.getInt("GameID"), resultSet.getString("Name"), resultSet.getFloat("Price"), resultSet.getInt("Download"), resultSet.getInt("Discount"), resultSet.getFloat("Rate"), resultSet.getInt("Status"), resultSet.getString("Description"), resultSet.getDate("Date"), resultSet.getString("Poster"));
                return g;
            }
        } catch (SQLException e) {
            return null;
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
    public void deleteGameByID(int id){
        String sql = "Delete from [Game] where GameID = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try{
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
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
    public List<Game> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Game t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Game t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Game t) {
        String sql = "Delete from [Game] where GameID = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try{
            preparedStatement.setInt(1, t.getGameID());
            preparedStatement.executeUpdate();
        }catch(SQLException e){
        }finally{
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    

}
