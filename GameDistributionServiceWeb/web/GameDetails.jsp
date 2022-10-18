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
        <title>${game.getName()}</title>
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
        <c:set var="isBought" value = "${requestScope.isBought}"/>
        <c:set var="mediaList" value = "${requestScope.gameMedias}"/>
        <c:set var="gameList" value = "${requestScope.gameList}"/>
        <c:set var="catList" value = "${requestScope.catList}"/>
        <c:set var="user" value = "${sessionScope.userlogin}"/>
        
        
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
                            <c:if test ="${isBought}">
                                <button class="buy" style="background-color: rgb(92, 92, 198);">BOUGHT</button>
                            </c:if>
                            <c:if test ="${!isBought}">
                                <button class="buy js-buy-btn" style="background-color: rgb(92, 92, 198);">BUY</button>
                            </c:if>


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
                <div id="more-game">
                    <div class="heading">
                        <div class="heading-content">More like this</div>
                    </div>
                    <!--lay tu 1 list gom 4 game cung category voi game nay-->
                    <div id="games">
                        <c:forEach var="m_game" items= "${gameList}">
                            <div class="game" onclick="window.location.href = 'gameDetails?GameID=${m_game.getGameID()}'" style="cursor: pointer">
                                <div class="overview-pic">
                                    <img src="${m_game.getPoster()}" >
                                </div>
                                <div class="overview-info">
                                    <div class="game-name">${m_game.getName()}</div>
                                    <div class="price">${m_game.getPrice()}</div>
                                </div>
                            </div>
                        </c:forEach>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        </div>           
    </section>
    <footer>
        <%@include file="footer.jsp"%>
    </footer>

    <div class="not-login-modal">
        <div class="modal-container">
            <header class="modal-header">
                <icon class="ti-alert"></icon>
                <p style="color: red;">Buy failed!</p>
            </header>
            <div class="modal-content">
                You need to login first!
            </div>
            <div class="modal-footer">
                <button  class="login-button" onclick="window.location.href = 'login'">
                    Login
                </button>
                <button class="cancel-button">
                    Cancel
                </button>
            </div>
        </div>
    </div>

    <div class="buy-successful-modal">
        <div class="modal-container">
            <div class="modal-header">
                <icon class="ti-thumb-up" style="margin-right: 16px;"></icon>
                <p style="color: green;">Buy successfully!</p>
            </div>
            <div class="modal-content">
                <p>Thanks for trusting us! Please enjoy the game!</p>
            </div>
            <div class="modal-footer">
                <button class="ok-button ok-success" onclick="window.location.href = 'buygame?GameID=${game.getGameID()}'">
                    OK
                </button>
            </div>
        </div>
    </div>  

    <div class="buy-fail-modal">
        <div class="modal-container">
            <div class="modal-header">
                <icon class="ti-alert" style="margin-right: 16px;"></icon>
                <p style="color: red;">Buy failed!</p>
            </div>
            <div class="modal-content">
                <p>
                    Your account doesn't have enough money
                <icon class="ti-face-sad" ></icon>
                </p>
            </div>
            <div class="modal-footer">
                <button class="ok-button ok-fail">
                    OK
                </button>
                <p class="modal-to-payment">
                    Go to <a href="payment">payment?</a>
                </p>
            </div>
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
        const buyBtn = document.querySelector('.js-buy-btn');
        const notLoginModal = document.querySelector('.not-login-modal');
        const buyFailModal = document.querySelector('.buy-fail-modal');
        const buySuccessfulModal = document.querySelector('.buy-successful-modal');
        const closeModal = document.querySelector('.ok-button.ok-fail');
        const closeModal1 = document.querySelector('.cancel-button');
        function showNotLogin() {
            notLoginModal.classList.add('open');
        }
        function showFail() {
            buyFailModal.classList.add('open');
        }
        function showSuccessful() {
            buySuccessfulModal.classList.add('open');
        }
        function remove() {
            buyFailModal.classList.remove('open');
            notLoginModal.classList.remove('open');
        }
        <c:if test ="${(user==null)}">
        buyBtn.addEventListener('click', showNotLogin);
        </c:if>

        <c:if test ="${(user!=null)}">
            <c:if test ="${(user.getAccountBalance() < game.getPriceAfterDiscount())}">
        buyBtn.addEventListener('click', showFail);
            </c:if>
            <c:if test ="${(user.getAccountBalance() >= game.getPriceAfterDiscount())}">
        buyBtn.addEventListener('click', showSuccessful);
            </c:if>
        </c:if>
        closeModal1.addEventListener('click', remove);
        closeModal.addEventListener('click', remove);
    </script>
</body>
</html>
