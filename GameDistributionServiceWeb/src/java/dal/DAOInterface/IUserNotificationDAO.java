/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dal.DAOInterface;

import java.util.List;
import model.UserNotification;

/**
 *
 * @author ACER
 */
public interface IUserNotificationDAO extends IDAO<UserNotification>{
    List<UserNotification> getAll();
}
