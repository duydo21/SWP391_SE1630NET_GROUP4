/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DAOInterface.IUserDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.User;

/**
 *
 * @author Strongest
 */
public class UserDAO extends DBContext implements IUserDAO{

    //tạo thêm Account
    public void createAccount(Account a) {
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "           ([Username]\n"
                + "           ,[Password]\n"
                + "           ,[Type])\n"
                + "     VALUES(?,?,?)";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try {
            preparedStatement.setString(1, a.getUsername());
            preparedStatement.setString(2, a.getPassword());
            preparedStatement.setBoolean(3, true);
            preparedStatement.executeUpdate();
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

    //kiểm tra account có tồn tại
    public Account checkAccountExist(String username) {
        String sql = "SELECT [Username]\n"
                + "      ,[Password]\n"
                + "      ,[Type]\n"
                + "  FROM [dbo].[Account] where [Username] = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            preparedStatement.setString(1, username);
            resultSet = getResultSet(preparedStatement);
            if (resultSet.next()) {
                Account a = new Account(resultSet.getString("Username"), resultSet.getString("Password"), true);
                return a;
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
        return null;
    }

    //kiểm tra account qua username và password
    public Account checkLogin(String username, String password) {
        String sql = "SELECT [Username]\n"
                + "      ,[Password]\n"
                + "      ,[Type]\n"
                + "  FROM [dbo].[Account] where [Username] = ? AND [Password] = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = getResultSet(preparedStatement);
            if (resultSet.next()) {
                Account a = new Account(resultSet.getString("Username"), resultSet.getString("Password"), resultSet.getBoolean("Type"));
                return a;
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
        return null;
    }

    //tạo User
    public void createUser(String name) {
        String sql = "INSERT INTO [dbo].[User]\n"
                + "           ([Name]\n"
                + "           ,[Nickname]\n"
                + "           ,[Country]\n"
                + "           ,[AccountBalance]\n"
                + "           ,[Email]\n"
                + "           ,[Avatar]\n"
                + "           ,[IsDev])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, "No information");
            preparedStatement.setString(3, "No information");
            preparedStatement.setFloat(4, 0);
            preparedStatement.setString(5, "No information");
            preparedStatement.setString(6, "image/Default Avatar.jpg");
            preparedStatement.setBoolean(7, false);
            preparedStatement.executeUpdate();
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

    //Tìm User qua Name
    public User findUserByName(String Username) {
        String sql = "SELECT * FROM [dbo].[User] where [Name] = ?";
        User u = new User();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            preparedStatement.setString(1, Username);
            resultSet = getResultSet(preparedStatement);
            if (resultSet.next()) {
                Account a = checkAccountExist(resultSet.getString("Name"));
                u.setUserID(resultSet.getInt("UserID"));
                u.setUsername(a);
                u.setNickname(resultSet.getString("Nickname"));
                u.setCountry(resultSet.getString("Country"));
                u.setAccountBalance(resultSet.getFloat("AccountBalance"));
                u.setEmail(resultSet.getString("Email"));
                u.setAvatar(resultSet.getString("Avatar"));
                u.setIsDev(resultSet.getBoolean("IsDev"));
                return u;
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
        return null;
    }

    //Tìm User qua UserID
    public User findUserByID(int id) {
        String sql = "SELECT * FROM [dbo].[User] where [UserID] = ?";
        User u = new User();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            preparedStatement.setInt(1, id);
            resultSet = getResultSet(preparedStatement);
            if (resultSet.next()) {
                Account a = checkAccountExist(resultSet.getString("Name"));
                u.setUserID(resultSet.getInt("UserID"));
                u.setUsername(a);
                u.setNickname(resultSet.getString("Nickname"));
                u.setCountry(resultSet.getString("Country"));
                u.setAccountBalance(resultSet.getFloat("AccountBalance"));
                u.setEmail(resultSet.getString("Email"));
                u.setAvatar(resultSet.getString("Avatar"));
                u.setIsDev(resultSet.getBoolean("IsDev"));
                u.setIsPrivate(resultSet.getBoolean("IsPrivate"));
                u.setDecription(resultSet.getString("Description"));
            }
            return u;
        } catch (SQLException e) {
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

    //Cập nhật thông tin của User
    public int updateProfileUser(User u) {

        int count = 0;
        String sql = "update [User] set  "
                + "Nickname=?,  Country =?,  [Email] =?,"
                + "Avatar =?, [Description] = ?, IsPrivate = ?  "
                + "where UserID=?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try {
            preparedStatement.setString(1, u.getNickname());
            preparedStatement.setString(2, u.getCountry());
            preparedStatement.setString(3, u.getEmail());
            preparedStatement.setString(4, u.getAvatar());
            preparedStatement.setString(5, u.getDecription());
            preparedStatement.setBoolean(6, u.isIsPrivate());
            preparedStatement.setInt(7, u.getUserID());
            count = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
        }
        return count;
    }

    //Thay đổi password của Account
    public int changePassUser(Account a) {
        int count = 0;
        String sql = "update [Account] set Username = ? , "
                + "[Password] = ? where Username=?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try {
            preparedStatement.setString(1, a.getUsername());
            preparedStatement.setString(2, a.getPassword());
            preparedStatement.setString(3, a.getUsername());
            count = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
        }
        return count;
    }

    //cập nhật User là Dev
    public void updateIsDevUser(User u) {
        int count = 0;
        String sql = "update [User] set  "
                + "IsDev = ?  "
                + "where UserID=?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);
            preparedStatement.setInt(2, u.getUserID());
            count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
        }
//        return count;
    }

    public static void main(String[] args) {

        User u = new UserDAO().findUserByID(4);

        System.out.println(u);

    }

    //Số tiền hiện có của User
    public void manageAccBalance(User u) {
        String sql = "UPDATE [dbo].[User]\n"
                + "   SET [AccountBalance] = ?\n"
                + " WHERE name= ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try {
            preparedStatement.setFloat(1, u.getAccountBalance());
            preparedStatement.setString(2, u.getUsername().getUsername());
            preparedStatement.executeUpdate();
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
    public List<User> getAll() {
        AccountDAO accountDAO = new AccountDAO();
        List<User> list = new ArrayList<>();

        String sql = "SELECT * FROM [User]";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            resultSet = getResultSet(preparedStatement);
            while (resultSet.next()) {
                User a = new User(resultSet.getInt("UserID"),
                accountDAO.get(resultSet.getString("Name")),
                resultSet.getString("NickName"),resultSet.getString("Country"),
                resultSet.getFloat("AccountBalance"),resultSet.getString("Email"),
                resultSet.getString("Avatar"),resultSet.getBoolean("IsDev"),
                resultSet.getDate("Date"),resultSet.getString("Description"),resultSet.getBoolean("IsPrivate"));
                list.add(a);
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

    @Override
    public void insert(User t) {
        String sql = "INSERT INTO [dbo].[User]\n"
                + "           ([Name]\n"
                + "           ,[Nickname]\n"
                + "           ,[Country]\n"
                + "           ,[AccountBalance]\n"
                + "           ,[Email]\n"
                + "           ,[Avatar]\n"
                + "           ,[IsDev])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try {
            preparedStatement.setString(1, t.getUsername().getUsername());
            preparedStatement.setString(2, t.getNickname());
            preparedStatement.setString(3, t.getCountry());
            preparedStatement.setFloat(4, 0);
            preparedStatement.setString(5, t.getEmail());
            preparedStatement.setString(6, "image/Default Avatar.jpg");
            preparedStatement.setBoolean(7, false);
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
    public void update(User t) {
        String sql = "Update [dbo].[User] set NickName = ? and Country = ? and"
                + "Email = ? and Avatar =? and Description = ? where UserID = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try {
            preparedStatement.setString(1, t.getNickname());
            preparedStatement.setString(2, t.getCountry());
            preparedStatement.setString(3, t.getEmail());
            preparedStatement.setString(4, t.getAvatar());
            preparedStatement.setString(5, t.getDecription());
            preparedStatement.setString(6, t.getUsername().getUsername());
            preparedStatement.executeUpdate();
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
    public void delete(User t) {
        String sql = "Delete from [User] where UserID = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try{
            preparedStatement.setInt(1, t.getUserID());
            preparedStatement.executeQuery();
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
    public User get(int UserID) {
        AccountDAO accountDAO = new AccountDAO();
        String sql = "Select * from [User] where UserID = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try{
            preparedStatement.setInt(1, UserID);
            resultSet = getResultSet(preparedStatement);
            if(resultSet.next()){
                User a = new User(resultSet.getInt("UserID"), 
                        accountDAO.get(resultSet.getString("Name")), 
                        resultSet.getString("NickName"), resultSet.getString("Country"), 
                        resultSet.getFloat("AccountBalance"), resultSet.getString("Email"), 
                        resultSet.getString("Avatar"), resultSet.getBoolean("IsDev"), 
                        resultSet.getDate("Date"), resultSet.getString("Description"), 
                        resultSet.getBoolean("IsPrivate"));
                return a;
            }
        }catch(SQLException e){
        }finally{
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
            return null;
        }
    }

}
