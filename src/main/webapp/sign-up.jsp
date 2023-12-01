<%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 11/27/23
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        input {
            display: block;
        }
    </style>
    <title>PRODUCT APPLICATION</title>
</head>
<body>
<h4>Sign up</h4>
<span>
<form method="post" action="user">
  Username: <input name="username" placeholder="username">
  Email: <input name="email" type="email" placeholder="email">
  Password: <input name="password" type="password" placeholder="password">
  <button type="submit"> Sign Up</button>
</form>
</span>
</body>
</html>
