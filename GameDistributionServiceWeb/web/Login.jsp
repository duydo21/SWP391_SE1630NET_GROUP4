<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>Project</title>
        <link rel="stylesheet" href="css/Login.css">
    </head>

    <body>
        <div class ="form">
            <form action="login" class="login" method="post">
                <c:set var="cookie" value="${pageContext.request.cookies}"/>
                <h1>Login</h1>
                <h4 style="color: red">${requestScope.ms}</h4>
                <input type="text" name="user" value="${cookie.cuser.value}" placeholder="Username" class="input"><br>
                <input type="password" name="pass" value="${cookie.cpass.value}" placeholder="Password" class="input">
                <input type="checkbox" ${cookie.crem!= null? 'checked':''} name="rememberMe" value="on/"> <label>Remember me</label>
                <input type="submit" class="button" value="Login">
            </form>
                <h3 style="font-size: 13px;color: #666;line-height: 1.5;">didnt have account ? <a href="register">Signup here</a></h3>
        </div>
    </body>

</html>
