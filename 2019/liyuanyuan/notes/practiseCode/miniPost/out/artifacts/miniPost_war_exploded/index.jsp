<%--
  Created by IntelliJ IDEA.
  User: Leeyy
  Date: 2019/7/31
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>用户登录</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrapValidator.min.css"/>

</head>

<body>

<div class="container" style="width: 30%;text-align: center;">
    <div style="vertical-align:middle;padding-top: 35%">
        <h2 class="form-login-heading">用户登录</h2>
        <br>
        <form id="loginForm" class="form-horizontal" action="/miniPost/loginServlet?method=confirmUserInfo" method="post">
            <div class="form-group">
                <input id="userName" type="text" class="form-control" placeholder="用户名" autofocus name="userName">
            </div>
            <div class="form-group">
                <input id="passWord" type="password" class="form-control" placeholder="密码" name="passWord">
            </div>
            <div class="form-group">
                <span style="color:red;">${message}</span>
                <button type="submit" class="btn btn-default" id="submitUserInfo">登录</button>
            </div>
        </form>
    </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrapValidator.js"></script>
<script type="text/javascript">
        $('#loginForm').bootstrapValidator({
            message: 'This value is not valid',
            fields: {
                userName: {
                    message: 'The username is not valid',
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空'
                        }
                    }
                },
                passWord: {
                    message: 'The passWord is not valid',
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        }
                    }
                }
            }
        })
</script>
</body>
</html>