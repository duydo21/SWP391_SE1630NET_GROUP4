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
        </style>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-secondary">
                <a class="navbar-brand" href="mainscreen"><img src="image/logo.png" alt="alt" class="navbar-brand" style="height: 100px"/></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Store
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">New Release</a>
                                <a class="dropdown-item" href="#">Deals</a>
                                <a class="dropdown-item" href="#">Best Selling</a>
                                <a class="dropdown-item" href="#">Free to play</a>
                                <a class="dropdown-item" href="#">Coming Soon</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">Genre</a>
                                <a class="dropdown-item" href="#">Deals</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="about">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Support</a>
                        </li>
                        <c:if test="${(sessionScope.acc == null)}">
                            <li class="nav-item">
                                <a class="nav-link" href="login">Sign in</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="register">Sign up</a>
                            </li>                            
                        </c:if>
                        <c:if test="${(sessionScope.acc != null)}">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Welcome ${sessionScope.userlogin.nickname}
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="profile?UserID=${sessionScope.userlogin.userID}">Profile</a>
                                    <a class="dropdown-item" href="#">Sign out</a>
                                    <a class="dropdown-item" href="#">Payment</a>
                                </div>
                            </li>                          
                        </c:if>                 
                    </ul>
                    <form class="d-flex search">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </header>
        <section>
            <c:set var="i" scope="request" value="${here}"/>
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col col-lg-9 col-xl-9">
                        <div class="card">
                            <div class="rounded-top text-white d-flex flex-row" style="background-color: #000; height:200px;">
                                <div class="ms-4 mt-5 d-flex flex-column" style="width: 150px;">
                                    <img src="${i.avatar}"
                                         alt="Generic placeholder image" class="img-fluid img-thumbnail mt-4 mb-2"
                                         style="width: 150px; z-index: 1">
                                    <button type="button" class="btn btn-outline-dark" data-mdb-ripple-color="dark"
                                            style="z-index: 1;">
                                        Edit profile
                                    </button>                                        
                                </div>
                                <div class="ms-3" style="margin-top: 130px;">
                                    <h5>${i.nickname}</h5>
                                    <p>${i.country}k</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
