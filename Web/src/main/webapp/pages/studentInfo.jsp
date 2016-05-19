<%--
  Created by IntelliJ IDEA.
  User: lijie
  Date: 2016/5/16
  Time: 0:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
    <link href="../css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <script src="../js/jquery-2.2.3.min.js" type="text/javascript"></script>
    <script src="../js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<nav class="nav navbar-default navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="mainPage" class="navbar-brand">
                <img src="../picture/logo.png" style="height:50px; margin-top: -15px"/>
            </a>

        </div>
        <ul class="nav navbar-nav">
            <li><a href="mainPage">首页</a> </li>
            <li><a href="studentNews">通知公告</a></li>
            <li><a href="studentCourse">课程查询</a></li>
            <li><a href="studentGrade">成绩查询</a></li>
            <li class="active"><a href="studentInfo">个人信息</a></li>
        </ul>
        <div class="navbar-right">
            <a href="/logout" class="center-block">
                <button class="btn btn-primary">
                    注销登录
                </button>
            </a>
        </div>
    </div>
</nav>
<div style="height: 50px"></div>

<div class="container">
    <h1 class="text-center">你的个人信息如下:</h1>
    <div class="col-md-6 col-md-offset-3">
        <ul class="list-group">
            <li class="list-group-item">账户名: <span class="pull-right">${accountId}</span> </li>
            <li class="list-group-item">姓名: <span class="pull-right">${name}</span> </li>
            <li class="list-group-item">性别:<span class="pull-right">${sex}</span></li>
            <li class="list-group-item">学号:<span class="pull-right">${stuId}</span></li>
            <li class="list-group-item">出生日期:<span class="pull-right">${birthday}</span></li>
            <li class="list-group-item">入学日期:<span class="pull-right">${moveInDay}</span></li>
        </ul>
    </div>
</div>
</body>
</html>
