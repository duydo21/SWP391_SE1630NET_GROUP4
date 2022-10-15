<%-- 
    Document   : Payment
    Created on : Oct 15, 2022, 8:30:18 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/Header.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
        <style>
            section{
                width: 70%;
                margin: 0 auto;
                background-color: #ccc;
                text-align: center;
                position: relative;
                padding-bottom: 10px;
            }
            #heading{
                font-size: 30px;
                font-weight: 700;
                text-align: center;
                padding:  10px 0;
            }
            .meth{
                transform: translateX(20px);
                border: #ccc;
            }
            .amount{
                transform: translateX(72px);
                border: #ccc;
            }
            label{
                position: absolute;
                left: 30%;
            }
            #form{
                font-size: 20px;
            }
            #method,#amount,#type{
                margin: 10px 0;
            }
            
        </style>
    </head>
    <body>
        <header>
            <jsp:include page="Header.jsp" />
        </header>
        <section>
            <div id="heading">PAYMENT</div>
            <form action="payment" method="post">
                <div id="form">
                    <div id="method">
                        <label>Method:</label>
                        <select class="meth" name="meth">
                            <option value="paypal">Paypal</option>
                            <option value="cre">Credit Card</option>
                            <option value="bank">Banking</option>
                        </select>
                    </div>
                    <div id="amount">
                        <label>Amount of money:</label>
                        <input class="amount" type="text" name="amount">
                    </div>
                    <div id="type">
                        <input type="radio" name="t" checked value="0"> Withdraw
                        <input type="radio" name="t" value="1"> Insert
                    </div>
                    <input class="submit" type="submit" value="Perform">
                </div>
            </form>
        </section>
        <footer>
            <%@include file="footer.jsp"%>
        </footer>
    </body>
</html>
