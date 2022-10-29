/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dal.DAOInterface;

import java.util.List;
import model.Account;

/**
 *
 * @author ACER
 */
public interface IAccountDAO extends IDAO<Account>{

    public Account get(String string);

}
