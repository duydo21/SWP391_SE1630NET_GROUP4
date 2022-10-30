/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dal.DAOInterface;

import model.Game;
import model.User;
import model.UserGameRate;

/**
 *
 * @author ACER
 */
public interface IUserGameRateDAO extends IDAO<UserGameRate>{
    UserGameRate getUserRateOfGame(User user, Game game);

}
