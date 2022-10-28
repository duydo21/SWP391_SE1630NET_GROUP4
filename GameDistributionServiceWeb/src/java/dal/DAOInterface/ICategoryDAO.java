/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dal.DAOInterface;

import java.util.List;
import model.Category;

/**
 *
 * @author ACER
 */
public interface ICategoryDAO extends IDAO<Category> {

    Category get(int CategoryID);

    Category getCategoryByID(int id);

    List<Category> getCategory();

    List<Category> getCategoryOfA_Game(int gameID);
}
