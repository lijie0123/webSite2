<%--
  Created by IntelliJ IDEA.
  User: lijie
  Date: 2016/5/15
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <link href="../css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <script src="../js/jquery-2.2.3.min.js" type="text/javascript"></script>
    <script src="../js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<nav class="nav navbar-default navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="mainPage" class="navbar-brand">
                <img src="../picture/lijie.png" style="height:50px; margin-top: -15px"/>
            </a>

        </div>
        <ul class="nav navbar-nav">
            <li><a href="#">通知公告</a></li>
            <li><a href="#">课程查询</a></li>
            <li><a href="#">成绩查询</a></li>
            <li><a href="studentInfo">个人信息</a></li>
        </ul>
        <div class="navbar-right">
            <a href="/logout" class="center-block">
                <button class="btn-primary">
                    注销登录
                </button>
            </a>
        </div>
    </div>
</nav>

<!--nav bar is 50px height-->
<div style="height:50px;"></div>
<div class="container">
    <h1 class="text-center">欢迎你 ${name} !</h1>
</div>

</body>
</html>
