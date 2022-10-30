/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dal.DAOInterface;

import model.Game;
import model.User;
import model.UserGameBuy;

/**
 *
 * @author ACER
 */
public interface IUserGameBuyDAO extends IDAO<UserGameBuy>{
    UserGameBuy isGameIDBoughtByUserID(int userID, int gameID);
    void addBuyGame(User u, Game g);

}
