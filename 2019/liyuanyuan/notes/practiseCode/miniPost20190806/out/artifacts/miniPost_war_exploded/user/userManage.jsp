<%--
  Created by IntelliJ IDEA.
  User: Leeyy
  Date: 2019/7/31
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="description" content="">
    <meta name="author" content="">

    <title>用户管理</title>

    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/miniPost/postView?method=getAllPosts">贴吧LOGO</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <form class="navbar-form navbar-right">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="输入内容...">
                    <span class="input-group-btn">
                  <button class="btn btn-default" type="button">搜索</button>
                </span>
                </div>

                <div class="btn-group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ${sessionScope.loginUsername} <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">个人中心</a></li>
                        <c:if test="${sessionScope.loginTypeId == 1}">
                            <li><a href="/miniPost/userManage?method=getAllUserInfo">用户管理</a></li>
                        </c:if>
                        <li role="separator" class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/index.jsp">退出登录</a></li>
                    </ul>
                </div>
            </form>
        </div>
    </div>
</nav>

<div class="jumbotron">
    <div class="container" style="padding-top: 50px;">
        <h2>用户管理</h2>
        <br/>
        <div class="row">
            <div class="col-lg-6 col-md-6">
                <div class="input-group">
                    <div class="input-group-btn">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">全部 <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                            <li><a href="#">用户名</a></li>
                            <li><a href="#">用户类型</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">注册时间</a></li>
                        </ul>
                    </div>
                    <input type="text" class="form-control" aria-label="..." placeholder="输入内容...">
                </div>
            </div>
            <div class="col-lg-6 col-md-6">
                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#addUserModal">添加用户</button>
            </div>
        </div>
    </div>
</div>

<div class="container">

    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>用户ID</th>
                <th>用户名</th>
                <th>用户类型</th>
                <th>注册时间</th>
                <th>管理</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${userInfoList}">
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.userName}</td>
                    <td>${user.userType}</td>
                    <td>${user.signInTime}</td>
                    <td>
                        <c:if test="${user.userType == '超级管理员' }">
                            <span class="glyphicon glyphicon-user" style="color: #FF7F50;"></span>
                        </c:if>
                        <c:if test="${user.userType == '普通管理员' }">
                            <span class="glyphicon glyphicon-user" style="color: #66afe9"></span>
                        </c:if>
                        <c:if test="${user.userType == '普通用户' }">
                            <span class="glyphicon glyphicon-user user-update" style="cursor:pointer; color: lightgrey;" data-toggle="modal" data-target="#updateUserTypeModal" title="更改为管理员" data-tmpId="${user.userId}"></span>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li>
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li>
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>

    <hr>

    <footer>
        <p>&copy; 2019 Company, Inc.</p>
    </footer>
</div>

<!-- 添加用户 -->
<div class="modal fade" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="userModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel">添加用户</h4>
            </div>
            <div class="modal-body">
                <form id="addUserForm" action="/miniPost/userManage?method=addNewUser" method="post">
                    <div class="form-group">
                        <label for="user-name" class="control-label">用户名</label>
                        <input type="text" class="form-control" id="user-name" name="userName">
                    </div>
                    <div class="form-group">
                        <label class="control-label">用户类型</label>
                        <select class="form-control" name="userType">
                            <option>普通用户</option>
                            <option>普通管理员</option>
                            <option>超级管理员</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="user-password" class="control-label">登录密码</label>
                        <input type="text" class="form-control" id="user-password" name="password">
                    </div>
                    <hr>
                    <div class="form-group">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary" id="saveNewUser">保存</button>
                    </div>
                </form>
            </div>
            <%--<div class="modal-footer">--%>
                <%--<span style="color:red;">${addFeedInfo}</span>--%>
                <%--<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>--%>
                <%--<button type="submit" class="btn btn-primary">保存</button>--%>
            <%--</div>--%>
        </div>
    </div>
</div>

<!-- 更改用户类型 -->
<div class="modal fade" id="updateUserTypeModal" tabindex="-1" role="dialog" aria-labelledby="deletePartPost">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="deletePartPost">更改用户类型</h4>
            </div>
            <div class="modal-body">
                <p>确定将此用户更改为普通管理员？</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="cfmUpdateType">确定</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrapValidator.js"></script>
<script type="text/javascript">
    $(function(){
        $('#addUserForm').bootstrapValidator({
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
                userType: {
                    message: 'The userType is not valid',
                    validators: {
                        notEmpty: {
                            message: '用户类型不能为空'
                        }
                    }
                },
                password: {
                    message: 'The password is not valid',
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        }
                    }
                }
            }
        });
        $("span.user-update").click(function () {
            console.log($(this).attr("data-tmpId"));
            var userId = $(this).attr("data-tmpId");

            $("#cfmUpdateType").click(function () {
                $.ajax({
                    url: '/miniPost/userManage?method=updateUserType',
                    type: 'POST',
                    data: {
                        userId: userId
                    },
                    success: function (data) {
                        console.log('updateUserType data:'+data);
                        alert("更改成功！");
                        window.location.reload()
                    },
                    error: function () {
                        alert("更改失败！")
                    }
                })
            })
        });
    });
</script>
</body>
</html>
