<%--
  Created by IntelliJ IDEA.
  User: Leeyy
  Date: 2019/7/31
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>本帖详情</title>

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
            <a class="navbar-brand" href="${pageContext.request.contextPath}/post/postInfo.jsp">贴吧LOGO</a>
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
                        Annerial <span class="caret"></span>
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
        <h2>${postInfo[0].postTitle}</h2>
        <p>${postInfo[0].postContent}</p>
</div>
</div>

<div class="container">
    <div class="row">
        <span><h4>${postDetailMsg}</h4></span>
        <c:forEach var="detailItem" items="${details}" varStatus="status">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-9">
                        <h4><small><span class="label label-info">${status.index + 1}楼</span></small> ${detailItem.detailTitle}</h4>
                        <p>${detailItem.detailContent}</p>
                    </div>
                    <div class="col-md-3" style="text-align: right;">
                        <span class="label label-warning detail-delete" style="cursor:pointer" data-toggle="modal" data-target="#deletePartPostModal" title="${detailItem.detailId}">删除</span>
                    </div>
                </div>
                <hr>
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

<!-- 删除此楼层 -->
<div class="modal fade" id="deletePartPostModal" tabindex="-1" role="dialog" aria-labelledby="deletePartPost">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="deletePartPost">删除子贴</h4>
            </div>
            <div class="modal-body">
                <p>确定删除此楼层？</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="cfmDeleteDetail">确定</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.10.2.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function(){
        $("span.detail-delete").click(function () {
            console.log($(this).attr("title"));
            var detailId = $(this).attr("title");

            $("#cfmDeleteDetail").click(function () {
                $.ajax({
                    url: '/miniPost/postView?method=deleteDetailById',
                    type: 'POST',
                    data: {
                        detailId: detailId
                    },
                    success: function (data) {
                        console.log('cfmDeleteDetail data:'+data);
                        alert("删除成功！");
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
