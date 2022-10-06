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
            <jsp:include page="Header.jsp" />
        </header>
        <section>
            <div>
                <h1>${requestScope.text}</h1>
            </div>
            <div class=" container" style="padding: 0">
                <div class="row">
                    <p>there are ${requestScope.size} result</p>
                    <div style="width: 70%;">
                        <table class="table table-secondary table-hover">
                            <thead>
                                <tr>
                                    <th scope="col" style="width: 20%">Title</th>
                                    <th scope="col"></th>
                                    <th scope="col" style="text-align: center" >Price</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.getgames}" var="game">
                                    <tr onclick="window.location.href = 'game?gameID=${game.gameID}'">
                                        <th scope="col">${game.name}</th>
                                        <th scope="col"> 
                                            <div style="width:200px; height: 100px; display: table-cell" >
                                                <img src="${game.poster}" alt="alt" style="width: 100%;height: 100%"/>
                                            </div>
                                        </th>
                                        <th scope="col" style="text-align: center">
                                                    ${game.price}
                                        </th>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>                    
                    </div>
                    <div style=" background-color: #a0a1b4; width: 20%; height: 500px;">
                        <form action="searchfilter" method="post">

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
