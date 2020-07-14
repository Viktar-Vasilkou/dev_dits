<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Spring Security</title>
</head>

<body>



<div class="container" style="width: 300px;">
    <form action="${loginUrl}" method="post" >
        <h2 class="form-signin-heading">Please sign in</h2>
        <label>
            <input type="text" class="form-control" name="j_login" placeholder="login">
        </label>
        <label>
            <input type="password" class="form-control" name="j_password" placeholder="password">
        </label>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="logIn" type="submit">Войти</button>
    </form>
</div>

</body>
</html>