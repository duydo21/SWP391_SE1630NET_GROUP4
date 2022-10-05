<%-- 
    Document   : MainScreen
    Created on : Sep 22, 2022, 4:28:18 PM
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
            .d-flex{
                margin-left: auto;
            }
            .cards-wrapper {
                display: flex;
            }
            .card img {
                max-width: 100%;
                max-height: 100%;
            }
            .card {
                margin: 0 0.5em;
                box-shadow: 2px 6px 8px 0 rgba(22, 22, 26, 0.18);
                border: none;
                border-radius: 0;
            }
            .carousel-inner {
                padding: 1em;
            }
            .gamerow .carousel-control-prev,
            .gamerow .carousel-control-next {
                background-color: #e1e1e1;
                width: 5vh;
                height: 5vh;
                border-radius: 50%;
                top: 50%;
                transform: translateY(-50%);
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
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Store
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">New Release</a>
                                <a class="dropdown-item" href="#">Deals</a>
                                <a class="dropdown-item" href="#">Best Selling</a>
                                <a class="dropdown-item" href="#">Free to play</a>
                                <a class="dropdown-item" href="#">Coming Soon</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">Genre</a>
                                <a class="dropdown-item" href="#">Deals</a>
                                <a class="dropdown-item" href="#">All games</a>
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
                    <form class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </nav>

        </header>
        <section>
            <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel" style="padding-top: 20px;width: 70%; margin: 0 auto;">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3" aria-label="Slide 4"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="4" aria-label="Slide 5"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="5" aria-label="Slide 6"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="6" aria-label="Slide 7"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="7" aria-label="Slide 8"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="8" aria-label="Slide 9"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="9" aria-label="Slide 10"></button>
                </div>
                <div class="carousel-inner">
                    <% boolean isFirst = true;%>
                    <c:forEach items="${requestScope.gamelist}" var="game" begin="0" end="9" varStatus="count">  
                        <div class="carousel-item <%= isFirst ? "active" : ""%>">
                            <img src="${game.poster}" class="d-block w-100" alt="Poster">
                            <div class="text">
                                <p>${game.price}</p>
                                <button class="btn">More Detail</button>
                            </div>
                        </div>
                        <% isFirst = false; %>  
                    </c:forEach>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
            <div style="width: 100%; height: 20px; border-bottom: 1px solid black;">
                <span style="font-size: 30px; background-color: #d9d9d9; padding: 0 10px;">
                    New Release <!--Padding is optional-->
                </span>
            </div>
            <div id="carouselExampleControls2" class="carousel slide gamerow" data-interval="false" data-bs-ride="carousel" style="padding-top: 20px;">
                <div class="carousel-inner" style="display: flex; overflow: auto">
                    <c:forEach items="${requestScope.newrelease}" var="game" begin="0" end="9">
                        <div class="item active">
                            <div class="card" style="width: 18rem;">
                                <img class="card-img-top" src="${game.poster}" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">${game.name}</h5>
                                    <p class="card-text">${game.price}</p>
                                </div>
                            </div>
                        </div>                  
                    </c:forEach>
                </div>
            </div>
            <div style="width: 100%; height: 20px; border-bottom: 1px solid black;">
                <span style="font-size: 30px; background-color: #d9d9d9; padding: 0 10px;">
                    Best seller <!--Padding is optional-->
                </span>
            </div>
            <div id="carouselExampleControls3" class="carousel slide gamerow" data-interval="false" data-bs-ride="carousel" style="padding-top: 20px;">
                <div class="carousel-inner" style="display: flex; overflow: auto">
                    <c:forEach items="${requestScope.bestseller}" var="game" begin="0" end="9">
                        <div class="item active">
                            <div class="card" style="width: 18rem;">
                                <img class="card-img-top" src="${game.poster}" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">${game.name}</h5>
                                    <p class="card-text">${game.price}</p>
                                </div>
                            </div>
                        </div>                  
                    </c:forEach>
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
