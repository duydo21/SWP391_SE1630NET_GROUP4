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
                                    <h2 class="text-uppercase text-center mb-5">Edit Profile</h2>
                                    <h5 class="fw-normal mb-3 pb-3" style="color: black;">${requestScope.msr}</h5>
                                    <form action="editprofile" class="register" method="post">
                                        <div class="form-outline mb-2">
                                            <input type="text" name ="nickname" id="form3Example1cg" class="form-control form-control-lg" required="" value="${sessionScope.userlogin.nickname}" />
                                            <label class="form-label" for="form3Example1cg">Nickname</label>
                                        </div>

                                        <div class="form-outline mb-2">
                                            <input type="email" name="email" id="form3Example4cg" class="form-control form-control-lg" />
                                            <label class="form-label" for="form3Example4cg">Email</label>
                                        </div>

                                        <div class="form-outline mb-2">
                                            <select name="country" id="form3Example4cdg" class="form-select form-control-lg">
                                                <option value="none">none</option>
                                                <option value="USA">USA</option>
                                                <option value="Canada">Canada</option>
                                                <option value="Congo">Congo</option>
                                                <option value="Switzerland">Switzerland</option>
                                                <option value="China">China</option>
                                                <option value="Germany">Germany</option>
                                                <option value="Egypt">Egypt</option>
                                                <option value="Spain">Spain</option>
                                                <option value="VietNam">VietNam</option>
                                            </select>
                                            <label class="form-label" for="form3Example4cdg">Country</label>
                                        </div>
                                        
                                        <div id="selectedBanner"></div>
                                        <div class="form-outline mb-2">
                                            <div class="form-group">
                                                <input type="file" id="img" class="form-control" name="avatar"/>
                                                <label class="form-label" for="form3Example4cg">Avatar</label>
                                            </div>
                                        </div>
                                        
                                        <div class="form-outline mb-2">
                                            <input type="checkbox" name="show" id="form3Example4cdg" class="form-checkbox " />
                                            <label class="form-label" for="form3Example4cdg">Show information</label>
                                        </div>

                                        <div class="d-flex justify-content-center">
                                            <button type="submit" class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Submit</button>
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
        </script>
    </body>

</html>
