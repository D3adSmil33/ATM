<%--
Created by IntelliJ IDEA.
Date: 2020-04-21
Time: 17:06
To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C/DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>ATM</title>
    <link rel="stylesheet" type="text/css" href="../CSS/Home.css">
    <script type="text/javascript" src="../JS/Home.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>

    <body>

        <div class="mainContainer">
            <div class="textContainer">
                <h1><span style="color:white;">Coffee</span>BANK</h1>
                <div class="error">
                    <div class="alert alert-danger alert-dismissible ${collapse}">
                        <href type="button" class="close" data-dismiss="alert">&times;</href>
                        ${text}
                    </div>
                </div>
            </div>
                <div class="buttonWrap">
                <button style="font-size: 25px;" type="button" id="LoginButton" onclick="loginFunction()" class="buttonStyle">LOGIN</button>
                <button style="font-size: 25px;" type="button" id="RegisterButton" onclick="classBoxRegister()" class="buttonStyle">REGISTER</button>
                </div>

        </div>

        <div class="box" id="classBox">
            <div class="box-content">
                <div class="formClose">
                    <div onclick="closeFunction()" class="closeClick">+</div>
                </div>
                    <h1><span style="color:white;">Coffee</span>BANK</h1>
                <form action="isLogin" modelAttribute="userData">
                    <input type="text" placeholder="Enter Username" name="username" required>
                    <input type="password" placeholder="Enter Password" name="password" required>
                    <button style="font-size: 20px;" type="submit" class="submitBtn">LOGIN</button>
                </form>
            </div>
        </div>

        <div class="box" id="classBoxRegister">
            <div class="box-content">
                <div class="formClose">
                    <div onclick="closeFunctionRegister()" class="closeClick">+</div>
                </div>
                <h1><span style="color:white;">Coffee</span>BANK</h1>
                <form action="isRegister" modelAttribute="userData">
                    <input type="text" placeholder="Enter Username" name="username" required>
                    <input type="password" placeholder="Enter Password" name="password" required>
                    <input type="password" placeholder="Repeat Password" name="passwordRep" required>
                    <button style="font-size: 20px;" type="submit" class="submitBtn">REGISTER</button>
                </form>
            </div>
        </div>

    </body>

</html>
