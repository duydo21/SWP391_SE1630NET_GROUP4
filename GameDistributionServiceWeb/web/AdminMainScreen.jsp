<%-- 
    Document   : AdminMainScreen
    Created on : Oct 24, 2022, 11:27:01 AM
    Author     : Strongest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to WHG</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
        <!--        splide framework-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@splidejs/splide@3.6.12/dist/css/splide.min.css"> 
        <script src="https://cdn.jsdelivr.net/npm/@splidejs/splide@3.6.12/dist/js/splide.min.js"></script>        
        <link rel="stylesheet" href="css/Header.css"/>
        <style>
            body{
                background-color: #333333;
            }
            section{
                width: 70%;
                margin: 0 auto;
                min-height: 800px;

            }
            .card:hover{
                -webkit-filter: brightness(90%);
                cursor: pointer;
                background-color: #cccccc;
            }
            .text .btn:hover{
                -webkit-filter: brightness(90%);
            }
            .container{
                margin-right: auto;
                margin-left: auto;
                text-align: center;

            }
            .header-title{
                background: linear-gradient(-70deg,#a2facf,#64acff);
                -webkit-background-clip: text;
                -webkit-text-fill-color: transparent;
            }
            table{
                background-color: var(--muted-bg-color);
            }
            .number{
                font-weight: 700;
                font-size: 36px;
                line-height: 1;
                text-decoration: none;
                color: inherit;
            }
            .db div{
                margin-left: 2.5%;
                margin-right: 2.5%;
            }
        </style>
    </head>
    <body>
        <header>
            <jsp:include page="AdminHeader.jsp"/>
        </header>
        <section>
            <div class=" container">
                <h1 class="header-title">Database of everything on WHG.</h1>
                <p style="color: white">you have better insight into the WHG platform and everything in its database.</p>
            </div>
            <div class="row" style="display:flex">
                <div style="width:50%">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th class="table-title" colspan="2">
                                    <a href="abest">Best selling
                                        <span class="hide-small"> Games</span>
                                    </a>
                                </th>
                                <th style="color: white; width: 22%;">Download</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.tenbest}" var="b">
                                <tr style="height: 5%;" onclick="window.location.href='agameDetails?GameID=${b.gameID}'">
                                    <td colspan="2">
                                        <a>
                                            <img src="${b.poster}" alt="" style="width: 10%; height: 100%">
                                        </a>
                                        <span style="color: white">${b.name}</span>
                                    </td>
                                    <td class="text-success"><b>${b.download}</b></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div style="width:50%">
                    <table class="table table-hover" >
                        <thead>
                            <tr>
                                <th class="table-title" colspan="2">
                                    <a href="anews">New
                                        <span class="hide-small"> Games</span>
                                    </a>
                                </th>
                                <th style="color: white; width: 22%;">Release date</th>
                                <th>Download</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.tennewgame}" var="n">
                                <tr style="height: 5%;" onclick="window.location.href='agameDetails?GameID=${n.gameID}'">
                                    <td colspan="2">
                                        <a>
                                            <img src="${n.poster}" alt="" style="width: 10%; height: 100%">
                                        </a>
                                        <span style="color: white">${n.name}</span>
                                    </td>
                                    <td class="text-success"><b>${n.date}</b></td>
                                    <td class="text-success"><b>${n.text}</b></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="row" style="display:flex">
                <div style="width:50%">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th class="table-title" colspan="2">
                                    <a href="abest">Sale
                                        <span class="hide-small"> Games</span>
                                    </a>
                                </th>
                                <th style="color: white; width: 22%;">Download</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.tendeals}" var="d">
                                <tr style="height: 5%;" onclick="window.location.href='agameDetails?GameID=${d.gameID}'">
                                    <td colspan="2">
                                        <a>
                                            <img src="${d.poster}" alt="" style="width: 10%; height: 100%">
                                        </a>
                                        <span style="color: white">${d.name}</span>
                                    </td>
                                    <td class="text-success"><b>${d.download}</b></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div style="width:50%">
                    <table class="table table-hover" >
                        <thead>
                            <tr>
                                <th class="table-title" colspan="2">
                                    <a href="anews">Free
                                        <span class="hide-small"> Games</span>
                                    </a>
                                </th>
                                <th style="color: white; width: 22%;">Release date</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.tenfree}" var="f">
                                <tr style="height: 5%;" onclick="window.location.href='agameDetails?GameID=${f.gameID}'">
                                    <td colspan="2">
                                        <a>
                                            <img src="${f.poster}" alt="" style="width: 10%; height: 100%">
                                        </a>
                                        <span style="color: white">${f.name}</span>
                                    </td>
                                    <td class="text-success"><b>${f.date}</b></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                
            </div>
            <div class="container">
                <h3 style="color: white">Current database</h3>
                <div class="row db">
                    <div style="width: 20%; color: white;">
                        <a class="number">${requestScope.size}</a>
                        <em style="display: block">number of games on WHG</em>
                    </div>
                    <div style="width: 20%; color: white;">
                        <a class="number" > <fmt:formatNumber type = "number" maxIntegerDigits = "2" value = "${requestScope.total}"/>M</a>
                        <em style="display: block">number of Purchase on WHG</em>
                    </div>  
                    <div style="width: 20%; color: white;">
                        <a class="number">${requestScope.size}</a>
                        <em style="display: block">number of users today</em>
                    </div>
                    <div style="width: 20%; color: white;">
                        <a class="number">${requestScope.size}</a>
                        <em style="display: block">total number of users</em>
                    </div>
                </div>
            </div>

            <div class="container">
                <h2 style="color:white;font-size: 24px; line-height: 2; text-align: left">Recent activities</h2>

            </div>
            <br>
        </section>
        <footer>
            <jsp:include page="footer.jsp"/>
        </footer>
    </body>
</html>
