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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <style>
            section{
                width: 70%;
                margin: 0 auto;

            }
            body{
                background-color: #d9d9d9;
            }
            .text {
                position: relative;
            }

            /* Make the image responsive */
            .text img {
                width: 100%;
                height: auto;
            }

            /* Style the button and place it in the middle of the container/image */
            .text .btn {
                position: absolute;
                top: -130%;
                left: 82%;
                transform: translate(-50%, -50%);
                -ms-transform: translate(-50%, -50%);
                background-color: #555;
                color: white;
                border: none;
                cursor: pointer;
                border-radius: 5px;
                background-color: #b721ff;
                border: none;
            }
            .navbar-expand-lg{
                padding-left:15%;
                padding-right:15%;
            }
            .search{
                margin-left: auto;
            }
            .d-flex button{
                background-color: #a0a1b4;


            }
            .col-sm-8{
                border-radius: 20px;


            }

            .col-sm-3{
                border-radius: 20px;

            }

            .item{
                margin: 10px;
                display: inline;


            }
            .item-detail{
                background-color: #a5a5a5;
                margin-top: 10px;
                border-radius: 10px;
            }
            .item-image {
                background-color: #a5a5a5;
                border-radius: 10px;
            }
            .item-image img{
                border-radius: 10px;
            }
            h1{
                text-align: center;

            }
            h2{
                text-align: center;
            }
            
            .user-decription{
                display: inline;
                margin-left: 50px;
                margin-top: 60px;
            }
        </style>
    </head>
    <body>
        <header>
            <jsp:include page="Header.jsp" />
        </header>
        <section>
            <c:set var="i" scope="request" value="${here}"/>
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col col-lg-12 col-xl-12">
                        <div class="card">
                            <div class="rounded-top text-white d-flex flex-row" style="background-color: #000; height:200px; border-radius: 10px">
                                <div class="ms-4 mt-7 d-flex flex-column " style="width: 150px;">
                                    <img src="${i.avatar}"
                                         alt="Generic placeholder image" class="img-fluid img-thumbnail  mt-0 mb-2"
                                         style="width: 150px; z-index: 1">
                                    <button type="button" class="btn btn-outline-dark" onclick="window.location.href = '/GameDistributionServiceWeb/editprofile?UserID=${sessionScope.userlogin.userID}';" data-mdb-ripple-color="dark"
                                            style="z-index: 1;">
                                        Edit profile
                                    </button>                                        
                                </div>
                                <div class="ms-3" style="margin-top: 60px;">
                                    <h5>${i.nickname}</h5>
                                    <p>${i.country}</p>
                                </div>
                                <div class="user-decription">
                                    Decription:
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container-game">
                <div class="row justify-content-around" style="margin-bottom: 20px">
                    <!-- Cột trái -->
                    <div class="col-sm-8" style="border: 5px ridge #a5a5a5">
                        <h1>Game To Buy</h1>
                        <c:forEach begin="0" end="8">
                            <div class="row item" >
                                <div class="item-image ">
                                    <img src="image/Default Avatar.jpg" width="300" height="100" >  
                                </div>  
                                <div class="item-detail ">
                                    <a  href="#">name</a>
                                    <p>Description: </p>  
                                    <p>Discount: </p> 
                                </div>
                            </div>  
                        </c:forEach>
                    </div>
                    <!-- Kết thúc cột trái -->
                    <div class="col-sm-1 " style="margin: auto"></div>
                    <!-- Cột phải -->
                    <div class="col-sm-3 " style="border: 5px ridge #a5a5a5">
                        <h2>Game Owned</h2>
                        <c:forEach begin="0" end="8">
                            <div class="row item" >
                                <div class="item-image ">
                                    <a href="#">
                                        <img src="image/Default Avatar.jpg" width="150" height="60" >  
                                    </a>
                                </div>  
                                <div class="item-detail ">
                                    <a  href="#">name</a>                                   
                                </div>
                            </div>  
                        </c:forEach>
                    </div>
                    <!-- Kết thúc cột phải -->

                </div>
            </div>
        </section>
        <footer class="bg-light text-center text-lg-start">
            <!-- Copyright -->
            <div class="text-center p-3" style="background-color: #6c757d;">
                This website is created by group 4 SWP391.<br>
                Pham Tien Manh<br>
                Do Ngoc Duy<br>
                Nguyen Hoang Anh<br>
                Dang Minh Hieu <br>
                Vu Hoang Minh Quan<br>
                <a class="text-white" href="https://github.com/traitimtrongvang21/SWP-Project">Github</a>
            </div>
            <!-- Copyright -->
        </footer>
    </body>
</html>
