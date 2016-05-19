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
    <title>成绩录入</title>
    <link href="../css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <script src="../js/jquery-2.2.3.min.js" type="text/javascript"></script>
    <script src="../js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<nav class="nav navbar-default navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="mainPage" class="navbar-brand">
                <img src="../picture/logo.jpg" style="height:50px; margin-top: -15px"/>
            </a>
        </div>

        <ul class="nav navbar-nav">
            <li><a href="mainPage">首页</a> </li>
            <li><a href="teacherNews">通知公告</a></li>
            <li><a href="teacherCourse">课程管理</a></li>
            <li  class="active"><a href="teacherGrade">成绩管理</a></li>
            <li><a href="teacherInfo">个人信息</a></li>
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
    <h1 class="text-center">${courseName}的成绩如下</h1>
    <table class="table">
        <tr>
            <th>课程编号</th>
            <th>学号</th>
            <th>学生姓名</th>
            <th>成绩</th>
            <th>操作</th>
        </tr>
        <c:forEach var="studentCourse"  items="${gradeForTeachers}">
            <tr >
                <form action="/main/updateGrade" method="post">
                    <td><input name="courseId" value="${courseId}" type="text" readonly style="border: 0"/> </td>
                    <td><input name="stuId" value="${studentCourse.stuId}" type="text" readonly style="border: 0"/></td>
                    <td><input value="${studentCourse.stuName}" type="text" readonly style="border: 0"/> </td>
                    <td><input name="grade" value="${studentCourse.grade}" class="form-control"/></td>
                    <td><input class="btn btn-primary" type="submit" value="提交" /></td>
                </form>

            </tr>
        </c:forEach>
    </table>


</div>

</body>
</html>
