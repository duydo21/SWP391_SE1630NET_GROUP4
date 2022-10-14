<%-- 
    Document   : transactionhistory
    Created on : Oct 13, 2022, 2:40:56 PM
    Author     : Cun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transaction History</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
        <style>
            .tranhis {
                width: auto;
                margin-left: 10%;
                margin-right: 10%;
                padding: 10px;
                overflow: auto;
            }
            #post {
                width: 75%;
                height: auto;
                float: right;
            }
            #sidebar {
                width: 25%;
                height: auto;
                float: left;
            }
        </style>
    </head>
    <body>
        <h1 class="text-uppercase text-center mb-5" style="text-align: center; margin-top: 20px"><u>TRANSACTION HISTORY</u></h1>
        <div class="tranhis">
            <div id="sidebar">
                <input type="checkbox" />Show only additon<br>
                <input type="checkbox" />Show only subtraction
            </div>
            <div id="post">
                <div style="float: left">   
                    <form class="search d-flex " action="search" method = "get" style="margin-left: 20px">
                        <input type="search" placeholder="Search" aria-label="Search" name="search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
                <div style="float: right">
                    <label>Sort by: </label>
                    <select name="sort">
                        <option value="date">Date</option>
                        <option value="money">Money</option>
                        <option value="paymentmethod">Payment Method</option>
                    </select>
                </div>
            </div>
        </div>
        <div id="post" style="background-color: #e8e8e8; margin-right: 10%">
            <table style="width: 90%; margin-left: 10%">
                <tr>
                    <th>Payment method: Paypal</th>
                    <th style="text-align: center;">Date: 26/09/2002</th>
                </tr>
                <tr>
                    <th>Amount of money: +500$</th>
                    <th style="text-align: center;">20:39</th>
                </tr>
            </table>
        </div>
    </body>
</html>
