
<%-- 
    Document   : Profile
    Created on : Sep 28, 2022, 2:15:15 PM
    Author     : Strongest
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${sessionScope.account.username}'s profile</title>
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
            .item{
                background-color: #e8e8e8;
                margin: 10px;
                margin-bottom: 20px;
                border-radius: 10px;
            }

            .item:hover{
                background-color: #cccccc;
            }
            .container-game a{
                text-decoration: none;
                color: black;
            }
            .user-detail{

            }
        </style>
    </head>
    <body>
        <%
        Cookie[] cookies = request.getCookies();
            if (cookies != null) {
            for (Cookie cookie : cookies) {
        //work with cookies
            }
            }
        %>
        <header>
            <jsp:include page="Header.jsp" />
        </header>
        <section>
            <c:set var="i" scope="request" value="${here}"/>
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col col-lg-12 col-xl-12">
                        <div class="card">
                            //trường hợp khi vào đúng profile theo account  
                            <c:if test="${sessionScope.userlogin.isPrivate==false ||sessionScope.userlogin.isPrivate==true && cookie['userC'].getValue()==sessionScope.userlogin.username.username}"> 
                                <div class="rounded-top text-white d-flex flex-row" style="background-color: #000; height:200px; border-radius: 10px ; margin: 0">
                                    <div class="ms-4 mt-7 d-flex flex-column " style="width: 150px;">
                                        <img src="${i.avatar}"
                                             alt="Generic placeholder image" class="img-fluid img-thumbnail  mt-0 mb-2"
                                             style="width: 150px;height:150px ; z-index: 1">
                                        <button type="button" class="btn btn-outline-dark" onclick="window.location.href = 'editprofile?UserID=${sessionScope.userlogin.userID}';" data-mdb-ripple-color="dark"
                                                style="z-index: 1;">
                                            Edit profile
                                        </button>
                                    </div>

                                    <div class="user-detail ms-3" style="margin-top: 60px;">
                                        <h5>${i.nickname}</h5>
                                        <p>${i.country}</p>
                                        <p>${i.decription}</p>
                                    </div>

                                </div>
                            </c:if>
                            
                            //trường hợp khi vào sai profile theo account khi profile đó chưa private  
                            <c:if test="${sessionScope.userlogin.isPrivate==false && cookie['userC'].getValue()!=sessionScope.userlogin.username.username}"> 
                                <div class="rounded-top text-white d-flex flex-row" style="background-color: #000; height:200px; border-radius: 10px ; margin: 0">
                                    <div class="ms-4 mt-7 d-flex flex-column " style="width: 150px;">
                                        <img src="${i.avatar}"
                                             alt="Generic placeholder image" class="img-fluid img-thumbnail  mt-0 mb-2"
                                             style="width: 150px;height:150px ; z-index: 1">
                                    </div>
                                    <div class="user-detail ms-3" style="margin-top: 60px;">
                                        <h5>${i.nickname}</h5>
                                        <p>${i.country}</p>
                                        <p>${i.decription}</p>
                                    </div>

                                </div>
                            </c:if>
                            
                             //trường hợp khi vào sai profile theo account khi profile đó private  
                            <c:if test="${sessionScope.userlogin.isPrivate==true && cookie['userC'].getValue()!=sessionScope.userlogin.username.username}}"> 
                                <div class="rounded-top text-white d-flex flex-row" style="background-color: #000; height:200px; border-radius: 10px ; margin: 0">
                                    <div class="ms-4 mt-7 d-flex flex-column " style="width: 150px;">
                                        <img src="image/Default Avatar.jpg"
                                             alt="Generic placeholder image" class="img-fluid img-thumbnail  mt-0 mb-2"
                                             style="width: 150px; z-index: 1">
                                    </div>
                                    <div class="user-detail ms-3" style="margin-top: 60px;">
                                        <h5>${i.nickname}</h5>
                                    </div>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container-game">
                <div class="row justify-content-around" style="margin-bottom: 20px">
                    <!-- Cột trái -->
                    <div class="col-sm-8" style="box-shadow: 2px 6px 8px 0 rgba(22, 22, 26, 0.18);">
                        <h1>Game published</h1>
                        //Game rao bán của Profile đó
                        <c:forEach items="${requestScope.usergamebylist}" var="ug">
                            <div class="row item" onclick="window.location.href = 'gameDetails?GameID=${ug.gameID.gameID}'">
                                <div class="col item-image">
                                    <img src="${ug.gameID.poster}" width="200px" height="100%" >  
                                </div>  
                                <div class="col"style="text-align: left;">
                                    <h5> ${ug.gameID.name} </h5>
                                    <br>
                                    <p>  ${ug.gameID.price}</p>
                                </div>
                            </div>


                        </c:forEach>
                    </div>
                    <!-- Kết thúc cột trái -->
                    <div class="col-sm-1 " style="margin: auto"></div>
                    <!-- Cột phải -->
                    <div class="col-sm-3 " style="box-shadow: 2px 6px 8px 0 rgba(22, 22, 26, 0.18);">
                        <h2>Game Owned</h2>
                        //Game mà Profile đó đã dc mua vể
                        <div style="width: 100%; display: contents">
                            <c:forEach var="i" items="${requestScope.usergamebylist}">                        
                                <div class="item" style="width: 50%; margin: 0;">
                                    <div class="item-image" style="padding: 0">
                                        <a href="gameDetails?GameID=${i.gameID.gameID}">
                                            <img src="${i.gameID.poster}" width="100%" height="100%" >  
                                        </a>
                                    </div> 
                                </div>                           
                            </c:forEach>
                        </div>
                        <!-- Kết thúc cột phải -->
                    </div>
                </div>
        </section>
        <footer>
            <jsp:include page="footer.jsp"/>
        </footer>
    </body>
</html>

