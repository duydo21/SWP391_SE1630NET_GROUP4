/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DAOInterface.IGameDAO;
import dal.DAOInterface.IUserGameBuyDAO;
import dal.DAOInterface.IUserGameCommentDAO;
import dal.GameDAO;
import dal.UserGameBuyDAO;
import dal.UserGameCommentDAO;
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
import model.UserGameComment;

/**
 *
 * @author ACER
 */
@WebServlet(name="AllCommentServlet", urlPatterns={"/allcomments"})
public class AllCommentServlet extends HttpServlet {
   
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
            out.println("<title>Servlet AllCommentServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AllCommentServlet at " + request.getContextPath () + "</h1>");
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
        IGameDAO gameDao = new GameDAO();
        IUserGameBuyDAO ugb_Dao = new UserGameBuyDAO();
        IUserGameCommentDAO userGameCommentDAO = new UserGameCommentDAO();
        HttpSession session = request.getSession();
        
        String gameID_raw = request.getParameter("GameID");
        int gameID = Integer.parseInt(gameID_raw);
        User user = (User) session.getAttribute("userlogin");
        //get game
        Game game = gameDao.getGameById(gameID);
        //get user vote
        int userVote = -1;
        if (user != null) {
            userVote = gameDao.getUserVoteOfAGame(user, game);
        }
        //get user comment
        boolean isCmt = false;
        UserGameComment comment = new UserGameComment();
        if (user != null) {
            try {
                if(userGameCommentDAO.getUserCommentOfAGame(user.getUserID(), game.getGameID())!=null){
                    comment = userGameCommentDAO.getUserCommentOfAGame(user.getUserID(), game.getGameID());
                    isCmt = true;
                }
            } catch (NullPointerException e) {
            }
        }
        //Sort
        String sort = request.getParameter("sort"); //0: recently - 1: oldest
        if(sort == null){
            sort = "0";
        }
        //Filter
        String filter = request.getParameter("filter"); //0: all - 1: posotive only - 2: negative only
        if(filter == null){
            filter = "0";
        }
        //send data to jsp
        request.setAttribute("sort", sort);
        request.setAttribute("filter", filter);
        request.setAttribute("userVote", userVote);
        request.setAttribute("game", game);
        request.setAttribute("isCmt", isCmt);
        request.setAttribute("usercomment", comment);
        request.getRequestDispatcher("AllComments.jsp").forward(request, response);
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
