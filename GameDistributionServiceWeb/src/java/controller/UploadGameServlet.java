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
import jakarta.servlet.http.Part;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Game;
import model.GameCategory;

/**
 *
 * @author ADMIN
 */
@MultipartConfig
@WebServlet(name = "UploadGameServlet", urlPatterns = {"/uploadgame"})
public class UploadGameServlet extends HttpServlet {

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
            out.println("<title>Servlet UploadGameServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UploadGameServlet at " + request.getContextPath() + "</h1>");
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
        ICategoryDAO cd = new CategoryDAO();
        List<Category> list = cd.getCategory();

        request.setAttribute("cate", list);

        //vào trang UploadGames
        request.getRequestDispatcher("UploadGames.jsp").forward(request, response);
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
        CategoryDAO c_dao = new CategoryDAO();
        

        String name = request.getParameter("name");
        float price = (float) 0.0; // default value
        if (request.getParameter("price") != null) {
            price = Float.parseFloat(request.getParameter("price"));
        }
        String decription = request.getParameter("decription");

//        //tạo đường truyền dẫn cho upload ảnh
//        Part part = request.getPart("poster");
//        String realPath = request.getServletContext().getRealPath("/poster");
//        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
//
//        //trường hợp không có ảnh truyền vào
//        if (filename.isEmpty()) {
//            filename = "Default Avatar.jpg";
//        }
//        part.write(realPath + "/" + filename);
//        
        String[] cid_raw = request.getParameterValues("category");
        List<Category> list = c_dao.getCategory();
        try {
            if (cid_raw != null) {
                for (String i : cid_raw) {
                    list.add(new Category(Integer.parseInt(i), ""));
                }
            }
            //truyền dữ liệu vào Game

        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        Game g = new Game(name, price, decription, name, list);

        IGameDAO gd = new GameDAO();
        if (gd.uploadGame(g) > 0) {
            response.sendRedirect("mainscreen");
        }
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
