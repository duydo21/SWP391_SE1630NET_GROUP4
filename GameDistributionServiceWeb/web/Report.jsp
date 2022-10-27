<%-- 
    Document   : Report
    Created on : Oct 25, 2022, 4:43:03 PM
    Author     : Strongest
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/Header.css"/>      
        <title>Reports</title>
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
        <header>
            <jsp:include page="AdminHeader.jsp"/>
        </header>
        <section>
            <table>
                <thead>
                    <tr>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.report}" var="r">
                        <tr>
                            <td>${r.userID.userID}</td>
                            <td>${r.gameID.gameID}</td>
                            <td>${r.content}</td>
                            <td>${r.date}</td>
                        </tr>                    
                    </c:forEach>

                </tbody>
            </table>
        </section>
        <footer>
            <jsp:include page="footer.jsp"/>
        </footer>
    </body>
</html>
