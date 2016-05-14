<%--
  Created by IntelliJ IDEA.
  User: lj
  Date: 16-3-6
  Time: 上午4:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.* "%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>all</title>
</head>
<body>

<h1>已有的人</h1>

<table border="1">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>sex</td>
        <td>age</td>
        <td>desc</td>
        <td>action</td>
    </tr>
    <c:forEach var="person"  items="${persons}">
        <tr>
            <td>${person.id}</td>
            <td>${person.name}</td>
            <td>${person.sex}</td>
            <td>${person.age}</td>
            <td>${person.desc}</td>
            <td><button onclick="location='deleteById?id=${person.id}'">delete</button></td>


        </tr>
    </c:forEach>
</table>


<h1>添加新人</h1>
<form action="savePerson" method="post">
    <table >
        <tr>
            <label id="idR">
                <td><p>Id:</p></td>
                <td><input name="id" type="text"></td>
            </label>
        </tr>
        <tr>
            <label id="nameR">
                <td><p>name:</p></td>
                <td><input name="name" type="text"></td>
            </label>
        </tr>
        <tr>
            <label id="sexR">
                <td><p>sex:</p></td>
                <td><input name="sex" type="text"></td>
            </label>
        </tr>
        <tr>
            <label id="ageR">
                <td><p>age:</p></td>
                <td><input name="age" type="text"></td>
            </label>
        </tr>
        <tr>
            <label id="descR">
                <td><p>desc:</p></td>
                <td><input name="desc" type="text"></td>
            </label>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="add">
            </td>
        </tr>

    </table>

</form>

</body>
</html>
