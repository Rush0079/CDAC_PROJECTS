<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Card Payment</title>
  <script src="CardPayment.js"></script> 
    <style>
        body {
            background-image: url(https://cdn.dnaindia.com/sites/default/files/styles/full/public/2022/04/22/1567628-fotojet-2022-04-22t175941.729.jpg);
        }
        .dv {
            background-image: linear-gradient(to right,rgb(198, 250, 250),rgb(254, 228, 194));
            border-radius: 10px;
            padding: 20px;
            opacity: 0.93;
            margin-left: 300px;
            margin-top: 35px;
            height: 500px;
            width: 600px;
        }
        #btn {
            margin-left: 150px;
            height: 30px;
            width: 150px;
            background-color: rgb(0, 115, 255);
            color: white;
            border-radius: 3px;
            cursor: pointer;
            border: none;
            font-size: 15px;
        }
    </style>
</head>
<body>
<a href="Payme.jsp" style="color:white">Home Page</a>
    <div class="dv">
    <h2>CardPay</h2><hr>
    <form action="amountUpdateFinal.cdac">
    <label for="cn"><p><b>Card Number</b></p></label>
    <p>Enter the 16-digit card number on the card</p>
    <input type="text" id="cn" required>
    <label for="cvv"><p><b>CVV</b></p></label>
    <p>Enter the 3  or 4 digit number on the card</p>
    <input type="number" id="cvv" disabled required>
    <label for="dt"><p><b>Expiry Date</b></p></label>
    <p>Enter the expiration date of the card</p>
    <input type="month" id="dt" placeholder="mm-yyyy" disabled required>
    <br><br><br><br>
    <input type="submit" id="btn" disabled></input>
    </form>
    </div>
</body>
</html>