/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.nio.file.Paths;
import java.sql.Date;
import model.User;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "EditProfileServlet", urlPatterns = {"/editprofile"})
@MultipartConfig
public class EditProfileServlet extends HttpServlet {

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
            out.println("<title>Servlet EditProfileServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditProfileServlet at " + request.getContextPath() + "</h1>");
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
        //lấy parameter của id  qua UserID

        String id_raw = request.getParameter("UserID");
        int id = Integer.parseInt(id_raw);
        //Tìm kiếm user bằng id

        //vào trang EditProfile
        request.getRequestDispatcher("EditProfile.jsp").forward(request, response);

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
        //lấy pameter ở EditProfile
        int id = Integer.parseInt(request.getParameter("id"));
        String nickname = request.getParameter("nickname").trim();
        String country = request.getParameter("country");
        String email = request.getParameter("email").trim();
        String decription = request.getParameter("decription").trim();
        boolean isPrivate = Boolean.parseBoolean(request.getParameter("private"));
        Date date = Date.valueOf(request.getParameter("date"));

        //tạo đường truyền dẫn cho upload ảnh
        Part part = request.getPart("avatar");
        String realPath = request.getServletContext().getRealPath("/image");
        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();

        //trường hợp không có ảnh truyền vào
        if (filename.isEmpty()) {
            filename = "Default Avatar.jpg";
        }
        part.write(realPath + "/" + filename);

        //truyền dữ liệu vào User
        User u = new User(id, nickname, country, email, "image" + "/" + filename, date, decription, isPrivate);
        //method UpdateProfileUser
        if (new UserDAO().updateProfileUser(u) > 0) {
            HttpSession session = request.getSession();
            session.removeAttribute("userlogin");
            session.setAttribute("userlogin", u);
            response.sendRedirect("profile?UserID=" + id);
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
