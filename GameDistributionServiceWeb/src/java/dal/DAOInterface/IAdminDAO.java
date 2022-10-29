/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dal.DAOInterface;

import java.util.List;
import model.Account;
import model.Admin;
import model.UserGameReport;

/**
 *
 * @author ACER
 */
public interface IAdminDAO extends IDAO<Admin>{
    Admin get(int AdminID);
    List<UserGameReport> getReport();
    Account checkAccountExist(String username);
    Admin findAdminByName(String Username);

}
