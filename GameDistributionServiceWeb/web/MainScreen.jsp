<%-- 
    Document   : MainScreen
    Created on : Sep 22, 2022, 4:28:18 PM
    Author     : Strongest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wellcome to WHG</title>
        <link rel="stylesheet" href="css/MainScreen.css"/>
        <link rel="stylesheet" href="css/imageSlide.css"/>
        <script src="js/imageSlide.js"></script>
    </head>
    <body>
        <header>
            <nav>
                <div class="choicedropdown">
                    <p style="color:#ccc">Store</p>
                    <div class="dropdown-content">
                        <a href="#">New release</a>
                        <a href="#">Top seller</a>
                        <a href="#">Coming Soon</a>
                        <a href="#">Genre</a>
                    </div>
                </div>
                <div class="choice">
                    <a href="#">About</a>
                </div>
                <div class="choice">
                    <a href="#">Support</a>
                </div>
                <div class="choice">
                    <a href="login">Sign in</a>
                </div>
            </nav>        
        </header>
        <section>
            <!-- Slideshow container -->
            <div class="slideshow-container">

                <!-- Full-width images with number and caption text -->
                <div class="mySlides fade">
                    <div class="numbertext">1 / 3</div>
                    <img src="https://cdn.akamai.steamstatic.com/steam/apps/1313140/capsule_616x353.jpg?t=1662741507" style="width:100%">
                </div>

                <div class="mySlides fade">
                    <div class="numbertext">2 / 3</div>
                    <img src="https://cdn.akamai.steamstatic.com/steam/apps/250900/capsule_616x353.jpg?t=1617174663" style="width:100%">
                </div>

                <div class="mySlides fade">
                    <div class="numbertext">3 / 3</div>
                    <img src="https://cdn.cloudflare.steamstatic.com/steam/apps/268910/capsule_616x353.jpg?t=1661955091" style="width:100%">
                </div>

                <!-- Next and previous buttons -->
                <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                <a class="next" onclick="plusSlides(1)">&#10095;</a>
            </div>
            <br>

            <!-- The dots/circles -->
            <div style="text-align:center">
                <span class="dot" onclick="currentSlide(1)"></span>
                <span class="dot" onclick="currentSlide(2)"></span>
                <span class="dot" onclick="currentSlide(3)"></span>
            </div>            
        </section>
    </body>
</html>
