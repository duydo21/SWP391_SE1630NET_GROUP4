/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.categoryDAO;
import dal.gameDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Game;

/**
 *
 * @author Strongest
 */
@WebServlet(name = "GamesServlet", urlPatterns = {"/games"})
public class GamesServlet extends HttpServlet {

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
            out.println("<title>Servlet GamesServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GamesServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    gameDAO gd = new gameDAO();
    List<Game> list = gd.getGame();
    categoryDAO cd = new categoryDAO();
    List<Category> clist = cd.getCategory();

    private boolean ischeck(int d, int[] id) {
        if (id == null) {
            return false;
        } else {
            for (int i = 0; i < id.length; i++) {
                if (id[i] == d) {
                    return true;
                }
            }
            return false;
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
        
        String price = request.getParameter("Price");
        String name = request.getParameter("Name");
        list = gd.getGame();
        if(price != null || name != null){
            
        }
        
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
        request.setAttribute("getgames", plist);
        request.setAttribute("cate", clist);
        request.setAttribute("link", "games");
        request.setAttribute("text", "All Games");
        request.getRequestDispatcher("games.jsp").forward(request, response);
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
        String price = request.getParameter("Price");
        String name = request.getParameter("Name");
        if (price == null && name == null) {
            list = gd.getGame();
        } else if (price == "1") {
            list = gd.sortGameByPrice();
        }
        request.getRequestDispatcher("games.jsp").forward(request, response);
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
