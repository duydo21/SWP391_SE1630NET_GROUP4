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
    public void createNotification(String context, int type);
    public List<Notification> getAllNotiOfAnUser(int UserID);
    public List<Notification> sort(List<Notification> list, String sort);
    public List<Notification> filter(List<Notification> list, String filter);
}
