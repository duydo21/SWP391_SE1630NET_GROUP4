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

            /*Make the image responsive*/
            .text img {
                width: 100%;
                height: auto;
            }
            .d-flex{
                margin-left: auto;
            }
            /*Style the button and place it in the middle of the container/image*/
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
                                    </div>
                                </c:forEach>
                                <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                                <a class="next" onclick="plusSlides(1)">&#10095;</a>
                                <div class="row1">
                                    <div class="column1">
                                        <c:forEach var="pic" items="${requestScope.gameMedias}">
                                            <c:if test="${(pic.getType()==1)}">
                                                <img class="demo cursor" src="${pic.getLink()}" class="full-width" onclick="currentSlide(1)">
                                            </c:if>
                                            <c:if test="${(pic.getType()==2)}">
<!--                                                <video controls class="demo cursor" poster="${game.getPoster()}" class="full-width" onclick="currentSlide(1)">
                                                </video>-->
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div id="game-details">
                            <div id="game-poster" >
                                <!--lay tu game-poster-->
                                <!--<img src="${game.getPoster()}" alt="">-->
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
        
    </script>
</body>
<footer>
    <%@include file="footer.jsp"%>
</footer>
</html>
