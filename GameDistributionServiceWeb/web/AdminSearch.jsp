<%-- 
    Document   : AdminSearch
    Created on : Nov 10, 2022, 10:38:52 AM
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
                color: white;
            }
            body{
                background-color: #333333;
            }
            table{
                background-color: #333333; 
            }
            table tr{
                color: white;
            }
        </style>
    </head>
    <body>
        <header>
            <jsp:include page="AdminHeader.jsp" />
        </header>
        <section>
            <div>
                <h1>Search result for (${requestScope.keyword})</h1>
            </div>
            <div class=" container" style="padding: 0; min-height: 800px;">
                <div class="row">
                    <c:if test="${requestScope.size == 0}">
                        <div style="width: 70%;">
                            Oof,sorry we cannot find any game that have that name!
                        </div>
                    </c:if>
                    <c:if test="${requestScope.size != 0}">
                        <div style="width: 70%;">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th scope="col" style="width: 20%">Title</th>
                                        <th scope="col"></th>
                                        <th scope="col" style="text-align: center" >Price</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${requestScope.gamesearch}" var="game">
                                    <tr onclick="window.location.href='agameDetails?GameID=${game.gameID}'">
                                        <th scope="col">${game.name}</th>
                                        <th scope="col"> 
                                            <div style="width:200px; height: 100px; display: table-cell" >
                                                <img src="${game.poster}" alt="alt" style="width: 100%;height: 100%" />
                                            </div>
                                        </th>
                                        <th scope="col" style="text-align: center">${game.price}</th>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>                    
                        </div>              
                    </c:if>
                    <div style=" background-color: #333333; width: 20%; height: 500px;">
                        <h5>Choose your price range</h5>
                        <form action="asearchfilter" method="post">
                            <div>
                                <input type="number" name="first" placeholder="0" value="0" style="width: 40%;display: inline"/> 
                                <p style="display: inline">-</p>
                                <input type="number" name="second" placeholder="0" value="0" style="width: 40%;display: inline"/>      
                                <button class="btn btn-outline-success" type="submit">Search</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>              
        <footer>
            <jsp:include page="footer.jsp"/>
        </footer>
    </body>
</html>
