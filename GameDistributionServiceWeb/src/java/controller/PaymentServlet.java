/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.PaymentDAO;
import dal.userDAO;
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
        try {
            userDAO userDao = new userDAO();
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("acc");
            User u = userDao.findUserByName(acc.getUsername());

            String method = request.getParameter("meth");
            String amount_raw = request.getParameter("amount");
            float amount = Float.parseFloat(amount_raw);
            String type = request.getParameter("t");
            
            Payment payment = new Payment();
            payment.setUserID(u);
            payment.setPaymentMethod(Integer.parseInt(method));
            PaymentDAO paymentDAO = new PaymentDAO();
            if(amount<0){
                throw new NumberFormatException();
            }
            if(type.equals("0")){
                if(amount > u.getAccountBalance()){
                    request.setAttribute("msf", "Please input money from 0 to "+ u.getAccountBalance() + "!!");
                }else{
                    u.setAccountBalance(u.getAccountBalance()-amount);
                    payment.setMoney(-amount);
                    paymentDAO.insertPayment(payment);
                    request.setAttribute("mss", "Successful!!");
                }
            }else{
                u.setAccountBalance(u.getAccountBalance()+amount);
                payment.setMoney(amount);
                paymentDAO.insertPayment(payment);
                request.setAttribute("mss", "Successful!!");
            }
            
            userDao.manageAccBalance(u);
        } catch (NumberFormatException e) {
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
