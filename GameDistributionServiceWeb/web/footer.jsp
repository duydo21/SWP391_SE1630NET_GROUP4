<%-- 
    Document   : footer
    Created on : Jul 10, 2022, 4:02:16 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/footer.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <footer>
            <div class="container">
                
                <div class="noi-dung about">
                    <h2>Về Chúng Tôi</h2>
                    <p>
                        Chúng tôi là Group 4 lớp SE1630NET môn SWP391 kỳ Fall2022. Nhóm chúng tôi gồm 5 người: Mạnh, Duy, Hoàng Anh, Quân và Hiếu.
                    </p>
                    <ul class="social-icon">
                        <li><a href="https://www.facebook.com/traitimtrongvang2/"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="https://www.instagram.com/traitimtrongvang02/"><i class="fa fa-instagram"></i></a></li>
                    </ul>
                </div>
                
                <div class="noi-dung links">
                    <h2>Đường Dẫn</h2>
                    <ul>
                        <li><a href="home.jsp">Trang Chủ</a></li>
                        <li><a href="#">Về Chúng Tôi</a></li>
                        <li><a href="#">Thông Tin Liên Lạc</a></li>
                        <li><a href="#">Dịch Vụ</a></li>
                        <li><a href="#">Điều Kiện Chính Sách</a></li>
                    </ul>
                </div>
                
                <div class="noi-dung contact">
                    <h2>Thông Tin Liên Hệ</h2>
                    <ul class="info">
                        <li>
                            <span><i class="fa fa-map-marker"></i></span>
                            <span>Km29 Đường Cao Tốc 08<br />
                                Thạch Hoà, Thạch Thất, Hà Nội<br />
                                Việt Nam</span>
                        </li>
                        <li>
                            <span><i class="fa fa-phone"></i></span>
                            <p><a href="#">+84 0816788886</a>
                        </li>
                        <li>
                            <span><i class="fa fa-envelope"></i></span>
                            <p><a href="#">abc@fpt.edu.vn</a></p>
                        </li>
                        
                    </ul>
                </div>
                <!--Kết Thúc Nội Dung Liên Hệ-->
            </div>
        </footer>
    </body>
</html>
