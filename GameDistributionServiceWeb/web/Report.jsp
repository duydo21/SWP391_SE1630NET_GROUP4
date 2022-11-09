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
            <table class=" table table-hover">
                <thead style="color:white">
                    <tr>
                        <td>User</td>
                        <td>Game name</td>
                        <td>Description</td>
                        <td>date</td>
                    </tr>  
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.report}" var="r">
                        <tr style="color:white" class="trigger">
                            <td>${r.userID.username.username}</td>
                            <td>${r.gameID.name}</td>
                            <td>${r.content}</td>
                            <td>${r.date}</td>
                        </tr>                    
                    </c:forEach>
                </tbody>
            </table>
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

        </section>
        <script>
            //js for buy btn
            const Btn = document.querySelector('.trigger');
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
        <footer>
            <jsp:include page="footer.jsp"/>
        </footer>
    </body>
</html>
