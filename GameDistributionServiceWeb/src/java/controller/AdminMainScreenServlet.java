/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAOInterface.IGameDAO;
import dal.GameDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.util.List;
import model.Game;

/**
 *
 * @author Strongest
 */
@WebServlet(name = "AdminMainScreenServlet", urlPatterns = {"/amainscreen"})
public class AdminMainScreenServlet extends HttpServlet {

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
            out.println("<title>Servlet AdminMainScreenServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminMainScreenServlet at " + request.getContextPath() + "</h1>");
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
        IGameDAO gd = new GameDAO();
        List<Game> list = gd.getGame();

        //dem so luong download
        BigInteger total = BigInteger.valueOf(0);
        for (Game g : list) {
            total = total.add(BigInteger.valueOf(g.getDownload()));
        }
        request.setAttribute("total", total);

        //phan trang
        int size = list.size();
        int page, numpage = 10;
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
        List<Game> plist = gd.getGameByPage(list, start, end);
        request.setAttribute("size", size);
        request.setAttribute("page", page);
        request.setAttribute("num", num);

        List<Game> best = gd.get10BestSeller();
        List<Game> newgame = gd.get10NewRelease();
        List<Game> deals = gd.get10Deals();
        List<Game> free = gd.get10FreeGames();
        request.setAttribute("tenbest", best);
        request.setAttribute("tennewgame", newgame);
        request.setAttribute("tendeals", deals);
        request.setAttribute("tenfree", free);
       
        List<Game> glist = gd.getGame();
        request.setAttribute("gamelist", glist);

        request.setAttribute("games", plist);
        request.getRequestDispatcher("AdminMainScreen.jsp").forward(request, response);
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
