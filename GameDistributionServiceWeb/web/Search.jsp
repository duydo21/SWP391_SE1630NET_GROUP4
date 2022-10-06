<%-- 
    Document   : games
    Created on : Oct 4, 2022, 5:04:29 PM
    Author     : Strongest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to WHG</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <style>
            section{
                width: 70%;
                margin: 0 auto;
                padding-top: 20px;

            }
            body{
                background-color: #d9d9d9;
            }
            .text {
                position: relative;
            }

            /* Make the image responsive */
            .text img {
                width: 100%;
                height: auto;
            }
            .d-flex{
                margin-left: auto;
            }
            /* Style the button and place it in the middle of the container/image */
            .text .btn {
                position: absolute;
                top: -130%;
                left: 82%;
                transform: translate(-50%, -50%);
                -ms-transform: translate(-50%, -50%);
                background-color: #555;
                color: white;
                border: none;
                cursor: pointer;
                border-radius: 5px;
                background-color: #b721ff;
                border: none;
            }
            .navbar-expand-lg{
                padding-left:15%;
                padding-right:15%;
            }
            .search{
                margin-left: auto;
            }
            .d-flex button{
                background-color: #a0a1b4;
            }


        </style>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-secondary">
                <a class="navbar-brand" href="mainscreen"><img src="image/logo.png" alt="alt" class="navbar-brand" style="height: 100px"/></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
                                Store
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="">New Release</a>
                                <a class="dropdown-item" href="#">Deals</a>
                                <a class="dropdown-item" href="#">Best Selling</a>
                                <a class="dropdown-item" href="#">Free to play</a>
                                <a class="dropdown-item" href="#">Coming Soon</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">Genre</a>
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
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Welcome ${sessionScope.userlogin.nickname}
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="profile?UserID=${sessionScope.userlogin.userID}">Profile</a>
                                    <a class="dropdown-item" href="logout">Sign out</a>
                                    <a class="dropdown-item" href="#">Payment</a>
                                </div>
                            </li>
                        </c:if>                 
                    </ul>
                    <form class="d-flex" action="search" method = "get">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </header>
        <section>
            <div>
                <h1>Search result for (${requestScope.keyword})</h1>
            </div>
            <div class=" container" style="padding: 0; min-height: 800px;">
                <div class="row">
                    <c:if test="${requestScope.size == 0}">
                        <div style="width: 70%;">
                            Oof,sorry we cannot find any game that have that name!
                        </div>
                    </c:if>
                    <c:if test="${requestScope.size != 0}">
                        <div style="width: 70%;">
                            <table class="table table-active" >
                                <thead>
                                    <tr>
                                        <th scope="col" style="width: 20%">Title</th>
                                        <th scope="col"></th>
                                        <th scope="col" style="text-align: center" >Price</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.gamesearch}" var="game">
                                        <tr onclick="window.location.href = 'game?gameID=${game.gameID}'">
                                            <th scope="col">${game.name}</th>
                                            <th scope="col"> 
                                                <div style="width:200px; height: 100px; display: table-cell" >
                                                    <img src="${game.poster}" alt="alt" style="width: 100%;height: 100%" />
                                                </div>
                                            </th>
                                            <th scope="col" style="text-align: center">${game.price}</th>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>                    
                        </div>              
                    </c:if>
                    <div style=" background-color: #a0a1b4; width: 20%; height: 500px;">
                        <h5>Choose your price range</h5>
                        <form action="games" method="post">
                            <div>
                                <input type="number" name="first" placeholder="0" style="width: 40%;display: inline"/> 
                                <p style="display: inline">-</p>
                                <input type="number" name="second" placeholder="0" style="width: 40%;display: inline"/>           
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>              
        <footer class="bg-light text-center text-lg-start">
            <!-- Copyright -->
            <div class="text-center p-3" style="background-color: #6c757d;">
                This website is created by group 4 SWP391.<br>
                Pham Tien Manh<br>
                Do Ngoc Duy<br>
                Nguyen Hoang Anh<br>
                Dang Minh Hieu <br>
                Vu Hoang Minh Quan<br>
                <a class="text-white" href="https://github.com/traitimtrongvang21/SWP-Project">Github</a>
            </div>
            <!-- Copyright -->
        </footer>
    </body>
</html>
