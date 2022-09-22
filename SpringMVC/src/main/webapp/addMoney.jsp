<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Money</title>
</head>
<body  style=background:url("https://wallpaperaccess.com/full/51381.jpg")>
<div style=margin:150px;>
<h2 style=color:White>Add money to your Payme wallet</h2>
<form action="addMoney.cdac">
<input type="text"	placeholder="Mobile No." name="mobno"/><br><br>
<input type="number" placeholder="Amount" name="amount"/><br><br>
<input	type="submit"/>
<br>
<h2>	${	message	}	</h2>
<hr>
<a href="Payme.jsp" style=color:White>Home Page</a>
</form>
</div>
</body>
</html>