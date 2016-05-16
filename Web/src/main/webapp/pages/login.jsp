<%--
  Created by IntelliJ IDEA.
  User: lijie
  Date: 2016/5/10
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="../css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <script src="../js/jquery-2.2.3.min.js" type="text/javascript"></script>
    <script src="../js/bootstrap.min.js" type="text/javascript"></script>

</head>
<body>
<div class="container">
    <h1 class="page-header text-center"  ${loginErrorShow}>账户名或密码错误，请重新登录</h1>
    <h1 class="page-header text-center"  ${noLoginErrorShow}>请登录</h1>
    <div class="col-md-12 col-md-offset-4 ">
        <form id="loginForm" action="/login/login" method="post" class="form-horizontal">
            <div class="form-group">
                <div class="col-md-5 col-md-pull-0">
                    <input id="userId" name="id" type="text" class="form-control" placeholder="账户名"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-5">
                    <input id="passwd" name="passwd" type="password" class="form-control" placeholder="密码"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-5">
                    <button  class="btn btn-lg btn-primary btn-block" onclick="submitForm()">登   录</button>
                </div>
            </div>
        </form>
    </div>

</div>
<script>
    function submitForm(){
        var result = document.getElementById("userId").value;
        var password = document.getElementById("passwd").value;
        if(result == ""  ){
            alert("用户名不能为空");
            return false;
        }
        if(password == ""  ){
            alert("密码不能为空");
            return false;
        }
        document.getElementById("loginForm").submit();
    }
</script>

</body>
</html>