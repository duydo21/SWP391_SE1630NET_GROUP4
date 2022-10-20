/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
//import java.sql.Date;
import model.Game;
import model.User;
import model.UserGameBuy;

/**
 *
 * @author ACER
 */
public class UserGameBuyDAO extends DBContext{
    public UserGameBuy isGameIDBoughtByUserID(int userID, int gameID){
        GameDAO g_Dao = new GameDAO();
        UserDAO u_Dao = new UserDAO();
        String sql = "SELECT * FROM [dbo].[User-Game-Buy]"
                + "  where [GameID]=? and [UserID] =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, gameID);
            st.setInt(2, userID);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new UserGameBuy(u_Dao.findUserByID(rs.getInt(1))
                        ,g_Dao.getGameById(rs.getInt(2)),rs.getDate(3));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public void addbuyGame(User u, Game g) {
        String sql = "INSERT [dbo].[User-Game-Buy] "
                + "VALUES (?, ?,?)";
        Date todayDate = new Date();
        java.sql.Date d = new java.sql.Date(todayDate.getTime());
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, u.getUserID());
            st.setInt(2, g.getGameID());
            st.setDate(3,  d);
            st.executeQuery();
        } catch (SQLException e) {

        }
    }
    
    
}