<%-- 
    Document   : AllComments
    Created on : Oct 30, 2022, 10:55:42 PM
    Author     : ACER
--%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Collections"%>
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
        <!--<link rel="stylesheet" href="css/game-details.css">-->
        <script src="https://kit.fontawesome.com/f92d1eca7b.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/fonts/themify-icons/themify-icons.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/Header.css"/>
        <style>
            *{
                padding: 0;
                margin: 0;
                box-sizing: border-box;
            }
            html{
                font-family: Arial, Helvetica, sans-serif;
            }
            section{
                width: 70%;
                margin: 0 auto;
            }
            .clear{
                clear: both;
            }
            .cmt-content .cmter, .cmt-content .cmter-content{
                float: left;
                text-align: center;
            }
            .cmt-action button{
                margin: 5px;
                padding: 2px 4px;
                float: right;
            }
            button:hover{
                background-color: black;
                color: white;
            }
            .show-cmt{
                display: block !important;
            }
        </style>
    </head>
    <body>
        <c:set var="game" value = "${requestScope.game}"/>
        <c:set var="userVote" value = "${requestScope.userVote}"/>
        <c:set var="user" value = "${sessionScope.userlogin}"/>
        <c:set var="cmtList" value = "${requestScope.cmtList}"/>
        <c:set var="rateList" value = "${requestScope.rateList}"/>
        <c:set var="isCmt" value="${requestScope.isCmt}"/>
        <c:set var="usercomment" value="${requestScope.usercomment}"/>
        <c:set var="sort" value="${requestScope.sort}"/>
        <c:set var="filter" value="${requestScope.filter}"/>
        <header>
            <jsp:include page="Header.jsp" />
        </header>
        <section>
            <!--ten game-->
            <div id="game-name" style="text-align: center; font-size: 40px;">
                ${game.getName()}<br>
                <img src="${game.getPoster()}"/>
            </div>

            <!--user comment(neu user da dang nhap)-->
            <c:if test="${isCmt}">
                <div class="user-cmt">
                    <p style="font-size: 30px">Your comment:</p>
                    <div class="cmt-detail">
                        <div class="cmt-vote" style="background-color: #006666;">
                            <c:if test="${userVote==0}">
                                <icon class="fa-solid fa-thumbs-down" style="font-size: 30px;"></icon>Not recommend (Posted ${usercomment.getDate()})
                                </c:if>
                                <c:if test="${userVote==1}">
                                <icon class="fa-solid fa-thumbs-up" style="font-size: 30px;"></icon>Recommend (Posted ${usercomment.getDate()})
                                </c:if>
                        </div>
                        <div class="cmt-content" style="background-color: #009999">
                            <div class="cmter" style=" width: 20%">
                                <img src="${user.getAvatar()}" style="width:35%;transform: translateY(10px)"/>
                                <p style="transform: translateY(10px)">${user.getUsername().getUsername()}</p>
                            </div>
                            <div class="cmter-content" style="width: 80%; transform: translateY(5px)">${usercomment.getContent()}</div>
                            <div class="clear"></div>
                        </div>
                    </div>
                    <div class="cmt-action">
                        <button class="js-edit-btn">EDIT</button>
                        <button class="js-del-btn">DELETE</button>
                        <div class="clear"></div>
                    </div>
                </div>
            </c:if>
            <!--list comment-->
            <% String gameID_raw = request.getParameter("GameID");%>
            <% int gameID = Integer.parseInt(gameID_raw);  %>
            <%!IGameDAO gameDao = new GameDAO();%>
            <%!List<UserGameComment> cmtList = new ArrayList<>();%>
            <%!List<UserGameRate> rateList1 = new ArrayList<>();%>
            <% cmtList = gameDao.getGameCommentByGameID(gameID); %>
            <%! int cmt_size = cmtList.size(); %>
            <%for(UserGameComment cmt : cmtList){
                rateList1.add(new UserGameRate( cmt.getUserID(), 
                cmt.getGameID(),
                gameDao.getUserVoteOfAGame(cmt.getUserID(), cmt.getGameID()
                )));
            }%>
            <c:if test="${filter.equals('1')}">
                <% for(int a=0; a<cmtList.size(); a++){ 
                    if(rateList1.get(a).getRate()==0){
                        cmtList.remove(a);
                        rateList1.remove(a);
                        a--;
                    }
                }%>

            </c:if>
            <c:if test="${filter.equals('2')}">
                <% for(int a=0; a<cmtList.size(); a++){ 
                    if(rateList1.get(a).getRate()==1){
                        cmtList.remove(a);
                        rateList1.remove(a);
                        a--;
                    }
                }%>
            </c:if>
            <c:if test="${sort.equals('1')}">
                <% Collections.reverse(cmtList); %>
                <% Collections.reverse(rateList1); %>
            </c:if>
            <div class="cmt-list">
                <p style="font-size: 30px">List comment:</p>
                <form>
                    <input type="hidden" name="GameID" value="${game.getGameID()}">
                    <label>Show: </label>
                    <select name="sort">
                        <c:if test="${sort.equals('0')}">
                            <option value="0" selected>Latest</option>
                            <option value="1">Oldest</option>
                        </c:if>
                        <c:if test="${sort.equals('1')}">
                            <option value="0">Latest</option>
                            <option value="1" selected>Oldest</option>
                        </c:if>
                    </select>
                    <select name="filter">
                        <c:if test="${filter.equals('0')}">
                            <option value="0" selected>All</option>
                            <option value="1">Positive only</option>
                            <option value="2">Negative only</option>
                        </c:if>
                        <c:if test="${filter.equals('1')}">
                            <option value="0">All</option>
                            <option value="1" selected>Positive only</option>
                            <option value="2">Negative only</option>
                        </c:if>
                        <c:if test="${filter.equals('2')}">
                            <option value="0">All</option>
                            <option value="1">Positive only</option>
                            <option value="2" selected>Negative only</option>
                        </c:if>
                    </select>
                    <button type="submit">Filter</button>
                </form>
                <div class="cmt-list-container">
                    <% for(int j=cmtList.size()-1;j>=0;j--){ %>
                    <div class="detail-cmt" style="margin-bottom: 7px; display: none">
                        <div class="cmt-vote" style="background-color: #006666; line-height: 32px;">
                            <% if(rateList1.get(j).getRate()==0){ %>
                            <icon class="fa-solid fa-thumbs-down" style="font-size: 30px"></icon>Not recommend (Posted <%= cmtList.get(j).getDate() %>)
                                <% }else{ %>
                            <icon class="fa-solid fa-thumbs-up" style="font-size: 30px"></icon>Recommend (Posted <%= cmtList.get(j).getDate() %>)
                                <% } %>
                        </div>
                        <div class="cmt-content" style="background-color: #009999">
                            <div class="cmter" style="width: 20%">
                                <img src="<%= cmtList.get(j).getUserID().getAvatar() %>" style="width:35%; transform: translateY(10px)"/>
                                <p style="transform: translateY(10px)"><%= cmtList.get(j).getUserID().getUsername().getUsername() %></p>
                            </div>
                            <div class="cmter-content" style="width: 80%; transform: translateY(5px)"><%= cmtList.get(j).getContent() %></div>
                            <div class="clear"></div>
                        </div>
                    </div>
                    <% } %>
                </div>
                <% cmtList.clear(); rateList1.clear(); %>
            </div>
        </section>

        <div class="js-del-modal">
            <div class="modal-container">
                <div class="modal-header">
                    <icon class="ti-alert" style="font-size: 40px; transform: translateX(370px);"></icon>
                </div>
                <div class="modal-content">
                    <p>Do you want to delete this comment?</p>
                </div>
                <div class="modal-footer">
                    <button style="transform: translateX(-370px)" onclick="window.location.href = 'managecomment?GameID=${game.getGameID()}&action=1'">Yes</button>
                    <button class="cancel-btn" style="transform: translateX(-250px)">Cancel</button>
                </div>
            </div>
        </div>

        <div class="js-edit-modal">
            <div class="modal-container">
                <div class="modal-header">
                    <p style="font-size: 40px; transform: translateX(250px);">EDIT COMMENT</p>
                </div>
                <form action="managecomment">
                    <div class="modal-content">
                        <div style="width: 90%;">
                            <textarea name="edit-cmt" rows="3" style="width: 100%; transform: translateX(40px)">${usercomment.getContent()}</textarea> 
                            <input type="hidden" name="GameID" value="${game.getGameID()}">
                            <input type="hidden" name="action" value="2">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" style="transform: translateX(-370px)" >Save</button>
                        <button class="cancel-btn1" style="transform: translateX(-230px)">Cancel</button>
                    </div>
                </form>
            </div>
        </div>

        <style>
            .modal-footer button{
                width: 70px;
                padding: 5px;
                margin-bottom: 10px;
                margin-top: 10px;
            }
            .js-edit-modal{
                z-index: 2;
                display: none;
                position: fixed;
                top:0;
                left:0;
                right:0;
                bottom: 0;
                background-color: rgba(0, 0, 0, 0.3);
                justify-content: center;
                align-items: center;
            }
            .js-del-modal{
                display: none;
                position: fixed;
                top:0;
                left:0;
                right:0;
                bottom: 0;
                background-color: rgba(0, 0, 0, 0.3);
            }
            .modal-container{
                text-align: center;
                background-color: whitesmoke;
                width: 50%;
                margin:auto;
            }
            .open{
                display: flex !important;
            }
        </style>
        <footer>
            <%--<%@include file="footer.jsp"%>--%>
        </footer>

        <script>
            const editBtn = document.querySelector('.js-edit-btn');
            const deleteBtn = document.querySelector('.js-del-btn');
            const editModal = document.querySelector('.js-edit-modal');
            const deleteModal = document.querySelector('.js-del-modal');
            const closeModal = document.querySelector('.cancel-btn');
            const closeModal1 = document.querySelector('.cancel-btn1');

            function close() {
                deleteModal.classList.remove('open');
                editModal.classList.remove('open');
            }
            function showEdit() {
                editModal.classList.add('open');
            }
            function showDel() {
                deleteModal.classList.add('open');
            }
            editBtn.addEventListener('click', showEdit);
            deleteBtn.addEventListener('click', showDel);
            closeModal.addEventListener('click', close);
            closeModal1.addEventListener('click', close);
        </script>

        <script>
            const container = document.querySelector('.cmt-list-container');
            const cmts = document.querySelectorAll('.detail-cmt');
            let i = 0;

            function loadComments(num_cmt = 5) {
                let j = 0;
                while (j < num_cmt) {
                    cmts[i].classList.add('show-cmt');
                    i++;
                    j++;
            }
            }

            loadComments();

            window.addEventListener('scroll', () => {
                console.log(window.scrollY); //scrolled from top
                console.log(window.innerHeight); //visible part of screen
                if (window.scrollY + window.innerHeight >= document.documentElement.scrollHeight) {
                    loadComments();
                }
            });
        </script>
    </body>
</html>
