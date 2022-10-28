/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAOInterface.IUserDAO;
import dal.PaymentDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Payment;
import model.User;

/**
 *
 * @author ACER
 */
@WebServlet(name = "PaymentServlet", urlPatterns = {"/payment"})
public class PaymentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PaymentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PaymentServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Payment.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method_raw = "";
        int method=0;
        String amount_raw = "";
        String type_raw = "";
        int type=-1;
        try {
            IUserDAO userDao = new UserDAO();
            HttpSession session = request.getSession();
            //lấy session của user
            Account account = (Account) session.getAttribute("acc");
            User user = userDao.findUserByName(account.getUsername());

            //lấy parameter type of payment
            type_raw = request.getParameter("t");
            type = Integer.parseInt(type_raw);
            //lấy parameter payment method
            method_raw = request.getParameter("meth");
            method = Integer.parseInt(method_raw);
            //lấy parameter amount of money
            amount_raw = request.getParameter("amount").trim();
            float amount = Float.parseFloat(amount_raw);
            
            Payment payment = new Payment();
            payment.setUserID(user);
            payment.setPaymentMethod(Integer.parseInt(method_raw));
            PaymentDAO paymentDAO = new PaymentDAO();
            //trường hợp amount of money < 0
            if (amount < 0) {
                throw new NumberFormatException();
            }
            //trường hợp user chọn rút tiền
            if (type_raw.equals("0")) {
                //trường hợp user rút tiền > tiền trong tài khoản user 
                if (amount > user.getAccountBalance()) {
                    request.setAttribute("method", method);
                    request.setAttribute("amount", amount_raw);
                    request.setAttribute("type", type);
                    request.setAttribute("msf", "Please input money from 0 to " + user.getAccountBalance() + "!!");
                } else {
                    user.setAccountBalance(user.getAccountBalance() - amount);
                    payment.setMoney(-amount);
                    paymentDAO.insertPayment(payment);
                    request.setAttribute("mss", "Successful!!");
                }
                //trường hợp user choose to purchase money for account
            } else {
                user.setAccountBalance(user.getAccountBalance() + amount);
                payment.setMoney(amount);
                paymentDAO.insertPayment(payment);
                request.setAttribute("mss", "Successful!!");
            }

            userDao.manageAccBalance(user);
            session.setAttribute("userlogin", user);
        } catch (NumberFormatException e) {
            request.setAttribute("method", method);
            request.setAttribute("amount", amount_raw);
            request.setAttribute("type", type);
            request.setAttribute("msf", "Invalid money!!");
        }
        request.getRequestDispatcher("Payment.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
