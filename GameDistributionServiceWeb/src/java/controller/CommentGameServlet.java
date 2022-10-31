/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Game;
import model.User;
import dal.DAOInterface.IGameDAO;
import dal.DAOInterface.IUserGameCommentDAO;
import dal.GameDAO;
import dal.UserGameCommentDAO;
import java.util.Date;
import model.UserGameComment;

/**
 *
 * @author ACER
 */
@WebServlet(name="CommentGameServlet", urlPatterns={"/commentGame"})
public class CommentGameServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CommentGameServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CommentGameServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        IGameDAO gameDao = new GameDAO();
        IUserGameCommentDAO userGameCommentDAO = new UserGameCommentDAO();
        //get user 
        User user = (User)session.getAttribute("userlogin");
        //get game
        String gameID_raw = request.getParameter("GameID");
        int gameID = Integer.parseInt(gameID_raw);
        Game game = gameDao.getGameById(gameID);
        //get comment content
        String content = request.getParameter("cmt");
        //add comment to the database
        Date todayDate = new Date();
        java.sql.Date date = new java.sql.Date(todayDate.getTime());
        UserGameComment userGameComment = new UserGameComment(user, game, content, date);
        userGameCommentDAO.insert(userGameComment);
        //return to game details
        request.setAttribute("GameID", gameID_raw);
        request.getRequestDispatcher("gameDetails").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
