/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAOInterface.IUserDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author Strongest
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

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
            out.println("<title>Servlet RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("Register.jsp").forward(request, response);
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
        //l???y c??c paramter b??n trang register
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String pass2 = request.getParameter("pass2");

        
        IUserDAO ud = new UserDAO();
        //Ki???m tra trong Account c?? t??i kho???n dc nh???p ch??a b???ng method checkAccountExit 
        Account a = ud.checkAccountExist(user);
        //tr?????ng h???p tr??ng Account
        if (a != null){
            request.setAttribute("msr", "this username is existed!!! ");
            request.getRequestDispatcher("Register.jsp").forward(request, response);            
        }
        //tr?????ng h???p kh??ng nh???p username
        else if (user == null || user.equals("")) {
            request.setAttribute("msr", "Please enter username!!! ");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        }
        //tr?????ng h???p kh??ng nh???p pass
        else if (pass == null || pass.equals("") || pass2 == null || pass2.equals("")) {
            request.setAttribute("msr", "Please enter password!!! ");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        }
        //tr?????ng h???p pass ko gi???ng pass2
        else if (!pass.equals(pass2)) {
            request.setAttribute("msr", "Re-enter password does not match with your password!!! ");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        } else{
            Account reg = new Account(user, pass, true);
            //g???i method createAccount cho d??? li???u v??o Account
            ud.createAccount(reg);
            //g???i method createUser cho d??? li???u v??o User
            ud.createUser(user);
            //chuy???n trang login.jsp
            response.sendRedirect("login");
        }
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
