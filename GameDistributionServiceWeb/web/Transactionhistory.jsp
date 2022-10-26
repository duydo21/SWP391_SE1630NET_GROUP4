<%-- 
    Document   : transactionhistory
    Created on : Oct 13, 2022, 2:40:56 PM
    Author     : Cun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transaction History</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
        <style>
            .tranhis {
                width: auto;
                margin-left: 10%;
                margin-right: 10%;
                padding: 10px;
                overflow: auto;
            }
            #post {
                width: 75%;
                height: auto;
                float: right;
            }
            #sidebar {
                width: 25%;
                height: auto;
                float: left;
            }
        </style>
        <script type="text/javascript">
            function changeFunc() {
                document.getElementById("sortlist").submit();
            }
        </script>
    </head>
    <body>
        <h1 class="text-uppercase text-center mb-5" style="text-align: center; margin-top: 20px"><u>TRANSACTION HISTORY</u></h1>
        <div class="tranhis">
            <div id="sidebar">
                <input type="checkbox" />Show only additon<br>
                <input type="checkbox" />Show only subtraction
            </div>
            <div id="post">
                <div style="float: left">   
                    <form class="search d-flex "  action="findtransactionhistory" method = "get" style="margin-left: 20px">
                        <input type="hidden" name="UserID" value="${sessionScope.userlogin.userID}"/>                                       <!--id tai khoan-->
                        <input type="search" placeholder="Search" aria-label="Search" name="keytransactionhistory" value="${keytranhis}">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>

                <form id="sortlist" action="transactionhistory" method="get">
                    <input type="hidden" name="UserID" value="${sessionScope.userlogin.userID}"/> 
                    <div style="float: right">
                        <label>Sort by: </label>
                        <select id="selectBox" name="sortList" onchange="changeFunc()">
                            <option value="date" ${dateSelected}>Date</option>
                            <option value="money" ${moneySelected}>Money</option>
                            <option value="paymentmethod" ${paymentMethodSelected}>Payment Method</option>
                        </select>
                    </div>
                </form>  

            </div>
        </div>
        <div id="post" style="background-color: #e8e8e8; margin-right: 10%">
            <c:forEach items="${requestScope.pagingth}" var="listth">              <!--lay du lieu ve table-->
                <table style="width: 100%; border-bottom: solid 2px">
                    <tr>
                        <th>Payment method:                                         <!--phan loai giao dich-->
                            <c:choose>
                                <c:when test="${listth.paymentMethod == 1}">Paypal</c:when>
                                <c:when test="${listth.paymentMethod == 2}">Credit Card</c:when>
                                <c:when test="${listth.paymentMethod == 3}">Banking</c:when>
                                <c:when test="${listth.paymentMethod == 4}">Buy Game</c:when>
                                <c:when test="${listth.paymentMethod == 5}">Sell Game</c:when>
                            </c:choose>
                        </th>
                        <th style="text-align: center;">${listth.date}</th>
                    </tr>
                    <tr>
                        <th>Amount of money: ${listth.money}</th>
                        <th style="text-align: center;"></th>
                    </tr>
                </table>
            </c:forEach>

            <c:forEach begin="1" end="${endPageth}" var="i">                                        <!--phan trang-->
                <a href="transactionhistory?UserID=${sessionScope.userlogin.userID}&index=${i}&sortList=${sorttype}">${i}</a>
            </c:forEach>

            <c:if test="${requestScope.size == 0}">                                                 <!--thong bao neu kich thuoc list lay ve = 0-->
                <h1 style="margin-top: 20px">Nothing here, <a href="games">Let's buy something</a></h1>
            </c:if>
        </div>
    </body>
</html>