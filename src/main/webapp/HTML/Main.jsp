<%--
Created by IntelliJ IDEA.
User: lauraluca
Date: 2020-04-21
Time: 17:06
To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C/DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>ATM</title>
    <link rel="stylesheet" type="text/css" href="../CSS/Main.css">
    <script type="text/javascript" src="../JS/Main.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>

    <body>

        <div class="container">
            <div class="optionContainer">
                <button style="font-size: 18px;" type="button" class="user">Welcome, ${user}</button>
                <button style="font-size: 20px;" type="button" class="btnStyle" onclick="depositFunction()"  id="ct1">DEPOSIT</button>
                <button style="font-size: 20px;" type="button" class="btnStyle" onclick="withdrawFunction()" id="ct2">WITHDRAW</button>
                <button style="font-size: 20px;" type="button" class="btnStyle" onclick="transferFunction()" id="ct3">TRANSFER</button>
                <button style="font-size: 20px;" type="button" class="btnStyle" onclick="simulatorFunction()" id="ct4">SIMULATOR</button>
                <button style="font-size: 20px;" type="button" onclick="location.href='logout'" class="logout">LOGOUT</button>
            </div>
            <div class="bank">
                <h6>Current Bank Balance : $ ${currentAmount}</h6>
            </div>

            <div class="depositContainer" id="deposit">
                <div class="leftTable">
                    <p>What amount do you want to deposit?</p>
                    <form action="deposit" modelAttribute="deposit">
                        <input type="text" placeholder="Enter amount" name="amount" required>
                        <button style="font-size: 18px;" type="submit" class="depositBtn">DEPOSIT</button>
                    </form>
                </div>
                <div class="rightTable">
                    <h1><span style="color:white;">Coffee</span>BANK</h1>
<%--                    <p>${result}</p>--%>
<%--                    succes--%>
                    <div class="alert alert-${colorType} alert-dismissible ${collapse}">
                        <href type="button" class="close" data-dismiss="alert">&times;</href>
                        ${actionType} was made <strong>${returnType}</strong> . ${result}
                    </div>
                </div>
            </div>


            <div class="withdrawContainer" id="withdraw">
                <div class="leftTable">
                    <p>What amount do you want to withdraw?</p>
                    <form action="withdraw" modelAttribute="withdraw">
                        <input type="text" placeholder="Enter amount" name="amount" required>
                        <button style="font-size: 18px;" type="submit" class="depositBtn">WITHDRAW</button>
                    </form>
                </div>
                <div class="rightTable">
                    <h1><span style="color:white;">Coffee</span>BANK</h1>
                </div>
            </div>


            <div class="transferContainer" id="transfer">
                <div class="leftTable">
                    <p>What amount do you want to transfer?</p>
                    <form action="transfer" modelAttribute="transfer">
                        <input type="text" placeholder="Enter amount" name="amount" required>
                        <p>Which person do you want to transfer the money to?</p>
                        <input type="text" placeholder="Enter user" name="user" required>
                        <button style="font-size: 18px;" type="submit" class="depositBtn">TRANSFER</button>
                    </form>
                </div>
                <div class="rightTable">
                    <h1><span style="color:white;">Coffee</span>BANK</h1>
                </div>
            </div>


            <div class="simulatorContainer" id="simulator">
                <div class="leftTable">
                    <p>How long do you want to take out the loan?</p>
                    <form action="simulator" modelAttribute="simulator">
                        <input type="range" min="1" max="35" value="20" class="slider" id="myRange" name = "years">
                        <p>what amount of money do you want to borrow?</p>
                        <input type="range" min="5000" max="200000" value="100000" class="slider" id="myRange2" name = "money">
                        <p>What is your current salary?</p>
                        <input style="margin-top: 10px;" type="text" placeholder="Enter salary" name="salary" required>
                        <div class="label">
                            <p class="options">Years: <span1 id="years"></span1></p>
                            <p class="options">Amount: <span1 id="amountMoney"></span1> $</p>
                        </div>
                        <button style="font-size: 18px;" type="submit" class="depositBtn">SIMULATE</button>
                    </form>
                </div>
                <div class="rightTable">
                    <h1><span style="color:white;">Coffee</span>BANK</h1>
                </div>
            </div>


        </div>
        <script>
            var slider1 = document.getElementById("myRange2");
            var output1 = document.getElementById("amountMoney");
            output1.innerHTML = slider1.value;

            slider1.oninput = function() {
            output1.innerHTML = this.value;
            }


            var slider2 = document.getElementById("myRange");
            var output2 = document.getElementById("years");
            output2.innerHTML = slider2.value;

            slider2.oninput = function() {
                output2.innerHTML = this.value;
            }
        </script>

    </body>

</html>