/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAOInterface.IGameDAO;
import dal.DAOInterface.IUserDAO;
import dal.GameDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Game;
import model.User;
import model.UserGameBuy;
import model.UserGameDeveloper;

/**
 *
 * @author Strongest
 */
@WebServlet(name = "AdminManageUser", urlPatterns = {"/user"})
public class AdminManageUser extends HttpServlet {

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
            out.println("<title>Servlet AdminManageUser</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminManageUser at " + request.getContextPath() + "</h1>");
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
        IUserDAO ud = new UserDAO();
        List<User> list = ud.getAll();

        //phan trang
        int size = list.size();
        int page, numpage = 20;
        int num = (size % numpage == 0 ? (size / numpage) : (size / numpage) + 1);
        String xpage = request.getParameter("page");
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        int start, end;
        start = (page - 1) * numpage;
        end = Math.min(page * numpage, size);
        List<User> plist = ud.getUserByPage(list, start, end);
        request.setAttribute("size", size);
        request.setAttribute("page", page);
        request.setAttribute("num", num);

        request.setAttribute("user", plist);

        IGameDAO gd = new GameDAO();
        //lấy list game 
        List<Game> glist = new ArrayList<>();
        glist = gd.getGame();

        List<UserGameDeveloper> ugdlist = new ArrayList<>();
        ugdlist = gd.getUserGameDeveloped();
        
        List<UserGameBuy> uglist = new ArrayList<>();
        uglist = gd.getUserGameBuy();
        //set Attribute của glist và uglist
        request.setAttribute("gamelist", glist);
        request.setAttribute("dev", ugdlist);
        request.setAttribute("buy", uglist);
        
        request.getRequestDispatcher("UsersList.jsp").forward(request, response);
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
        processRequest(request, response);
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
