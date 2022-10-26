/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.PaymentDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Payment;
import model.User;

/**
 *
 * @author Vu Hoang Minh Quan
 */
@WebServlet(name="FindtransactionhistoryServlet", urlPatterns={"/findtransactionhistory"})
public class TransactionhistoryServletFind extends HttpServlet {
   
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
            out.println("<title>Servlet FindtransactionhistoryServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FindtransactionhistoryServlet at " + request.getContextPath () + "</h1>");
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
        int id = Integer.parseInt(request.getParameter("UserID"));                  //lay id nguoi duong nhap
        String key = request.getParameter("keytransactionhistory");                 //lay tu tim kiem
        if(key == null){
            key = "";
        }
//        String indexPage = request.getParameter("index");                           //lay so trang
//        if(indexPage == null){
//            indexPage = "1";
//        }    
//        int index = Integer.parseInt(indexPage);
        
        User user = new UserDAO().findUserByID(id);                                 //tim tai khoan nguoi dang nhap
        List<Payment> list = new PaymentDAO().searchPaymentbyKey(user, key);        //lay du lieu theo tai khoan do voi tu tim kiem
        int countList = list.size();
//        int endPage = countList / 5;
//        if(countList % 5 != 0){
//            endPage++;
//        }
        
        request.setAttribute("pagingth", list);                                     //truyen du lieu danh sach voi tu tim kiem
        request.setAttribute("keytranhis", key);                                    //truyen tu tim kiem
        request.setAttribute("size", list.size());                                  //truyen kich thuoc danh sach
        request.getRequestDispatcher("Transactionhistory.jsp").forward(request, response);
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
