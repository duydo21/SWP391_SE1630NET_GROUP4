/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dal.DAOInterface;

import java.util.List;
import model.Account;
import model.User;

/**
 *
 * @author ACER
 */
public interface IUserDAO extends IDAO<User> {

    User get(int UserID);

    void createAccount(Account a);

    Account checkAccountExist(String username);

    Account checkLogin(String username, String password);

    void createUser(String name);

    User findUserByName(String Username);

    User findUserByID(int id);

    int updateProfileUser(User u);

    int changePassUser(Account a);

    void updateIsDevUser(User u);

    void manageAccBalance(User u);

    List<User> getAll();
}