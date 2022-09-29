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
import model.Game;

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
                Game g = new Game(rs.getInt("GameID"), rs.getString("Name"), rs.getFloat("Price"), rs.getString("PublishedBy"),rs.getString("Developer"), rs.getInt("Download"), rs.getFloat("Rate"), rs.getInt("Status"), rs.getString("Description"), rs.getDate("Date"));
                list.add(g);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
