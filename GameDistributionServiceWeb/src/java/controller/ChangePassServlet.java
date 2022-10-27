/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;
import model.User;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "ChangePassServlet", urlPatterns = {"/changepass"})
public class ChangePassServlet extends HttpServlet {

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
            out.println("<title>Servlet ChangePassServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangePassServlet at " + request.getContextPath() + "</h1>");
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

        request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
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
        //Gọi mang cookie getValue truyền vào 2 String cpass và cuser 
        Cookie[] cookies = request.getCookies();
        String cpass = "";
        String cuser = "";        
        for (Cookie cookie : cookies) {
            if (cookie.getName().contains("userC")) {
                cuser = cookie.getValue();
            }
            if (cookie.getName().contains("passC")) {
                cpass = cookie.getValue();
            }
        };

        String oldpass = request.getParameter("oldpass");
        String pass = request.getParameter("pass");
        String repass = request.getParameter("repass");
        UserDAO ud = new UserDAO();
        //khi nhập old pass không đúng
        if (!oldpass.equals(cpass)) {
            request.setAttribute("msr", "Wrong Old password  ");
            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
        } 
        //khi không nhập pass
        else if (pass == null || pass.equals("") || repass == null || repass.equals("")) {
            request.setAttribute("msr", "Please enter password!!! ");
            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
        }
        //khi nhập new pass không trùng với repass
        else if (!pass.equals(repass)) {
            request.setAttribute("msr", "Confirm password does not match with New password!!! ");
            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
        } else {
            //cập nhật lại cookie
            Cookie cp = new Cookie("passC", pass);
            cp.setMaxAge(60 * 60);
            response.addCookie(cp);
            
            //truyền dũ liêu vào Account rồi gọi Mehtod changePassUser 
            Account cha = new Account(cuser, pass);
            User u = new User();
            ud.changePassUser(cha);
            response.sendRedirect("mainscreen");
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
