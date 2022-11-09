/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dal.DAOInterface;

import model.GameCategory;

/**
 *
 * @author ACER
 */
public interface IGameCategoryDAO extends IDAO<GameCategory>{

    void insertGameCategory(GameCategory gc);
}
