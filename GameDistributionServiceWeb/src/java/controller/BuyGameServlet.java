/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.PaymentDAO;
import dal.UserGameBuyDAO;
import dal.CategoryDAO;
import dal.GameDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Game;
import model.Media;
import model.User;
import model.UserGameComment;

/**
 *
 * @author ACER
 */
@WebServlet(name = "BuyGameServlet", urlPatterns = {"/buygame"})
public class BuyGameServlet extends HttpServlet {

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
            out.println("<title>Servlet BuyGameServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BuyGameServlet at " + request.getContextPath() + "</h1>");
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
        GameDAO gameDao = new GameDAO();
        CategoryDAO cat_DAO = new CategoryDAO();
        UserGameBuyDAO ugbDao = new UserGameBuyDAO();
        UserDAO uDao = new UserDAO();
        PaymentDAO pDao = new PaymentDAO();
        //get game
        String gameID_raw = request.getParameter("GameID");
        int gameID = Integer.parseInt(gameID_raw);
        Game game = gameDao.getGameById(gameID);
        
        //get user who buy the game
        User user = (User) session.getAttribute("userlogin");
        //add record to UserGameBuy
        ugbDao.addBuyGame(user, game);
        //add record to Payment
        pDao.addPaymentBuyGame(user, game);
        //subtract user account balance
        user.setAccountBalance(user.getAccountBalance() - game.getPriceAfterDiscount());
        uDao.manageAccBalance(user);
        //insert download to the game
        game.setDownload(game.getDownload()+1);
        gameDao.insertDownloadToGame(game);
        
        //get game comment
        List<UserGameComment> cmtList = new ArrayList<>();
        cmtList = gameDao.getGameCommentByGameID(game.getGameID());
        if (game.getDescription().length() > 300) {
            game.setDescription(game.getDescription().substring(0, 295).concat("..."));
        }
        //get game media
        List<Media> gameMedias = new ArrayList<>();
        gameMedias = gameDao.getGameMediaByGameID(game.getGameID());
        //get game rate
        float gameRate = gameDao.getGameRateByID(game.getGameID());
        game.setRate(gameRate);
        //get recommend game list
        List<Game> gameList = new ArrayList<>();
        List<Category> cateList = cat_DAO.getCategoryOfA_Game(game.getGameID());
        for (int i = 0; i < 5; i++) {
            gameList.add(gameDao.getRecomendByCategory(cateList.get(0)).get(i));
        }

        for (int i = 0; i < gameList.size(); i++) {
            if (gameList.get(i).getGameID() == game.getGameID()) {
                gameList.remove(gameList.get(i));
                i--;
            }
        }

        //get developer
//        List<User> devList = new ArrayList<>();
        //get bool isBought
        boolean isBought = false;
        if (ugbDao.isGameIDBoughtByUserID(user.getUserID(), gameID) != null) {
            isBought = true;
        }

        //send info to jsp page
        request.setAttribute("game", game);
        request.setAttribute("gameComment", cmtList);
        request.setAttribute("gameMedias", gameMedias);
        request.setAttribute("gameList", gameList);
        request.setAttribute("catList", cateList);
        request.setAttribute("isBought", isBought);

        request.getRequestDispatcher("GameDetails.jsp").forward(request, response);
        gameList.clear();
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
