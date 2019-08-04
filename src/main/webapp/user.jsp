<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: matacz
  Date: 04.08.2019
  Time: 09:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<form method="post">
    Login: <br><input name="login" type="login"><br>
    Password: <br><input name="password" type="password"><br>
    <br><input type="submit" value="log in">
</form>

Login from session: ${sessionScope.userLoginSessionName}<br>
Password from session: ${sessionScope.userPasswordSessionName}

</body>
</html>
