/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dal.DAOInterface;

import model.UserGameComment;

/**
 *
 * @author ACER
 */
public interface IUserGameCommentDAO extends IDAO<UserGameComment>{

    public UserGameComment getUserCommentOfAGame(int userID, int gameID);

}
