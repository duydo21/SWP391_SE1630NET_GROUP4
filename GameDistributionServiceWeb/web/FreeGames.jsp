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
                    <div class="overflow-auto" style=" background-color: #a0a1b4; width: 20%; height: 700px;">
                        <h5>Category:</h5>
                        <form style="overflow: auto;">
                            <c:forEach items="${requestScope.cate}" var="c">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                    <label class="form-check-label" for="flexCheckDefault">
                                        ${c.categoryName}
                                    </label>    
                                </div>
                            </c:forEach>
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
