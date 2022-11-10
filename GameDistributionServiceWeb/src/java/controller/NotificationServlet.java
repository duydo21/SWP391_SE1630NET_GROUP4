/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAOInterface.INotificationDAO;
import dal.NotificationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Notification;
import model.User;

/**
 *
 * @author ACER
 */
@WebServlet(name = "NotificationServlet", urlPatterns = {"/notification"})
public class NotificationServlet extends HttpServlet {

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
            out.println("<title>Servlet NotificationServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NotificationServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        INotificationDAO notiDao = new NotificationDAO();
        String filter = "0";
        String sort = "0";
        //get user
        User user = (User) session.getAttribute("userlogin");
        if (user == null) {
            request.getRequestDispatcher("login").forward(request, response);
        }
        //get noti list of user
        List<Notification> notiList = notiDao.getAllNotiOfAnUser(user.getUserID());
        //forward to jsp
        request.setAttribute("sort", sort);
        request.setAttribute("filter", filter);
        request.setAttribute("notiList", notiList);
        request.getRequestDispatcher("Notification.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        INotificationDAO notiDao = new NotificationDAO();
        String filter = "0";
        String sort = "0";
        //get user
        User user = (User) session.getAttribute("userlogin");
        if (user == null) {
            response.sendRedirect("login");
        }
        //get noti list of user
        List<Notification> notiList = notiDao.getAllNotiOfAnUser(user.getUserID());
        //filter
        filter = request.getParameter("filter");
        notiList = notiDao.filter(notiList, filter);
        //sort
        sort = request.getParameter("sort");
        notiList = notiDao.sort(notiList, sort);
        //forward to jsp
        request.setAttribute("sort", sort);
        request.setAttribute("filter", filter);
        request.setAttribute("notiList", notiList);
        request.getRequestDispatcher("Notification.jsp").forward(request, response);
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
