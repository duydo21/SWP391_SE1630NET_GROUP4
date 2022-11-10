<%-- 
    Document   : Notification
    Created on : Nov 3, 2022, 12:00:08 AM
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
    </head>
    <style>
        section{
            width: 70%;
            margin: 0 auto;
        }
        .title{
            text-align: center;
            font-size: 30px;
        }
        .noti-container{
            text-align: center;
        }
        .filter{
            text-align: center;
        }
        .a-noti{
            margin: 5px auto;
            background-color: #0099ff;
            width: 50%;
        }
        .show-noti{
            display: block !important;
        }
    </style>
    <body>
        <c:set var="acc" value="${sessionScope.acc}"/>
        <c:set var="sort" value="${requestScope.sort}"/>
        <c:set var="filter" value="${requestScope.filter}"/>
        <c:set var="user" value = "${sessionScope.userlogin}"/>
        <c:set var="notiList" value = "${requestScope.notiList}"/>
        <c:if test="${acc==null}">
            <%
                response.sendRedirect("login");
            %>
        </c:if>
        <header>
            <jsp:include page="Header.jsp" />
        </header>
        <section>
            <!--header cua body-->
            <div class="title">
                <p>NOTIFICATION</p>
            </div>
            <!--filter noti-->
            <div class="filter">
                <form action="notification" method="post">
                    <label>Show: </label>
                    <select name="sort">
                        <c:if test="${sort.equals('0')}">
                            <option value="0" selected>Latest</option>
                            <option value="1">Oldest</option>
                        </c:if>
                        <c:if test="${sort.equals('1')}">
                            <option value="0">Latest</option>
                            <option value="1" selected>Oldest</option>
                        </c:if>
                    </select>
                    <select name="filter">
                        <c:if test="${filter.equals('0')}">
                            <option value="0" selected>All</option>
                            <option value="1">Buy game</option>
                            <option value="2">Withdraw money</option>
                            <option value="3">Purchase money</option>
                            <option value="4">Money from self-owned games</option>
                            <option value="5">Report from admin</option>
                            <option value="6">Game response from admin</option>
                        </c:if>
                        <c:if test="${filter.equals('1')}">
                            <option value="0">All</option>
                            <option value="1" selected>Buy game</option>
                            <option value="2">Withdraw money</option>
                            <option value="3">Purchase money</option>
                            <option value="4">Money from self-owned games</option>
                            <option value="5">Report from admin</option>
                            <option value="6">Game response from admin</option>
                        </c:if>
                        <c:if test="${filter.equals('2')}">
                            <option value="0">All</option>
                            <option value="1">Buy game</option>
                            <option value="2" selected>Withdraw money</option>
                            <option value="3">Purchase money</option>
                            <option value="4">Money from self-owned games</option>
                            <option value="5">Report from admin</option>
                            <option value="6">Game response from admin</option>
                        </c:if>
                        <c:if test="${filter.equals('3')}">
                            <option value="0">All</option>
                            <option value="1">Buy game</option>
                            <option value="2">Withdraw money</option>
                            <option value="3" selected>Purchase money</option>
                            <option value="4">Money from self-owned games</option>
                            <option value="5">Report from admin</option>
                            <option value="6">Game response from admin</option>
                        </c:if>
                        <c:if test="${filter.equals('4')}">
                            <option value="0">All</option>
                            <option value="1">Buy game</option>
                            <option value="2">Withdraw money</option>
                            <option value="3">Purchase money</option>
                            <option value="4" selected>Money from self-owned games</option>
                            <option value="5">Report from admin</option>
                            <option value="6">Game response from admin</option>
                        </c:if>
                        <c:if test="${filter.equals('5')}">
                            <option value="0">All</option>
                            <option value="1">Buy game</option>
                            <option value="2">Withdraw money</option>
                            <option value="3">Purchase money</option>
                            <option value="4">Money from self-owned games</option>
                            <option value="5" selected>Report from admin</option>
                            <option value="6">Game response from admin</option>
                        </c:if>
                        <c:if test="${filter.equals('6')}">
                            <option value="0">All</option>
                            <option value="1">Buy game</option>
                            <option value="2">Withdraw money</option>
                            <option value="3">Purchase money</option>
                            <option value="4">Money from self-owned games</option>
                            <option value="5">Report from admin</option>
                            <option value="6" selected>Game response from admin</option>
                        </c:if>
                    </select>
                    <button type="submit">Filter</button>
                </form>
            </div>
            <!--noti list-->
            <div class="noti-list">
                <div class="noti-container">
                    <c:if test="${notiList.size()==0}">
                        <p style="font-size: 20px;">There is no notification!</p>
                    </c:if>
                    <c:forEach items="${notiList}" var = "noti">
                        <div class="a-noti" style="display: none;">
                            <div class="noti-content">
                                ${noti.getContent()}
                            </div>
                            <div class="noti-date">
                                <label>Date: </label>${noti.getDate()}
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>
        <footer>
            <%@include file="footer.jsp"%>
        </footer>
        <script>
//            const container = document.querySelector('.cmt-list-container');
            const nts = document.querySelectorAll('.a-noti');
            let i = 0;

            function loadNotis(num_noti = 5) {
                let j = 0;
                while (j < num_noti) {
                    nts[i].classList.add('show-noti');
                    i++;
                    j++;
            }
            }

            loadNotis();

            window.addEventListener('scroll', () => {
                console.log(window.scrollY); //scrolled from top
                console.log(window.innerHeight); //visible part of screen
                if (window.scrollY + window.innerHeight >= document.documentElement.scrollHeight) {
                    loadNotis();
                }
            });
        </script>
    </body>
</html>
