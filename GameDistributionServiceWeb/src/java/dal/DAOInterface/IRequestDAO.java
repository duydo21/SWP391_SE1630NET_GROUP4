/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dal.DAOInterface;

import model.Request;

/**
 *
 * @author ACER
 */
public interface IRequestDAO extends IDAO<Request>{
    Request get(int RequestID);
}
