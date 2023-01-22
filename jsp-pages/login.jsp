<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 18/01/2023
  Time: 00:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login to your account</title>
</head>
<body bgcolor="orange">
      <form action="check-login" method="post">
  <h1> Welcome to your Flexi code the leading website for everything programming.</h1> <br>
  <h2> Connect with us today to get the best template and clean code for your business website or mobile app </h2>
  <h2>Login into your account to access your page</h2>
  <br>
  <br>
  Username  <input type="text" name="username">
  <br><br><br>
  Password  <input type="password" name="password">
  <br><br>
   <%="              "%> <input type="submit" value="Login"><br>
      </form>

 <br> <br> <br>
<form action="create-account.jsp" method="post">
  <%="                "%>Don't yet have an account? <br>
  <%="             "%>Click on the link below to register with us<br>
      <%="                "%><input type="submit" value="Sign Up"><br>
</form>
<input formaction="about-flexi.jsp" type="submit" style="background-color: blue">
</body>
</html>
