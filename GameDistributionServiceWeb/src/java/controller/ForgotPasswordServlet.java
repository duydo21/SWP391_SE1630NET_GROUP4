/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Util.ForgotPassUtils;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;
import model.Email;
import model.User;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "ForgotPasswordServlet", urlPatterns = {"/forgotpass"})
public class ForgotPasswordServlet extends HttpServlet {

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
            out.println("<title>Servlet ForgotPasswordServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ForgotPasswordServlet at " + request.getContextPath() + "</h1>");
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
        //vào trang ForgotPassword.jsp
        request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
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

            String name = request.getParameter("user").trim();
            String email = request.getParameter("email").trim();
            //method findUserByNameAndEmail gọi vào User
            UserDAO u = new UserDAO();
            Account account = u.findAccountByName(name);
            User user = u.findUserByNameAndEmail(name, email);
            //khi usernaem hoac email ko dung
            if (user == null) {
                request.setAttribute("msr", "Username or email are incorrect");
            } else {
                //tạo tin nhẵn email
                Email email1 = new Email();
                email1.setFrom("nhochoanganh2211@gmail.com");
                email1.setFromPassword("ukeriudgmvnpssno");
                email1.setTo(email);
                email1.setSubject("Forgot Password Funtion");

                StringBuilder sb = new StringBuilder();
                sb.append("Dear ").append(name).append("<br>");
                sb.append("You are used the forgot password funtion. <br>");
                sb.append("Your password is <b>").append(account.getPassword()).append("<br>");
                sb.append("Regards<br>");
                sb.append("Administrator");

                email1.setContent(sb.toString());
                ForgotPassUtils.send(email1);
                
                //thông báo gửi email thành công
                request.setAttribute("msr", "Email sent to the email Address." + "Please check and get your password");

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
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
