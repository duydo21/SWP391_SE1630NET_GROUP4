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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

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

                                            <input type="checkbox" required=""> I accept to all the terms.<br>
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
