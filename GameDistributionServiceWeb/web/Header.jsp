
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
                            <a class="dropdown-item" href="#">Deals</a>
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
                                <a class="dropdown-item" href="#">Payment</a>
                            </div>
                        </li>
                    </c:if>
                    <c:if test="${(sessionScope.userlogin.isDev == false)}"> 
                         <a class="nav-link bg-danger" href="/GameDistributionServiceWeb/isDev?UserID=${sessionScope.userlogin.userID}">Dev Register</a>
                    </c:if>
                </ul>
                <form class="search d-flex " action="search" method = "get">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </nav>
    </body>
</html>
