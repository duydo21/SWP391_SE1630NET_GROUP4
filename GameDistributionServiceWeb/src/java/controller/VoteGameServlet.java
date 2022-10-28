/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DAOInterface.IGameDAO;
import dal.DAOInterface.IUserGameRateDAO;
import dal.GameDAO;
import dal.UserGameRateDAO;
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
import model.UserGameRate;

/**
 *
 * @author ACER
 */
@WebServlet(name="VoteGameServlet", urlPatterns={"/votegame"})
public class VoteGameServlet extends HttpServlet {
   
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
            out.println("<title>Servlet VoteGameServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VoteGameServlet at " + request.getContextPath () + "</h1>");
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
        IUserGameRateDAO userGameRateDAO = new UserGameRateDAO();
                
        //get user
        User user = (User) session.getAttribute("userlogin");
        //get game
        String gameID_raw = request.getParameter("GameID");
        int gameID = Integer.parseInt(gameID_raw);
        Game game = gameDao.getGameById(gameID);
        //get like or dislike
        String type_raw = request.getParameter("type");
        int type = Integer.parseInt(type_raw);
        //check xem user da like hoac dislike hay chua
        UserGameRate userGameRate = userGameRateDAO.getUserRateOfGame(user, game);
        if(userGameRate==null){
            userGameRate = new UserGameRate(user, game, type);
            userGameRateDAO.insert(userGameRate);
        }else{
            userGameRate.setRate(type);
            userGameRateDAO.update(userGameRate);
        }
        
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
