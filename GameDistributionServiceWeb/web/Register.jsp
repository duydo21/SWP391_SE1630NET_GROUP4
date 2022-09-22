<%-- 
    Document   : Register
    Created on : Sep 20, 2022, 5:25:49 PM
    Author     : Strongest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/Login.css"/>
    </head>
    <body>         
        <div class= "form">
            <c:if test = "${requestScope.acceptemail == null}">
                <form action="register" class="signup" method="post">
                    <h1 style="color: #333;">Register</h1>
                    <h4 style="color: #333;">${requestScope.ms}</h4>
                    <input type="text" name="email" class="input" placeholder="Email"><br>
                    <input type="submit" value="Register Email" class ="button"> 
                </form>                
            </c:if>
            <c:if test = "${requestScope.acceptemail != null}">
                <form action="register" class="signup" method="post">
                    <h1 style="color: #333;">Register</h1>
                    <h4  style="color: #333;">${requestScope.ms}</h4>
                    <input type="text" name="email" class="input" value="${requestScope.acceptemail}"><br>
                    <input type="password" name="user" class="input" placeholder="Username"><br>
                    <input type="password" name="pass" class="input" placeholder="Password"><br>
                    <input type="password" name="pass2" class="input" placeholder="Re enter password"><br>                             
                    <input type="submit" value="Register" class ="button"> 
                </form>
            </c:if>
            <h3>already have account ? <a href="login">Signin here</a></h3>
        </div>
    </body>
</html>
