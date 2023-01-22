<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 18/01/2023
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome To Flexicode Homepage</title>
</head>
<body>
    <%

        if(session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
        }
    %>

      Welcome to your homepage ${username}
   <br>
   <br>
   <br>
    <form action="show-profile" method="post">
     <input type="submit" value="profile" style="background: darkslategrey">
    </form>
   <br>
   <br>
    <form action="login.jsp">
     <input type="submit" value="logout" style="background: red">
    </form>
   <br>
   <br>
     <form action="updateprofile" method="post" >
     <input type="submit" value="edit profile" style="background: darkslategrey">
     </form>
</body>
</html>
