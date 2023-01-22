<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 18/01/2023
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Account</title>
</head>
<body bgcolor="#ff8c00">
    <form action="create-account" method="post">
      Enter your details to create an account<br><br>
      <br>
      <h2>Personal Information</h2>
      <br><br>

      Firstname <input type="text" name="first_name">
      <%="      "%>
      Middlename <input type="text" name="middle_name">
      <%="      "%>
      Lastname <input type="text" name="last_name">
      <br>
      <br>
      Email <input type="text" name="user_email">
      <br>
      <br>
      Date of birth <input type="date" name="dob">
      <br>
      <br>
      Country of birth <input type="text" name="country">
      Language <input type="text" name="language">
      <br>
      <br>
      Enter a Username <input type="text" name="username"><br><br>
      Enter a strong password <input type="password" name="password">
      <br>
      <br>
      <input type="submit" value="Sign up">
    </form>
</body>
</html>
