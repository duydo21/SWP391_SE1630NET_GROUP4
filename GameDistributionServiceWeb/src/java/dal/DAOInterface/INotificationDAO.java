/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dal.DAOInterface;

import java.util.List;
import model.Notification;

/**
 *
 * @author ACER
 */
public interface INotificationDAO extends IDAO<Notification>{
    Notification get(int NotiID);
    List<Notification> getAllNotiOfAnUser(int UserID);
    List<Notification> sort(List<Notification> list, String sort);
    List<Notification> filter(List<Notification> list, String filter);
    void createNotification(String context, int userID, int type);
}
