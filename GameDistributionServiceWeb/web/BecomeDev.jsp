<%-- 
    Document   : isdev
    Created on : Oct 12, 2022, 5:41:11 PM
    Author     : Cun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register to become a game developer</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    </head>
    <body>

        <section class="vh-100 bg-image"
                 style="background-image: url('https://wallpaperaccess.com/full/7446.jpg'); width: 100%">
            <div class="mask d-flex align-items-center h-100 gradient-custom-3">
                <div class="container h-100">
                    <div class="row d-flex justify-content-center align-items-center h-100">
                        <div class="col-10 col-md-9 col-lg-7 col-xl-6">
                            <div class="card" style="border-radius: 15px;">
                                <div class="card-body p-5">
                                    <form action="isDev" method="post">
                                        <input type="hidden" readonly name="name" value="${sessionScope.acc.username}" class="text-uppercase text-center mb-5" size="5px">
                                        <h2 class="text-uppercase text-center mb-5">${sessionScope.acc.username}, LET'S CO-OPERATE WITH WGH</h2>
                                        <div style="background-color: gray">
                                            To continue, we need you to accept all the terms and the rules below:<br>
                                            1. For each game, we will take 5% of the income of the game(after tax).<br>
                                            2. Your game must not copy other's games without permission, or else we will delete your game.<br>
                                            3. Your game will be uploaded after our ratification. This also works to your game's update.
                                        </div>

                                        <div style="text-align: center">

                                            <input type="checkbox" required=""> I accept to all the terms.<br>          <!-- checkbox de accept -->
                                            <button type="submit">Register!!</button>

                                        </div>                                     
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
