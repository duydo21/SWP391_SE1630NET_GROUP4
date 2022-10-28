/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AdminDAO;
import dal.DAOInterface.IAdminDAO;
import dal.DAOInterface.IUserDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Admin;
import model.User;

/**
 *
 * @author ACER
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        //vào trang login
        request.getRequestDispatcher("Login.jsp").forward(request, response);
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
        String user = request.getParameter("user").trim();
        String pass = request.getParameter("pass");
        IUserDAO ud = new UserDAO();
        IAdminDAO ad = new AdminDAO();
        Account a = null;
        //kiểm tra Đã đăng nhập 
        a = ud.checkLogin(user, pass);
        
        if (a == null) {
            //Khi tên đăng nhập không đúng với trong Account 
            request.setAttribute("ms", "username or password invalid!!! ");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else {
            //trường hợp User là Admin
            if (a.isType() == false) {
                //tạo session 
                HttpSession session = request.getSession();
                //tìm tên người dùng trong User trùng với Account
                Admin adm = null;
                adm = ad.findAdminByName(a.getUsername());

                //tao cookie cho người dùng đăng nhập
                Cookie cu = new Cookie("userC", user);
                Cookie cp = new Cookie("passC", pass);
                cu.setMaxAge(60 * 60);
                cp.setMaxAge(60 * 60);
                response.addCookie(cu);
                response.addCookie(cp);

                //set atribute
                session.setAttribute("adminlogin", adm);
                session.setAttribute("acc", a);
                response.sendRedirect("amainscreen");
            }//trường hợp User là Customer 
            if (a.isType() == true) {
                //tạo session 
                HttpSession session = request.getSession();
                User u = null;
                //tìm tên người dùng trong User trùng với Account
                u = ud.findUserByName(a.getUsername());

                //tao cookie cho người dùng đăng nhập
                Cookie cu = new Cookie("userC", user);
                Cookie cp = new Cookie("passC", pass);
                cu.setMaxAge(60 * 60);
                cp.setMaxAge(60 * 60);
                response.addCookie(cu);
                response.addCookie(cp);

                //set atribute
                session.setAttribute("userlogin", u);
                session.setAttribute("acc", a);
                response.sendRedirect("mainscreen");
            }
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
