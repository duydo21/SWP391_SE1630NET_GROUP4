/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.UserGameBuyDAO;
import dal.CategoryDAO;
import dal.DAOInterface.ICategoryDAO;
import dal.DAOInterface.IGameDAO;
import dal.DAOInterface.IUserDAO;
import dal.DAOInterface.IUserGameBuyDAO;
import dal.DAOInterface.IUserGameCommentDAO;
import dal.GameDAO;
import dal.UserDAO;
import dal.UserGameCommentDAO;
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
import model.Account;
import model.Category;
import model.Game;
import model.Media;
import model.User;

/**
 *
 * @author ACER
 */
@WebServlet(name = "GameDetailsServlet", urlPatterns = {"/gameDetails"})
public class GameDetailsServlet extends HttpServlet {

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
            out.println("<title>Servlet GameDetailsServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GameDetailsServlet at " + request.getContextPath() + "</h1>");
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
        IGameDAO gameDao = new GameDAO();
        ICategoryDAO cat_DAO = new CategoryDAO();
        IUserGameBuyDAO ugb_Dao = new UserGameBuyDAO();
        IUserDAO u_Dao = new UserDAO();
        IUserGameCommentDAO userGameCommentDAO = new UserGameCommentDAO();
        HttpSession session = request.getSession();

        String gameID_raw = request.getParameter("GameID");
        int gameID = Integer.parseInt(gameID_raw);
        Account account = (Account) session.getAttribute("acc");
        User user = (User) session.getAttribute("userlogin");

        //get game info
        Game game = gameDao.getGameById(gameID);

        if (game.getDescription().length() > 300) {
            game.setDescription(game.getDescription().substring(0, 295).concat("..."));
        }
        //get game media
        List<Media> gameMedias = new ArrayList<>();
        gameMedias = gameDao.getGameMediaByGameID(gameID);
        //get game rate
        float gameRate = gameDao.getGameRateByID(gameID);
        game.setRate(gameRate);
        //get amount of like votes
        int likes = gameDao.getLikesOrDislikes(game, 1);
        //get amount of dislike votes
        int dislikes = gameDao.getLikesOrDislikes(game, 0);
        //get amount of votes
        int votes = likes + dislikes;
        //get user vote
        int userVote = -1;
        if (user != null) {
            userVote = gameDao.getUserVoteOfAGame(user, game);
        }
        //get game comment
        boolean isCmt = false;
        if (user != null) {
            try {
                if(userGameCommentDAO.getUserCommentOfAGame(user.getUserID(), game.getGameID())!=null){
                    isCmt = true;
                }
            } catch (NullPointerException e) {
            }
        }

        //get recommend game list
        List<Game> gameList_full = new ArrayList<>();
        List<Game> gameList = new ArrayList<>();
        List<Category> cateList = cat_DAO.getCategoryOfA_Game(gameID);
        //get all categories of current game
        for (Category cat : cateList) {
            gameList_full.addAll(gameDao.getRecomendByCategory(cat));
        }
        //remove current game from list recommended games
        for (int i = 0; i < gameList_full.size(); i++) {
            if (gameList_full.get(i).getGameID() == gameID) {
                gameList_full.remove(gameList_full.get(i));
                i--;
            }
        }
        //remove duplicated games
        for (int i = 0; i < gameList_full.size(); i++) {
            for (int j = i + 1; j < gameList_full.size(); j++) {
                if (gameList_full.get(i).getGameID() == gameList_full.get(j).getGameID()) {
                    gameList_full.remove(j);
                    j--;
                }
            }
        }
        //slect <= 4 games of the recommended game list
        for (int i = 0; i < gameList_full.size(); i++) {
            gameList.add(gameList_full.get(i));
            if (i == 3) {
                break;
            }
        }
        //get developer
//        List<User> devList = new ArrayList<>();
        //get bool isBought
        boolean isBought = false;
        if (user != null) {
            if (ugb_Dao.isGameIDBoughtByUserID(user.getUserID(), gameID) != null) {
                isBought = true;
            }
        }

        //send info to jsp page
        request.setAttribute("userVote", userVote);
        request.setAttribute("likes", likes);
        request.setAttribute("dislikes", dislikes);
        request.setAttribute("votes", votes);
        request.setAttribute("game", game);
        request.setAttribute("gameMedias", gameMedias);
        request.setAttribute("gameList", gameList);
        request.setAttribute("catList", cateList);
        request.setAttribute("isBought", isBought);
        request.setAttribute("isCmt", isCmt);
        request.setAttribute("GameID", gameID_raw);
//        request.setAttribute("devList", devList);
        request.getRequestDispatcher("GameDetails.jsp").forward(request, response);
        gameList_full.clear();
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

//    public static void main(String[] args) {
//        IGameDAO gameDao = new GameDAO();
//        List<UserGameComment> cmtList = new ArrayList<>();
//        cmtList = gameDao.getGameCommentByGameID(1);
//        
//        List<UserGameRate> rateListForCmtSection = new ArrayList<>();
//        for(UserGameComment cmt : cmtList){
//            rateListForCmtSection.add(new UserGameRate( cmt.getUserID(), 
//                    cmt.getGameID(),
//                    gameDao.getUserVoteOfAGame(cmt.getUserID(), cmt.getGameID()
//                    )));
//        }
//        
//        for(UserGameRate a : rateListForCmtSection){
//            System.out.println(a.getUserID().getUserID() + "-"+a.getRate());
//        }
//    }
}
