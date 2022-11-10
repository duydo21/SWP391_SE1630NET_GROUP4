/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DAOInterface.INotificationDAO;
import dal.DAOInterface.IUserDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import model.Notification;

/**
 *
 * @author ACER
 */
public class NotificationDAO extends DBContext implements INotificationDAO {

    @Override
    public List<Notification> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Notification t) {
        String sql = "INSERT [dbo].[Notification] "
                + "([Type], [Content], [Date], [UserID]) "
                + "VALUES (?, ?, ?, ?)";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try {
            java.util.Date utilDate = new Date();
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            preparedStatement.setInt(1, t.getType());
            preparedStatement.setString(2, t.getContent());
            preparedStatement.setDate(3, date);
            preparedStatement.setInt(4, t.getUserID().getUserID());
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

    @Override
    public void update(Notification t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Notification t) {
        String sql = "Delete from [Notification] where NotiID = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try {
            preparedStatement.setInt(1, t.getNotiID());
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

    @Override
    public Notification get(int NotiID) {
        String sql = "SELECT * FROM [dbo].[Notification] where NotiID = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            preparedStatement.setInt(1, NotiID);
            resultSet = getResultSet(preparedStatement);
            if (resultSet.next()) {
                Notification g = new Notification(resultSet.getInt("NotiID"),
                        resultSet.getInt("Type"), resultSet.getString("Content"),
                        resultSet.getDate("Date"));
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

    @Override
    public void createNotification(String context, int userID, int type) {
        String sql = "INSERT INTO [dbo].[Notification]\n"
                + "           ([Type]\n"
                + "           ,[Content]\n"
                + "           ,[Date]"
                + "           ,[UserID])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try {
            preparedStatement.setInt(1, type);
            preparedStatement.setString(2, context);
            preparedStatement.setDate(3, date);
            preparedStatement.setInt(4, userID);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    //get all notification of a specific user
    @Override
    public List<Notification> getAllNotiOfAnUser(int UserID) {
        IUserDAO userDao = new UserDAO();
        List<Notification> list = new ArrayList<>();
        String sql = "select * from Notification where UserID = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;

        try {
            preparedStatement.setInt(1, UserID);
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {
                Notification noti = new Notification(resultSet.getInt("NotiID"),
                        resultSet.getInt("Type"),
                        resultSet.getString("Content"),
                        resultSet.getDate("Date"),
                        userDao.findUserByID(resultSet.getInt("UserID")));
                list.add(noti);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
        }
        return list;
    }

    @Override
    public List<Notification> sort(List<Notification> list, String sort) {
        if (sort.equals("0")) {
            Collections.sort(list, (Notification o1, Notification o2) -> o1.getDate().before(o2.getDate()) ? 1 : -1);
        } else if (sort.equals("1")) {
            Collections.sort(list, (Notification o1, Notification o2) -> o1.getDate().after(o2.getDate()) ? 1 : -1);
        }
        return list;
    }

    @Override
    public List<Notification> filter(List<Notification> list, String filter) {
        switch (filter) {
            case "1":
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getType() != 1) {
                        list.remove(i);
                        i--;
                    }
                }
                break;
            case "2":
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getType() != 2) {
                        list.remove(i);
                        i--;
                    }
                }
                break;
            case "3":
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getType() != 3) {
                        list.remove(i);
                        i--;
                    }
                }
                break;
            case "4":
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getType() != 4) {
                        list.remove(i);
                        i--;
                    }
                }
                break;
            case "5":
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getType() != 5) {
                        list.remove(i);
                        i--;
                    }
                }
                break;
            case "6":
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getType() != 6) {
                        list.remove(i);
                        i--;
                    }
                }
                break;
        }
        return list;
    }
}
