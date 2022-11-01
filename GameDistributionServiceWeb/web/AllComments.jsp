<%-- 
    Document   : AllComments
    Created on : Oct 30, 2022, 10:55:42 PM
    Author     : ACER
--%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import ="model.UserGameRate"%>
<%@ page import ="model.UserGameComment"%>
<%@ page import ="dal.GameDAO"%>
<%@ page import ="dal.DAOInterface.IGameDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${game.getName()} comments</title>
        <link rel="stylesheet" href="css/game-details.css">
        <script src="https://kit.fontawesome.com/f92d1eca7b.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/fonts/themify-icons/themify-icons.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/Header.css"/>

    </head>
    <body>
        <c:set var="game" value = "${requestScope.game}"/>
        <c:set var="isBought" value = "${requestScope.isBought}"/>
        <c:set var="user" value = "${sessionScope.userlogin}"/>
        <c:set var="userVote" value = "${requestScope.userVote}"/>
        <c:set var="cmtList" value = "${requestScope.cmtList}"/>
        <c:set var="rateList" value = "${requestScope.rateList}"/>
        <c:set var="isCmt" value="${requestScope.isCmt}"/>
        <header>
            <jsp:include page="Header.jsp" />
        </header>
        <section>
            <%! int a=0;%>
            <% a=0; %>
            <%!IGameDAO gameDao = new GameDAO();%>
            <%!List<UserGameComment> cmtList = new ArrayList<>();%>
            <%!List<UserGameRate> rateList1 = new ArrayList<>();%>
            <% cmtList = gameDao.getGameCommentByGameID(1); %>
            <%for(UserGameComment cmt : cmtList){
                rateList1.add(new UserGameRate( cmt.getUserID(), 
                cmt.getGameID(),
                gameDao.getUserVoteOfAGame(cmt.getUserID(), cmt.getGameID()
                )));
            }%>
            <div class="comment-container">
                <% for(int j=cmtList.size()-1;j>=0;j--){ %>
                <% a++; %>
                <div class="detail-cmt" >
                    <div class="cmt-vote" style="background-color: #006666; line-height: 32px;">
                        <% if(rateList1.get(j).getRate()==0){ %>
                        <icon class="fa-solid fa-thumbs-down" style="padding: 2px 10px 0 10px"></icon>Not recommend
                            <% }else{ %>
                        <icon class="fa-solid fa-thumbs-up" style="padding: 2px 10px 0 10px"></icon>Recommend
                            <% } %>
                    </div>
                    <div class="cmt-content" style="background-color: #009999">
                        <div class="cmter" style="width: 20%">
                            <img src="<%= cmtList.get(j).getUserID().getAvatar() %>" style="width:35%"/>
                            <p><%= cmtList.get(j).getUserID().getUsername().getUsername() %></p>
                        </div>
                        <div class="cmter-content" style="width: 80%"><%= cmtList.get(j).getContent() %></div>
                        <div class="clear"></div>
                    </div>
                </div>
                <% if(a==3){break;} %>
                <% } %>
            </div>
        </section>
        <footer>
            <%@include file="footer.jsp"%>
        </footer>
    </body>
</html>
