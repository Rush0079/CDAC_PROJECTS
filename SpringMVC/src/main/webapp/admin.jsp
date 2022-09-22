<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>AdminLogin_Form</title>
    <link rel="icon" type="image/x-icon" href="LOGIN-KEY.png">
    <link rel="stylesheet" type="text/css" href="LOGIN_STY.css">
    <!-- <script src="registration.js"></script> -->

 
</head>
<body>
  <form action="users.cdac">
<h3 style="position: relative;left: 500px;">${ message }</h3>
    <div class="loginbox">
        <!--  <img src="LOGIN-KEY.png" class="LOGIN-KEY">  -->
        <h1>ADMIN 	LOGIN</h1>
      
            <p>Username</p>
            <input id="username" type="text" name="username" placeholder="Enter Username">
            <br><span id="msg"></span>
            <br>
            
            <p>Password</p>
            <input id="password" type="password" name="password" placeholder="Enter Password">
            <br><span id="msg1"></span>
            <br>
            <input id="Login" type="Submit" name="" value="Login" >
           <br>
               <!-- <a href="users.cdac">Delete user</a>	-->
          <!--    <a href="register.jsp">Don't have an Account?</a>	-->
      
    </div>
  </form>
</body>
</html>