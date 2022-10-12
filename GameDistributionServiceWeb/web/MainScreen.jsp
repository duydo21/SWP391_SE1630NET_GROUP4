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
        <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
        <script>
            var multipleCardCarousel = document.querySelector(
                    "#carouselBest"
                    );

            var carousel = new bootstrap.Carousel(multipleCardCarousel, {
                interval: false
            });
            var carouselWidth = $("#carouselBest .carousel-inner")[0].scrollWidth;
            var cardWidth = $("#carouselBest .carousel-inner .carousel-item").width();
            var scrollPosition = 0;
            $("#carouselBest .carousel-control-next").on("click", function () {
                if (scrollPosition < carouselWidth - cardWidth * 4) {
                    scrollPosition += cardWidth;
                    $("#carouselBest .carousel-inner").animate({scrollLeft: scrollPosition}, 600);
                }
            });
            $("#carouselBest .carousel-control-prev").on("click", function () {
                if (scrollPosition > 0) {
                    scrollPosition -= cardWidth;
                    $("#carouselBest .carousel-inner").animate(
                            {scrollLeft: scrollPosition},
                            600
                            );
                }
            });

        </script>
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
            #carouselBest .carousel-inner .carousel-item{
                margin-right: 0;
                flex: 0 0 0;
                display: block;
            }

        </style>
    </head>
    <body>
        <header>
            <jsp:include page="Header.jsp" />
        </header>
        <section>
            <div style="width: 100%; height: 20px; border-bottom: 1px solid black;">
                <span style="font-size: 30px; background-color: #d9d9d9; padding: 0 20px;">
                    Featured <!--Padding is optional-->
                </span>
            </div>
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
                                <button class="btn" onclick="window.location.href = 'game?gameID=${game.gameID}'">More Detail</button>
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
                                <img class="card-img-top" src="${game.poster}" alt="Card image cap" style="width: 288px;height: 165px">
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
            <div id="carouselBest" class="carousel slide gamerow" data-interval="false" data-bs-ride="carousel" style="padding-top: 20px;">
                <div class="carousel-inner" style="display: flex;">
                    <% boolean isFirst3 = true;%>
                    <c:forEach items="${requestScope.bestseller}" var="game" begin="0" end="9">
                        <div class="carousel-item <%= isFirst3 ? "active" : ""%> best">
                            <div class="card" style="width: 18rem;">
                                <img class="card-img-top" src="${game.poster}" alt="Card image cap" style="width: 288px;height: 165px">
                                <div class="card-body">
                                    <h5 class="card-title">${game.name}</h5>
                                    <p class="card-text">${game.price}</p>
                                </div>
                            </div>
                        </div>  
                        <% isFirst3 = false; %> 
                    </c:forEach>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselBest" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselBest" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
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
