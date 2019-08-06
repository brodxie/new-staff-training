<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<div class="container" style="width: 35%;text-align: center;">
    <h2 class="form-login-heading">用户登录</h2>
    <form id="loginForm" class="form-horizontal" action="/login" method="post">
        <div class="form-group">
            <input id="username" type="text" class="form-control" placeholder="用户名" autofocus name="username">
        </div>
        <div class="form-group">
            <input id="password" type="password" class="form-control" placeholder="密码" name="password">
        </div>
        <div class="form-group">
            <span style="color:red;">${message}</span>
            <button type="submit" class="btn btn-default" id="submit">登录</button>
        </div>
    </form>
</div>
</body>
</html>