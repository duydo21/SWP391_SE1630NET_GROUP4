<%-- 
    Document   : About
    Created on : Sep 24, 2022, 2:47:17 PM
    Author     : Strongest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About WHG</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/Header.css"/>        
    </head>
    <body>
        <header>
            <jsp:include page="Header.jsp"/>
        </header>
        <section>
            <br><br><br>
            <div class="container ">
                <div class="row">
                    <div class="col">
                        <img src="image/logo.png" alt="alt" style="width: 50%"/>
                    </div>
                    <div class="col-6">
                        <p class="h1">WHG is a ultimate platform for playing, discuss,creating and selling games.</p>
                    </div>
                </div>                
            </div>
            <br><br><br>
            <div class="container col-6">
                <p class="font-weight-bold h2 text-center">Access games instantly</p>
                <p class="h5 text-center"> With nearly 30,000 games from AAA to indie and everything in-between. Enjoy exclusive deals, automatic game updates, and many other great perks</p>
            </div>
            <br><br><br>
            <div class="container col-6">
                <p class="font-weight-bold h2 text-center">Release your Game</p>
                <p class="h5 text-center">WHG platform are heavily support for indie developers to publish and get the most out of their games to this platform</p>
            </div>
            <br><br><br>
            <div class="container col-6">
                <p class="font-weight-bold h2 text-center">And so much more...</p>
                <p class="h5 text-center">Track player count, read reviews, and some of the things we still not get it from Steam</p>
            </div>
            <br><br><br>
        </section>
        <footer>
            <jsp:include page="footer.jsp"/>
        </footer>
    </body>
</html>
