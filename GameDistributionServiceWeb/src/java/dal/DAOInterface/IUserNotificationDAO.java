/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dal.DAOInterface;

import model.Notification;
import model.UserNotification;

/**
 *
 * @author ACER
 */
public interface IUserNotificationDAO extends IDAO<UserNotification> {

    void adminCreateNotification(String context);

    void NotificationToUserByID(int notiID, int userID);
    
    Notification getNotificationByNotiID(int notiID);
}
