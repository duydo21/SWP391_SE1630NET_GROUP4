/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dal.DAOInterface;

import java.util.List;

/**
 *
 * @author ACER
 */
public interface IDAO<T> {
    List<T> getAll();
    void insert(T t);
    void update(T t);
    void delete(T t);
}
