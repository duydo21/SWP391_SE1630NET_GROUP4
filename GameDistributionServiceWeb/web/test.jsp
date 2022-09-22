<%-- 
    Document   : test
    Created on : Sep 22, 2022, 3:23:18 PM
    Author     : Strongest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        ${sessionScope.account.username}
        ${sessionScope.account.password}
        ${sessionScope.account.type}
    </body>
</html>
