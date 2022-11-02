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
                width: 60%;
                max-width: calc(100% - 32px);
                min-height: 200px;
                height: 60%;
                animation: modalFadeIn ease 0.3s;
                overflow: auto;
            }

            .modal-content{
                position: relative;
            }
            .x{
                right: 2%;
                position: absolute;
                top: 10%;
                font-size: 50px;
            }
            .x:hover{
                cursor: pointer;
            }

            .left{
                width: 50%;
                height: fit-content;
            }
            .right{
                width: 50%;
                height: fit-content;
            }
            
            .left .row:hover{
                cursor: pointer;
                -webkit-filter: brightness(70%);
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
                        <div class="modal" id="myModal_${u.userID}">
                            <div class="modal-container">
                                <div class="modal-content">
                                    <div class="top" style="height:120px; background-color: black; display: flex">
                                        <div style="margin:1%">
                                            <img src="${u.avatar}"style="height:100px; margin: 1%" alt="alt"/>
                                        </div>
                                        <div style="color: white; margin: 1%">
                                            <p>${u.nickname}</p>
                                            <p>${u.country}</p>                               
                                        </div>
                                        <div style="color: white; margin: 1%">
                                            <p>${u.decription}</p>
                                        </div>
                                        <span class="x" onclick="Hide('${u.userID}');" style="color:white">&times;</span>
                                    </div>
                                    <div style="display: flex">
                                        <div class="left">
                                            <h3>Game published</h3>
                                            <%int j = 0;%>
                                            <c:forEach items="${requestScope.dev}" var="g">
                                                <c:if test="${(g.userID.userID == u.userID)}">
                                                    <div class="row" style="margin-bottom:2px;width: 100%" onclick="window.location.href='agameDetails?GameID=${g.gameID.gameID}'">
                                                        <div class="shadow-sm">
                                                            <img src="${g.gameID.poster}" alt="alt" style="height:100px;"/>
                                                            <span>${g.gameID.name}</span>
                                                            <span>${g.gameID.price}</span>
                                                        </div>
                                                    </div>
                                                    <% j++; %>
                                                </c:if>
                                            </c:forEach>
                                            <% if(j==0){%>
                                            <div class="row">
                                                <div class="shadow-sm">
                                                    <span>This user have 0 games published</span>
                                                </div>
                                            </div>
                                            <%}%>
                                        </div>
                                        <div class="right">
                                            <h3>Game Bought</h3>
                                            <%int i = 0;%>
                                            <c:forEach items="${requestScope.buy}" var="b">
                                                <c:if test="${(b.userID.userID == u.userID)}">
                                                    <div class="row" style="height: 5%">
                                                        <div class="col shadow-sm">
                                                            <img src="${b.gameID.poster}" alt="alt" style="height:100%" />      
                                                        </div>      
                                                    </div>
                                                    <% i++; %>
                                                </c:if>
                                            </c:forEach>
                                            <% if(i==0){%>
                                            <div class="row">
                                                <div class="col">
                                                    <span>This user didnt buy any games</span>
                                                </div>
                                            </div>
                                            <%}%>
                                        </div>
                                    </div>
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
            function Hide(id) {
                var modelDiv = document.getElementById('myModal_' + id);
                modelDiv.style.display = 'none';
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
