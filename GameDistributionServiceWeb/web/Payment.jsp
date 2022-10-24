<%-- 
    Document   : Payment
    Created on : Oct 15, 2022, 8:30:18 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
        <!--        splide framework-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@splidejs/splide@3.6.12/dist/css/splide.min.css"> 
        <script src="https://cdn.jsdelivr.net/npm/@splidejs/splide@3.6.12/dist/js/splide.min.js"></script>

        <link rel="stylesheet" href="css/Header.css"/>
        <style>
            section{
                width: 70%;
                margin: 0 auto;
                background-color: #ccc;
                text-align: center;
                position: relative;
                padding-bottom: 10px;
            }
            #heading{
                font-size: 30px;
                font-weight: 700;
                text-align: center;
                padding:  10px 0;
            }
            .meth{
                transform: translateX(20px);
                border: #ccc;
            }
            .amount{
                transform: translateX(72px);
                border: #ccc;
            }
            label{
                position: absolute;
                left: 30%;
            }
            #form{
                font-size: 20px;
            }
            #method,#amount,#type{
                margin: 10px 0;
            }
            .submit{
                margin-bottom: 7px;
            }
        </style>
    </head>
    <body>
        <c:set var="acc" value="${sessionScope.acc}"/>
        <c:set var="method" value="${requestScope.method}"/>
        <c:set var="amount" value="${requestScope.amount}"/>
        <c:set var="type" value="${requestScope.type}"/>
        <c:if test="${acc==null}">
            <%
                response.sendRedirect("login");
            %>
        </c:if>
        <header>
            <jsp:include page="Header.jsp" />
        </header>
        <section>
            <div id="heading">PAYMENT</div>
            <form action="payment" method="post">
                <div id="form">
                    <div id="method">
                        <label>Method:</label>
                        <select class="meth" name="meth">
                            <c:if test="${method==null}">
                                <option value="1">Paypal</option>
                                <option value="2">Credit Card</option>
                                <option value="3">Banking</option>
                            </c:if>
                            <c:if test="${method==1}">
                                <option value="1">Paypal</option>
                                <option value="2">Credit Card</option>
                                <option value="3">Banking</option>
                            </c:if>
                            <c:if test="${method==2}">
                                <option value="1">Paypal</option>
                                <option selected value="2">Credit Card</option>
                                <option value="3">Banking</option>
                            </c:if>
                            <c:if test="${method==3}">
                                <option value="1">Paypal</option>
                                <option value="2">Credit Card</option>
                                <option selected value="3">Banking</option>
                            </c:if>
                        </select>
                    </div>
                    <div id="amount">
                        <label>Amount:</label>
                        <c:if test="${amount==null}">
                            <input class="amount" type="text" name="amount" required>
                        </c:if>
                        <c:if test="${amount!=null}">
                            <input class="amount" type="text" name="amount" value="${amount}">
                        </c:if>
                    </div>
                    <div id="type">
                        <c:if test="${type==1}">
                            <input type="radio" name="t" value="0"> Withdraw
                            <input type="radio" name="t" checked value="1"> Insert
                        </c:if>
                        <c:if test="${type==0}">
                            <input type="radio" name="t" checked value="0"> Withdraw
                            <input type="radio" name="t" value="1"> Insert
                        </c:if>
                        <c:if test="${type==null}">
                            <input type="radio" name="t" checked value="0"> Withdraw
                            <input type="radio" name="t" value="1"> Insert
                        </c:if>
                    </div>
                    <input class="submit" type="submit" value="Perform">
                </div>
            </form>
            <p style="color: red;font-size: 20px">${requestScope.msf}</p>
            <p style="color: green;font-size: 20px">${requestScope.mss}</p>
        </section>
        <footer>
            <%@include file="footer.jsp"%>
        </footer>
    </body>
</html>
