<%-- 
    Document   : gamesOnCategory
    Created on : Oct 19, 2022, 9:30:46 PM
    Author     : Strongest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/Header.css"/>
        <title>Genre Page</title>
        <style>
            section{
                width: 70%;
                margin: 0 auto;
                display: block;
                min-height: 900px;
            }
            .crap{
                -webkit-filter: brightness(100%);
                box-shadow: 2px 6px 8px 0 rgba(22, 22, 26, 0.18);
                color: white;
                opacity: 1;
                width: 100%;
                height: 150px;
                margin-top: 35px;
                border-radius: 15px;
            }
            .crap:last-child{
                margin-bottom: 35px;
            }
            .crap:hover{
                -webkit-filter: brightness(70%);
                cursor: pointer;
                background-color: #b3b3b3;
            }

            h3{
                color: black;
                margin: 0 auto;
            }
        </style>
    </head>
    <body>
        <header>
            <jsp:include page="Header.jsp"/>
        </header>
        <section>
            <c:if test="${requestScope.size ==0}">
                <h2>Oof! we dont have any games like that!</h2>
            </c:if>
            <h1>Discover the ${requestScope.name} genre library</h1> <br>
            <div>
                <c:forEach items="${requestScope.games}" var="g">
                    <div class="crap" onclick="window.location.href = 'gameDetails?GameID=${g.gameID.gameID}'" style="display: table">
                        <div style="display: table-cell;vertical-align: middle;">
                            <img src="${g.gameID.poster}" alt="alt" style="width: 40%;height:100%;display: table-cell;"/>
                        </div> 
                        <div style="display: table-cell; vertical-align: middle; text-align: right;">
                            <h3>${g.gameID.name}</h3>
                            <h3>${g.gameID.price}</h3> 
                        </div>
                    </div>
                </c:forEach>
            </div>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                        <li class="page-item"><a class="page-link" href="cate?genre=${requestScope.id}&page=${i}">${i}</a></li>
                        </c:forEach>
                </ul>
            </nav>
        </section>
        <footer>
            <jsp:include page="footer.jsp"/>
        </footer>
    </body>
</html>
