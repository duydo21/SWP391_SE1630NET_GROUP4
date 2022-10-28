<%-- 
    Document   : AdminBestSelling
    Created on : Oct 25, 2022, 10:41:35 AM
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
        <title>Best selling</title>
        <style>
            section{
                width: 70%;
                margin: 0 auto;
                min-height: 900px;
            }
            body{
                background-color: #333333;
            }
            table{
                width: 100%;
            }
        </style>
    </head>
    <body>
        <header>
            <jsp:include page="AdminHeader.jsp"/>
        </header>
        <section>
            <h2 style="color: white">${requestScope.title}</h2>
            <br>
            <div class="container">
                <div style="width:100%">
                    <table class="table table-hover">
                        <thead style="color:white">
                            <tr>
                                <td>ID</td>
                                <td style="width:50%">Title</td>
                                <td>Price</td>
                                <td>Release date</td>
                                <td>Download</td>
                            </tr>
                        </thead>
                        <tbody style="color:white">
                            <c:forEach items="${requestScope.getgames}" var="g">
                                <tr style="height: 5%;" onclick="window.location.href='agameDetails?GameID=${g.gameID}'">
                                    <td>${g.gameID}</td>
                                    <td>                                       
                                        <a>
                                            <img src="${g.poster}" alt="" style="width: 10%; height: 100%">
                                        </a>
                                        <span>${g.name}</span></td>
                                    <td>${g.price}</td>
                                    <td>${g.date}</td>
                                    <td>${g.download}</td>
                                </tr>                          
                            </c:forEach>
                        </tbody>
                    </table>    
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                                <li class="page-item"><a class="page-link" href="${requestScope.link}?page=${i}">${i}</a></li>
                                </c:forEach>
                        </ul>
                    </nav>
                </div>
                
            </div>
        </section>
        <footer>
            <jsp:include page="footer.jsp"/>
        </footer>
    </body>
</html>
