/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dal.DAOInterface;

import java.util.List;
import model.Game;
import model.Payment;
import model.User;

/**
 *
 * @author ACER
 */
public interface IPaymentDAO extends IDAO<Payment>{
    Payment get(int PaymentID);
    void insertPayment(Payment payment);
    List<Payment> getAllTransactionHistory(User user);
    List<Payment> searchPaymentbyKey(User user, String key);
    void addPaymentBuyGame(User user, Game game);
}
