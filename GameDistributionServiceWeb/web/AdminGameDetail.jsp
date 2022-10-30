<%-- 
    Document   : AdminGameDetail
    Created on : Oct 27, 2022, 5:11:13 PM
    Author     : Strongest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${game.getName()}</title>
        <link rel="stylesheet" href="css/admin-game-details.css">
        <script src="https://kit.fontawesome.com/f92d1eca7b.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/fonts/themify-icons/themify-icons.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/Header.css"/>
        <style>
            body{
                background-color: #333333;
            }
            section{
                width: 70%;
                margin: 0 auto;
                min-height: 800px;

            }
        </style>
    </head>
    <body>
        <c:set var="game" value = "${requestScope.game}"/>
        <c:set var="isBought" value = "${requestScope.isBought}"/>
        <c:set var="mediaList" value = "${requestScope.gameMedias}"/>
        <c:set var="gameList" value = "${requestScope.gameList}"/>
        <c:set var="catList" value = "${requestScope.catList}"/>
        <c:set var="user" value = "${sessionScope.userlogin}"/>
        <c:set var="userVote" value = "${requestScope.userVote}"/>

        <header>
            <jsp:include page="AdminHeader.jsp" />
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
                                        <% int i=1; %>
                                        <c:forEach var="pic" items="${mediaList}">
                                            <c:if test="${(pic.getType()==1)}">
                                                <img class="demo cursor" src="${pic.getLink()}" class="full-width" onclick="currentSlide(<%=i%>)">
                                            </c:if>
                                            <c:if test="${(pic.getType()==2)}">
                                                <video controls class="demo cursor" poster="${game.getPoster()}" onclick="currentSlide(<%=i%>)">
                                                    <source src="${pic.getLink()}" class="full_width">
                                                </video>
                                            </c:if>
                                            <% i++; %>
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
                                <p>Category: 
                                    <c:forEach var="cat" items="${requestScope.catList}">
                                        <a href="" style="text-decoration: none">${cat.getCategoryName()}</a>
                                    </c:forEach>
                                </p>
                                <p>Release date: ${game.getDate()}</p>
                            </div>
                        </div>
                        <div class="clear"></div>
                    </div>

                    <div id="action">
                        <div id="rating">
                            <p>Rating: ${game.getRate()}/10 (${requestScope.votes} votes) </p><br>
                            <span>
                                <div id="like" style="float: left">
                                    <!--TH chua login-->
                                    <c:if test="${user==null}">
                                        <icon class="fa-regular fa-thumbs-up"></icon>
                                        </c:if>
                                    <!--Th login roi-->
                                    <c:if test="${user!=null}">
                                        <!--TH user chua mua game -> ko dc vote-->
                                        <c:if test ="${!isBought}">
                                            <icon class="fa-regular fa-thumbs-up"></icon>
                                            </c:if>
                                        <!--TH user mua game -> dc vote-->
                                        <c:if test ="${isBought}">
                                            <!--TH user chua vote-->
                                            <c:if test="${userVote==-1}">
                                                <icon class="fa-regular fa-thumbs-up" 
                                                      onclick="window.location.href = 'votegame?type=1&GameID=${game.getGameID()}'"></icon>
                                                </c:if>
                                            <!--TH user likes-->
                                            <c:if test="${userVote==1}">
                                                <icon class="fa-solid fa-thumbs-up"></icon>
                                                </c:if>
                                            <!--TH user dislike-->
                                            <c:if test="${userVote==0}">
                                                <icon class="fa-regular fa-thumbs-up"
                                                      onclick="window.location.href = 'votegame?type=1&GameID=${game.getGameID()}'"></icon>
                                                </c:if>
                                            </c:if>

                                    </c:if>
                                    <div>${requestScope.likes} likes</div>
                                </div>
                                <div id="dislike" style="float: left">
                                    <!--TH chua login-->
                                    <c:if test="${user==null}">
                                        <icon class="fa-regular fa-thumbs-down"></icon>
                                        </c:if>
                                    <!--Th login roi-->
                                    <c:if test="${user!=null}">
                                        <!--TH user chua mua game -> ko dc vote-->
                                        <c:if test ="${!isBought}">
                                            <icon class="fa-regular fa-thumbs-down"></icon>
                                            </c:if>
                                        <!--TH user mua game -> dc vote-->
                                        <c:if test ="${isBought}">
                                            <!--TH user chua vote-->
                                            <c:if test="${userVote==-1}">
                                                <icon class="fa-regular fa-thumbs-down"
                                                      onclick="window.location.href = 'votegame?type=0&GameID=${game.getGameID()}'"></icon>
                                                </c:if>
                                            <!--TH user dislikes-->
                                            <c:if test="${userVote==0}">
                                                <icon class="fa-solid fa-thumbs-down"></icon>
                                                </c:if>
                                            <!--TH user likes-->
                                            <c:if test="${userVote==1}">
                                                <icon class="fa-regular fa-thumbs-down"
                                                      onclick="window.location.href = 'votegame?type=0&GameID=${game.getGameID()}'"></icon>
                                                </c:if>
                                            </c:if>
                                        </c:if>
                                    <div>${requestScope.dislikes} dislikes</div>
                                </div>
                            </span>
                        </div>
                        <div id="btn">
                            <button class="delete" style="background-color: rgb(92, 92, 198);">Delete</button>

                            <c:if test ="${(game.getDiscount()==0)}">
                                <div class="price" style="background-color: green; line-height: 40px">
                                    <div class="first-price"">${game.getPrice()}$</div>
                                </div>
                            </c:if>
                            <c:if test ="${(game.getDiscount()!=0)}">
                                <div class="price" style="background-color: green; line-height: 20px">
                                    <div class="first-price line_through">${game.getPrice()}$</div>
                                    <div class="after-price">${game.getPriceAfterDiscount()}$</div>
                                </div>
                            </c:if>

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
            </div>           
        </section>
        <footer>
            <%@include file="footer.jsp"%>
        </footer>

        <div class="modal">
            <div class="modal-container">
                <form action="agameDetails" method="post">
                    <header class="modal-header">
                        <p style="color: red;">Tell developer why:</p>
                        <span class="close">&times;</span>
                    </header>
                    <div class="modal-content">
                        <textarea class="form-control" id="text" name="context" rows="6"></textarea>
                    </div>
                    <div class="modal-footer">
                        <button class="submit-button" type="sumbit">
                            Submit and Delete
                        </button>
                    </div>
                </form>
            </div>
        </div>
        <script>
            //js for slide show
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
        <script>
            //js for buy btn
            const Btn = document.querySelector('.delete');
            const Modal = document.querySelector('.modal');
            const closeModal1 = document.querySelector('.close');
            function Show() {
                Modal.classList.add('open');
            }
            function Hide() {
                Modal.classList.remove('open');
            }
            Btn.addEventListener('click', Show);
            closeModal1.addEventListener('click', Hide);
        </script>
    </body>
</html>
