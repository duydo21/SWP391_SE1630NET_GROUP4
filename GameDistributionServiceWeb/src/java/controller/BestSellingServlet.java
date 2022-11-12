/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CategoryDAO;
import dal.DAOInterface.ICategoryDAO;
import dal.DAOInterface.IGameCategoryDAO;
import dal.DAOInterface.IGameDAO;
import dal.GameCategoryDAO;
import dal.GameDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Category;
import model.Game;
import model.GameCategory;

/**
 *
 * @author Strongest
 */
@WebServlet(name = "BestSellingServlet", urlPatterns = {"/best"})
public class BestSellingServlet extends HttpServlet {

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
            out.println("<title>Servlet BestSellingServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BestSellingServlet at " + request.getContextPath() + "</h1>");
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
    IGameDAO gd = new GameDAO();
    List<Game> list = gd.getBestSeller();
    ICategoryDAO cd = new CategoryDAO();
    List<Category> clist = cd.getCategory();
    IGameCategoryDAO gc = new GameCategoryDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("action", "best");
        String priceMin = request.getParameter("first");
        String priceMax = request.getParameter("second");
        String filter = "";
        float min = Float.parseFloat(priceMin);
        float max = Float.parseFloat(priceMax);

        filter = filter + "first=" + priceMin + "&second=" + priceMax;

        if (min == 0 && max == 0) {
            list = gd.getGame();
        } else if (min != 0 && max != 0) {
            list = gd.getGameByPriceRange(list, min, max);
        }
        String radio = request.getParameter("Filter");
        if (radio == null) {

        } else if (radio.equals("1")) {
            list = gd.sortGameByPriceASC(list);
            filter = filter + "&Filter=" + radio;
        } else if (radio.equals("2")) {
            list = gd.sortGameByPriceDESC(list);
            filter = filter + "&Filter=" + radio;
        } else if (radio.equals("3")) {
            list = gd.sortGameByNameASC(list);
            filter = filter + "&Filter=" + radio;
        } else if (radio.equals("4")) {
            list = gd.sortGameByNameDESC(list);
            filter = filter + "&Filter=" + radio;
        }

        String[] category = request.getParameterValues("cate");
        if (category == null) {

        }
        if (category != null) {
            int[] searchint = new int[category.length];
            for (int i = 0; i < searchint.length; i++) {
                searchint[i] = Integer.parseInt(category[i]);
                filter = filter + "&cate=" + searchint[i];
            }
            List<GameCategory> game = gc.getGameIDbyCateID(searchint);
            list = gd.filterGameByCategory(list, game);
        }
        //phan trang
        int size = list.size();
        int page, numpage = 10;
        int num = (size % numpage == 0 ? (size / 6) : (size / 6) + 1);
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

        List<Game> glist = gd.getGame();
        request.setAttribute("gamelist", glist);

        request.setAttribute("getgames", plist);
        request.setAttribute("cate", clist);
        request.setAttribute("link", "best");
        request.setAttribute("filter", filter);
        request.setAttribute("text", "Best seller");
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
