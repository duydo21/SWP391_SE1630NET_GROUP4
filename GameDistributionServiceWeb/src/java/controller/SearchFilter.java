/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.CategoryDAO;
import dal.DAOInterface.ICategoryDAO;
import dal.DAOInterface.IGameDAO;
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

/**
 *
 * @author Strongest
 */
@WebServlet(name="SearchFilter", urlPatterns={"/filter"})
public class SearchFilter extends HttpServlet {
   
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
            out.println("<title>Servlet SearchFilter</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchFilter at " + request.getContextPath () + "</h1>");
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
        IGameDAO gd = new GameDAO();
    List<Game> list = gd.getGame();
    ICategoryDAO cd = new CategoryDAO();
    List<Category> clist = cd.getCategory();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String priceMin = request.getParameter("first");
        String priceMax = request.getParameter("second");

        float min = Float.parseFloat(priceMin);
        float max = Float.parseFloat(priceMax);
        if (min == 0 && max == 0) {
            list = gd.getGame();
        }
        else if(min != 0 && max != 0){
            list = gd.getGameByPriceRange(list, min, max);
        }
        String radio = request.getParameter("Filter");
        if(radio == null){
            
        }
        else if (radio.equals("1")) {
            list = gd.sortGameByPriceASC(list);
        }
        else if (radio.equals("2")) {
            list = gd.sortGameByPriceDESC(list);
        }
        else if (radio.equals("3")) {
            list = gd.sortGameByNameASC(list);
        }
        else if (radio.equals("4")) {
            list = gd.sortGameByNameDESC(list);
        }
        String[] category = request.getParameterValues("cate");
        if (category == null) {
            
        }
        if (category != null) {
            int[] searchint = new int[category.length];
            for (int i = 0; i < searchint.length; i++) {
                searchint[i] = Integer.parseInt(category[i]);
            }
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

        List<Game> glist = gd.getGame();
        request.setAttribute("gamelist", glist);
        
        request.setAttribute("getgames", plist);
        request.setAttribute("cate", clist);
        request.setAttribute("link", "games");
        request.setAttribute("text", "All Games");
        request.getRequestDispatcher("games.jsp").forward(request, response);
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
