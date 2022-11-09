
<%-- 
    Document   : Header
    Created on : Oct 6, 2022, 2:36:12 PM
    Author     : Strongest
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            #dropdown{
                position: absolute;
                display: block;
                min-height: max-content;
                max-height: 500px;
                width: 100%;
                overflow: auto;
                background-color: white;
                margin-top: 13%;
                z-index: 2;
            }

            #game:hover{
                background-color: #e6e6e6;
            }
            #dropdown #game{
                height: 50px;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-secondary">
            <a class="navbar-brand" href="mainscreen"><img src="image/logo.png" alt="alt" class="navbar-brand" style="height: 100px"/></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
                            Store
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="news">New Release</a>
                            <a class="dropdown-item" href="deal">Deals</a>
                            <a class="dropdown-item" href="best">Best Selling</a>
                            <a class="dropdown-item" href="free">Free to play</a>
                            <a class="dropdown-item" href="#">Coming Soon</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="genre">Genre</a>
                            <a class="dropdown-item" href="games">All games</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="about">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Support</a>
                    </li>
                    <c:if test="${(sessionScope.acc == null)}">
                        <li class="nav-item">
                            <a class="nav-link" href="login">Sign in</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="register">Sign up</a>
                        </li>                            
                    </c:if>
                    <c:if test="${(sessionScope.acc != null)}">                        
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Welcome ${sessionScope.userlogin.nickname} 
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="profile?UserID=${sessionScope.userlogin.userID}">Profile</a>
                                <a class="dropdown-item" href="changepass?acc=${sessionScope.acc.username}">Change Password</a>
                                <a class="dropdown-item" href="logout">Sign out</a>
                                <a class="dropdown-item" href="payment">Payment</a>
                                <a class="dropdown-item" href="transactionhistory?UserID=${sessionScope.userlogin.userID}">Transaction History</a>
                                <c:if test="${sessionScope.userlogin.isDev==true}"> 
                                <a class="dropdown-item" href="uploadgame">Upload Games</a>
                                </c:if>
                            </div>
                        </li>
                    </c:if>
                    <c:if test="${(sessionScope.acc != null)}">
                        <c:if test="${(sessionScope.userlogin.isDev == false)}"> 
                            <a class="nav-link bg-danger" href="/GameDistributionServiceWeb/isDev?UserID=${sessionScope.userlogin.userID}">Dev Register</a>
                        </c:if>    
                    </c:if>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="bi bi-bell"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bell" viewBox="0 0 16 16">
                                <path d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2zM8 1.918l-.797.161A4.002 4.002 0 0 0 4 6c0 .628-.134 2.197-.459 3.742-.16.767-.376 1.566-.663 2.258h10.244c-.287-.692-.502-1.49-.663-2.258C12.134 8.197 12 6.628 12 6a4.002 4.002 0 0 0-3.203-3.92L8 1.917zM14.22 12c.223.447.481.801.78 1H1c.299-.199.557-.553.78-1C2.68 10.2 3 6.88 3 6c0-2.42 1.72-4.44 4.005-4.901a1 1 0 1 1 1.99 0A5.002 5.002 0 0 1 13 6c0 .88.32 4.2 1.22 6z"/>
                                </svg>
                            </i>
                        </a>
                        <c:forEach begin="1" end="3">
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Profile</a>                           
                            </div>
                        </c:forEach>
                    </li>
                </ul>
                <form class="search d-flex " action="search" method = "get" style="position: relative">
                    <input class="form-control me-2" id="input" type="search" placeholder="Search" aria-label="Search" name="search" onkeyup="filterFunction()">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                    <div id="dropdown" style="display: none">
                        <c:forEach items="${requestScope.gamelist}" var="g">
                            <div id="game" onclick="window.location.href = 'gameDetails?GameID=${g.gameID}'">
                                <div>
                                    <img src="${g.poster}" alt="alt" style="width: 20%; float: left"/>
                                    <p>${g.name}</p>                                 
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </form>

            </div>
        </nav>
        <script type="text/javascript">
            /* When the user clicks on the button,
             toggle between hiding and showing the dropdown content */

            function filterFunction() {
                var input, filter, a, i;
                input = document.getElementById("input");
                filter = input.value.toUpperCase().trim();
                div = document.getElementById("dropdown");
                a = div.getElementsByTagName("div");
                for (i = 0; i < a.length; i++) {
                    document.getElementById("dropdown").style.display = "block";
                    txtValue = a[i].textContent || a[i].innerText;
                    if (txtValue.toUpperCase().indexOf(filter) > 0) {
                        a[i].style.display = "";
                    } else {
                        a[i].style.display = "none";
                    }
                }
            }
        </script> 
    </body>
</html>
