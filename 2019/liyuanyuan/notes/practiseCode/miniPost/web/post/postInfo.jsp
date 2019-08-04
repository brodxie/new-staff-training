<%--
  Created by IntelliJ IDEA.
  User: Leeyy
  Date: 2019/7/31
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>贴吧首页</title>

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
            <a class="navbar-brand" href="postInfo.jsp">贴吧LOGO</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <form class="navbar-form navbar-right">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="输入内容...">
                    <span class="input-group-btn">
                  <button class="btn btn-default" type="button">搜索</button>
                </span>
                </div>
                <!-- Single button -->
                <div class="btn-group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ${username} <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">个人中心</a></li>
                        <li><a href="/miniPost/userManage?method=getAllUserInfo">用户管理</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/index.jsp">退出登录</a></li>
                    </ul>
                </div>
            </form>
        </div>
    </div>
</nav>

<div class="jumbotron">
    <div class="container">
        <h2>这是广告</h2>
        <p>广告宣传页，(～￣▽￣)～广告宣传页，(～￣▽￣)～广告宣传页，(～￣▽￣)～广告宣传页，(～￣▽￣)～广告宣传页，(～￣▽￣)～广告宣传页，(～￣▽￣)～广告宣传页，(～￣▽￣)～广告宣传页，(～￣▽￣)～广告宣传页，(～￣▽￣)～广告宣传页，(～￣▽￣)～广告宣传页，(～￣▽￣)～广告宣传页，(～￣▽￣)～广告宣传页，(～￣▽￣)～广告宣传页，(～￣▽￣)～广告宣传页，(～￣▽￣)～广告宣传页，(～￣▽￣)～广告宣传页，(～￣▽￣)～广告宣传页，(～￣▽￣)～广告宣传页，(～￣▽￣)～</p>
        <a class="btn btn-default btn-md" href="#" role="button">了解一下 &raquo;</a>
    </div>
</div>

<div class="container">
    <div class="row">
        <c:forEach var="postItem" items="${postInfos}" varStatus="status">
            <div class="col-md-4 post-delete">
                <a href="/miniPost/postView?method=listDetailByPostId&postId=${postItem.postId}"><h3>${postItem.postTitle} &raquo;</h3></a>
                <p>${postItem.postContent}</p>
                <span class="glyphicon glyphicon-user" style="cursor:pointer;color: #66afe9;">${postItem.userName}</span>&nbsp;&nbsp;&nbsp;
                <span class="label label-info post-delete" style="cursor:pointer;" data-toggle="modal" data-target="#deletePostModal" title="${postItem.postId}">--</span>
            </div>
        </c:forEach>
    </div>

    <nav aria-label="...">
        <ul class="pager">
            <li class="previous"><a href="#"><span aria-hidden="true">&larr;</span> 上一页</a></li>
            <li class="next"><a href="#">下一页 <span aria-hidden="true">&rarr;</span></a></li>
        </ul>
    </nav>

    <hr>

    <footer>
        <p>&copy; 2019 Company, Inc.</p>
    </footer>
</div>

<!-- 删除帖子 -->
<div class="modal fade" id="deletePostModal" tabindex="-1" role="dialog" aria-labelledby="deletePost">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="deletePost">删除帖子</h4>
            </div>
            <div class="modal-body">
                <p>确定删除此条帖子？</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="cfmDeletePost">确认</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.10.2.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function(){
        $("span.post-delete").click(function () {
            console.log($(this).attr("title"));
            var postId = $(this).attr("title");

            $("#cfmDeletePost").click(function () {
                $.ajax({
                    url: '/miniPost/postView?method=deletePostById',
                    type: 'POST',
                    data: {
                        postId: postId
                    },
                    success: function (data) {
                        console.log('cfmDeletePost data:'+data)
                        alert("删除成功！")
                        window.location.reload()
                    },
                    error: function () {
                        alert("删除失败！")
                    }
                })
            })
        });
    });
</script>

</body>
</html>
