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
        <title>Register to WHG</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </head>
    <body>         
        <section class="vh-100 "
                 style="background-image: url('https://wallpaperaccess.com/full/7446.jpg'); width: 100%">
            <div class="mask d-flex align-items-center h-100 gradient-custom-3">
                <div class="container h-100">
                    <div class="row d-flex justify-content-center align-items-center h-100">
                        <div class="col-10 col-md-9 col-lg-7 col-xl-6">
                            <div class="card" style="border-radius: 15px;">
                                <div class="card-body p-5">
                                    <h2 class="text-uppercase text-center mb-5">Upload Game</h2>
                                    <h5 class="fw-normal mb-3 pb-3" style="color: black;">${requestScope.msr}</h5>
                                    <form action="uploadgame"  method="post" enctype='multipart/form-data'>
                                        <div class="form-outline mb-2">
                                            <input type="text" name ="name" id="form3Example1cg" class="form-control form-control-lg" required=""  />
                                            <label class="form-label" for="form3Example1cg">Name</label>
                                        </div>

                                        <div class="form-outline mb-2">
                                            <input type="number" name="price" id="form3Example4cg" class="form-control form-control-lg" value="0" min="0"  />
                                            <label class="form-label" for="form3Example4cg">Price</label>
                                        </div>

                                        <div class="form-outline mb-2">
                                            <input type="text" name="decription" id="form3Example4cg" class="form-control form-control-lg" required="" />
                                            <label class="form-label" for="form3Example4cg">Decription</label>
                                        </div>

                                        <div class="form-outline mb-2" style="border: 1px solid lightgrey; border-radius: 10px">
                                            <c:forEach items="${requestScope.cate}" var="c">
                                                <input type="checkbox" name="category" id="form3Example4cdg" class="form-checkbox " value="${c.categoryID}" />
                                                <label class="form-label" for="form3Example4cdg">${c.categoryName}</label>
                                            </c:forEach>
                                        </div>
                                        <label class="form-label" for="form3Example4cdg">Category</label>

                                        <div id="selectedBanner"></div>
                                        <div class="form-outline mb-2">
                                            <div class="form-group">
                                                <input type="file" id="img" class="form-control" name="poster" required=""  />
                                                <label class="form-label" for="form3Example4cg">Poster</label>
                                            </div>
                                        </div>


                                        <div class="form-outline mb-2">
                                            <div class="form-group">
                                                <input type="file" id="img" class="form-control" name="video"   />
                                                <label class="form-label" for="form3Example4cg">Video</label>
                                            </div>
                                        </div>

                                        <div class="form-outline mb-2">
                                            <div class="form-group">
                                                <input type="file" id="img" class="form-control" name="demo" multiple=""  />
                                                <label class="form-label" for="form3Example4cg">Picture Demo</label>
                                            </div>
                                        </div>

                                        <div class="d-flex justify-content-center">
                                            <button type="submit" " class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Submit</button>
                                        </div>                                       
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script
            src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
            crossorigin="anonymous"
        ></script>
        <script>
            var selDiv = "";
            var storedFiles = [];
            $(document).ready(function () {
                $("#img").on("change", handleFileSelect);
                selDiv = $("#selectedBanner");
            });

            function handleFileSelect(e) {
                var files = e.target.files;
                var filesArr = Array.prototype.slice.call(files);
                filesArr.forEach(function (f) {
                    if (!f.type.match("image.*")) {
                        return;
                    }
                    storedFiles.push(f);

                    var reader = new FileReader();
                    reader.onload = function (e) {
                        var html =
                                '<img src="' +
                                e.target.result +
                                "\" data-file='" +
                                f.name +
                                "alt='Category Image' height='50px' width='50px'>";
                        selDiv.html(html);
                    };
                    reader.readAsDataURL(f);
                });
            }

            function validateEmail(email) {
                var re = /\S+@\S+\.\S+/;
                return re.test(email);
            }
        </script>
    </body>

</html>
