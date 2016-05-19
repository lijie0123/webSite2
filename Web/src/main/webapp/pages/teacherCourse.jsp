<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lijie
  Date: 2016/5/16
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程查询</title>
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
            <li><a>通知公告</a></li>
            <li class="active"><a href="teacherCourse">课程查询</a></li>
            <li><a >成绩查询</a></li>
            <li><a >个人信息</a></li>
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

<!--nav bar is 50px height-->
<div style="height:50px;"></div>

<div class="container">
    <h1 class="text-center">你的授课如下</h1>
    <table class="table">
        <tr>
            <th>课程名</th>
            <th>课程描述</th>
            <th>开始时间</th>
            <th>结束时间</th>
        </tr>
        <c:forEach var="course"  items="${courses}">
            <tr >
                <td>${course.name}</td>
                <td>${course.description}</td>
                <td>${course.startDate}</td>
                <td>${course.endDate}</td>
                <td><button onclick="location='deleteCourseById?id=${course.id}'">delete</button></td>
            </tr>
        </c:forEach>
    </table>


</div>

</body>
</html>
