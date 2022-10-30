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
import java.util.ArrayList;
import java.util.List;
import model.Payment;
import model.User;

/**
 *
 * @author Vu Hoang Minh Quan
 */
@WebServlet(name = "transactionhistoryServlet", urlPatterns = {"/transactionhistory"})
public class TransactionhistoryServlet extends HttpServlet {

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
            out.println("<title>Servlet transactionhistoryServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>There is something wrong, please try again</h1>");
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
        try {
            int id = Integer.parseInt(request.getParameter("UserID"));                          //lay id nguoi duong nhap

            String key = request.getParameter("keytransactionhistory");                         //lay tu tim kiem
            if (key == null) {
                key = "";
            }

            String indexPage = request.getParameter("index");                                   //lay so trang
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);

            String addcheckbox = request.getParameter("addonly");                               //lay tich checkbox
            if (addcheckbox == null) {
                addcheckbox = "";
            }
            String addchecked = "";
            if (addcheckbox.equals("on")) {
                addchecked = "checked";
            }
            String subcheckbox = request.getParameter("subonly");
            if (subcheckbox == null) {
                subcheckbox = "";
            }
            String subchecked = "";
            if (subcheckbox.equals("on")) {
                subchecked = "checked";
            }

            String sortType = request.getParameter("sortList");                                 //lay kieu sap xep
            if (sortType == null) {
                sortType = "date";
            }
            String dateSelect = "";
            String moneySelect = "";
            String paymentMethodSelect = "";
            switch (sortType) {
                case "date":
                    dateSelect = "selected";
                    break;
                case "money":
                    moneySelect = "selected";
                    break;
                case "paymentmethod":
                    paymentMethodSelect = "selected";
                    break;
            }

            User user = new UserDAO().findUserByID(id);                                         //tim tai khoan nguoi dang nhap

            List<Payment> list = new PaymentDAO().getAllTransactionHistory(user);               //lay du lieu theo tai khoan do                 

            List<Payment> listAfterSearch = new PaymentDAO().searchPaymentbyKey(user, key.trim());     //lay du lieu theo tai khoan do voi tu tim kiem

            List<Payment> listAfterChecked;
            listAfterChecked = listAfterSearch;

            if (addcheckbox.equals("on")) {                                                     //tao list moi voi ap dung checkbox
                listAfterChecked = new ArrayList<>();
                for (int i = 0; i < listAfterSearch.size(); i++) {
                    if (listAfterSearch.get(i).getMoney() > 0) {
                        listAfterChecked.add(listAfterSearch.get(i));
                    }
                }
            }
            if (subcheckbox.equals("on")) {
                listAfterChecked = new ArrayList<>();
                for (int i = 0; i < listAfterSearch.size(); i++) {
                    if (listAfterSearch.get(i).getMoney() < 0) {
                        listAfterChecked.add(listAfterSearch.get(i));
                    }
                }
            }
            if (addcheckbox.equals("on") && subcheckbox.equals("on")) {
                listAfterChecked = listAfterSearch;
            }

            switch (sortType) {                                                                             //sap xep list cuoi cung
                case "date":
                    listAfterChecked = sortDateList(listAfterChecked);
                    break;
                case "money":
                    listAfterChecked = sortMoneyList(listAfterChecked);
                    break;
                case "paymentmethod":
                    listAfterChecked = sortPaymentMethodList(listAfterChecked);
                    break;
            }

            int countList = listAfterChecked.size();                                                        //them trang thieu
            int endPage = countList / 5;
            if (countList % 5 != 0) {
                endPage++;
            }

            List<Payment> listPaging = getPaging(listAfterChecked, index);                                  //phan trang

            request.setAttribute("pagingth", listPaging);                                                   //truyen du lieu danh sach da phan trang
            request.setAttribute("endPageth", endPage);                                                     //truyen so trang hien thi
            request.setAttribute("sizeth", countList);                                                      //truyen kich thuoc danh sach

            request.setAttribute("sorttype", sortType);                                                     //truyen kieu sap xep
            request.setAttribute("dateSelected", dateSelect);
            request.setAttribute("moneySelected", moneySelect);
            request.setAttribute("paymentMethodSelected", paymentMethodSelect);

            request.setAttribute("addchecked", addchecked);                                                 //truyen checkbox
            request.setAttribute("addcheckbox", addcheckbox);
            request.setAttribute("subchecked", subchecked);
            request.setAttribute("subcheckbox", subcheckbox);

            request.setAttribute("keytranhis", key.trim());                                                        //truyen tu tim kiem

            request.getRequestDispatcher("Transactionhistory.jsp").forward(request, response);              //ve trang
        } catch (Exception e) {
            processRequest(request, response);
        }
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

    private List<Payment> getPaging(List<Payment> list, int index) {                                        //phan trang 5
        List<Payment> newList = new ArrayList<>();
        for (int i = (index - 1) * 5; i < 5 * index && i < list.size(); i++) {
            newList.add(list.get(i));
        }
        return newList;
    }

    private List<Payment> sortDateList(List<Payment> list) {                                                //sap xep theo Date
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getDate().compareTo(list.get(j + 1).getDate()) > 0) {
                    Payment temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return list;
    }

    private List<Payment> sortMoneyList(List<Payment> list) {                                               //sap xep theo Money
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getMoney() > list.get(j + 1).getMoney()) {
                    Payment temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return list;
    }

    private List<Payment> sortPaymentMethodList(List<Payment> list) {                                       //sap xep theo PaymentMethod
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getPaymentMethod() > list.get(j + 1).getPaymentMethod()) {
                    Payment temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return list;
    }

}
