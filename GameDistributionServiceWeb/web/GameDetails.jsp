<%-- 
    Document   : GameDetails
    Created on : Oct 6, 2022, 9:51:54 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/game-details.css">
        <link rel="stylesheet" href="css/fonts/themify-icons/themify-icons.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/Header.css"/>
        <style>
            section{
                width: 70%;
                margin: 0 auto;

            }
        </style>
    </head>
    <body>
        <c:set var="game" value = "${requestScope.game}"/>
        <header>
            <jsp:include page="Header.jsp" />
        </header>
        <section>
            <div id="container">
                <div id="content">
                    <div id="game-info">
                        <div class="heading">${game.getName()}</div>
                        <div id="selected-game">
                            <div class="pic-container">
                                <c:forEach var="pic" items="${requestScope.gameMedias}">
                                    <div class="mySlides">
                                        <c:if test="${(pic.getType()==1)}">
                                            <img src="${pic.getLink()}" class="full-width">
                                        </c:if>
                                        <c:if test="${(pic.getType()==2)}">
                                            <video controls class="full-width">
                                                <source src="${pic.getLink()}" >
                                            </video>
                                        </c:if>
                                        <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                                        <a class="next" onclick="plusSlides(1)">&#10095;</a>
                                    </div>
                                </c:forEach>

                                <div id="carouselExampleControls2" class="row1 carousel slide gamerow" data-interval="false" data-bs-ride="carousel">
                                    <div class="column1 carousel-inner" style="display: flex; overflow: auto">
                                        <c:forEach var="pic" items="${requestScope.gameMedias}">
                                            <c:if test="${(pic.getType()==1)}">
                                                <img class="demo cursor" src="${pic.getLink()}" class="full-width" onclick="currentSlide(1)">
                                            </c:if>
                                            <c:if test="${(pic.getType()==2)}">
                                                <video controls class="demo cursor" poster="${game.getPoster()}" onclick="currentSlide(1)">
                                                    <source src="${pic.getLink()}" class="full_width">
                                                </video>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div id="game-details">
                            <div id="game-poster" >
                                <!--lay tu game-poster-->
                                <img src="${game.getPoster()}" alt="">
                            </div>
                            <div id="game-detail-info">

                                <!--lay tu game description(ko dc dai qua, max la nhu cai vi du nay)-->
                                <p>${game.getDescription()}</p>
                                <!--lay tu game dev-->
                                <p>Developer: 
                                    <c:forEach var="dev" items="${requestScope.devList}">
                                        ${dev.getNickname()}. 
                                    </c:forEach>
                                </p>

                            </div>
                        </div>
                        <div class="clear"></div>
                    </div>

                    <div id="action">
                        <div id="rating">
                            <p>Rating: </p>
                            <span>
                                <icon class="ti-star" style="color: rgb(245, 5, 5);"></icon>
                                <icon class="ti-star" style="color: rgb(245, 5, 5);"></icon>
                                <icon class="ti-star" style="color: rgb(245, 5, 5);"></icon>
                                <icon class="ti-star"></icon>
                                <icon class="ti-star"></icon>
                            </span>
                        </div>
                        <div id="btn">
                            <button id="buy" style="background-color: rgb(92, 92, 198);">BUY</button>

                            <div class="price" style="background-color: green;">
                                <c:if test ="${(game.getDiscount()==0)}">
                                    <div class="first-price"">${game.getPrice()}$</div>
                                </c:if>
                                <c:if test ="${(game.getDiscount()!=0)}">
                                    <div class="first-price line_through">${game.getPrice()}$</div>
                                    <div class="after-price">${game.getPriceAfterDiscount()}$</div>
                                </c:if>
                            </div>
                            <c:if test ="${(game.getDiscount()!=0)}">
                                <div id="discount" style="background-color: purple;">${game.getDiscount()}%</div>
                            </c:if>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div id="user-comment">
                        <div class="heading-content">Comment</div>
                    </div>
                </div>
                <div id="more-game">
                    <div class="heading">
                        <div class="heading-content">More like this</div>
                        <div id="see-all-link" style="font-size: 15px">
                            <a href="" >See all</a>
                            <icon class="ti-arrow-right"></icon>
                        </div>
                    </div>
                    <!--lay tu 1 list gom 4 game cung category voi game nay-->
                    <div id="games">
                        <div class="game">
                            <div class="overview-pic">
                                <img src="https://cdn.akamai.steamstatic.com/steam/apps/233860/header.jpg?t=1664817530" alt="">
                            </div>
                            <div class="overview-info">
                                <div class="game-name">Kenshi</div>
                                <div class="price">200$</div>
                            </div>
                        </div>
                        <div class="game">
                            <div class="overview-pic">
                                <img src="https://cdn.akamai.steamstatic.com/steam/apps/233860/header.jpg?t=1664817530" alt="">
                            </div>
                            <div class="overview-info">
                                <div class="game-name">Kenshi</div>
                                <div class="price">200$</div>
                            </div>
                        </div>
                        <div class="game">
                            <div class="overview-pic">
                                <img src="https://cdn.akamai.steamstatic.com/steam/apps/233860/header.jpg?t=1664817530" alt="">
                            </div>
                            <div class="overview-info">
                                <div class="game-name">Kenshi</div>
                                <div class="price">200$</div>
                            </div>
                        </div>
                        <div class="game" style="transform: translateY(-8.35px)">
                            <div class="overview-pic" >
                                <img src="https://cdn.akamai.steamstatic.com/steam/apps/233860/header.jpg?t=1664817530"  alt="">
                            </div>
                            <div class="overview-info" >
                                <div class="game-name">Kenshi</div>
                                <div class="price" >200$</div>
                            </div>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        </div>           
    </section>
    <script>
        let slideIndex = 1;
        showSlides(slideIndex);

// Next/previous controls
        function plusSlides(n) {
            showSlides(slideIndex += n);
        }

// Thumbnail image controls
        function currentSlide(n) {
            showSlides(slideIndex = n);
        }

        function showSlides(n) {
            let i;
            let slides = document.getElementsByClassName("mySlides");
            let dots = document.getElementsByClassName("demo");
            let captionText = document.getElementById("caption");
            if (n > slides.length) {
                slideIndex = 1
            }
            if (n < 1) {
                slideIndex = slides.length
            }
            for (i = 0; i < slides.length; i++) {
                slides[i].style.display = "none";
            }
            for (i = 0; i < dots.length; i++) {
                dots[i].className = dots[i].className.replace(" active", "");
            }
            slides[slideIndex - 1].style.display = "block";
            dots[slideIndex - 1].className += " active";
            captionText.innerHTML = dots[slideIndex - 1].alt;
        }
    </script>
</body>
<footer>
    <%@include file="footer.jsp"%>
</footer>
</html>
