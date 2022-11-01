<%-- 
    Document   : newjsp
    Created on : Oct 29, 2022, 11:55:31 PM
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
        <title>User Management</title>
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
            #modal{
                position: fixed;
                top: 0;
                left: 0;
                right:0;
                bottom: 0;
                display: none;
                align-items: center;
                justify-content: center;
                background-color: rgba(0, 0, 0, 0.3);
            }
            .modal-container{
                margin: 0 auto;
                margin-top: 12%;
                background-color: #fff;
                width: 600px;
                max-width: calc(100% - 32px);
                min-height: 200px;
                height: 60%;
                animation: modalFadeIn ease 0.3s;
            }
        </style>
    </head>
    <body>
        <header>
            <jsp:include page="AdminHeader.jsp"/>
        </header>
        <section>
            <div class="container">
                <br>
                <h1 style="color: white; text-align: center">All users registered on this site</h1>
                <br>
                <table class="table table-hover">
                    <thead style="color:white">
                        <tr>
                            <td>userID</td>
                            <td>avatar</td>
                            <td>nickname</td>
                            <td>country</td>
                            <td>email</td>
                            <td>isDev</td>
                            <td>Date joined</td>
                        </tr>                        
                    </thead>
                    <tbody style="color:white">
                        <c:forEach items="${requestScope.user}" var="u">
                            <tr onclick="Display('${u.userID}')" >
                                <td>${u.userID}</td>
                                <td><img src="${u.avatar}"style="height:100px" alt="alt"/></td>
                                <td>${u.nickname}</td>
                                <td>${u.country}</td>
                                <td>${u.email}</td>                
                                <td>${u.isDev}</td>
                                <td>${u.date}</td>
                            </tr>
                        <div class="modal" id="myModal_' + "${u.userID}" + '">
                            <div class="modal-container">
                                <div class="modal-header">
                                    <p style="color: red; font-size: 30px; font-weight: 50px">${u.userID}</p>
                                    <span class="close" style="font-size: 50px">&times;</span>
                                </div>
                                <div class="modal-content">
                                    <textarea class="form-control" id="text" name="context" rows="6"></textarea>
                                </div>
                                <div class="modal-footer">
                                    <button class="submit-button" type="sumbit">
                                        Submit and Delete
                                    </button>
                                </div>
                            </div>
                        </div>
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
        </section>
        <script>
            //js for buy btn
            const closeModal1 = document.querySelector('.close');
            function Hide() {
                Modal.style.display = 'none';
            }

            function Display(id) {
                var modelDiv = document.getElementById('myModal_' + id);
                modelDiv.style.display = 'block';
            }
            closeModal1.addEventListener('click', Hide);
        </script>
        <footer>
            <jsp:include page="footer.jsp"/>
        </footer>
    </body>
</html>
