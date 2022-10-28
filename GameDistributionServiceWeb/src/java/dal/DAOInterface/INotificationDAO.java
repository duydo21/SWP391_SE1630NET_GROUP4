/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dal.DAOInterface;

import model.Notification;

/**
 *
 * @author ACER
 */
public interface INotificationDAO extends IDAO<Notification>{
    Notification get(int NotiID);
}
