<%--
  Created by IntelliJ IDEA.
  User: ymcvalu
  Date: 2017/5/4
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>瓷砖销售管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link  href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="bootstrap/js/util.js"></script>
    <script src="bootstrap/js/selectEnhance.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <![endif]-->
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
    </script>
    <style type="text/css">
        body {
            background: #f8f6e9;
        }

        .mycenter{
            margin-top: 100px;
            margin-left: auto;
            margin-right: auto;
            height: 350px;
            width:500px;
            padding: 5%;
            padding-left: 5%;
            padding-right: 5%;
        }
        .mycenter mysign{
            width: 440px;
        }
        .mycenter input,checkbox,button{
            margin-top:2%;
            margin-left: 10%;
            margin-right: 10%;
        }
        .mycheckbox{
            margin-top:10px;
            margin-left: 40px;
            margin-bottom: 10px;
            height: 10px;
        }
    </style>
</head>

<body>
<s:form action="login.action" namespace="/" theme="simple">
    <div class="mycenter">
        <div class="mysign">
            <div class="col-lg-11 text-center text-info">
                <h2>请登录</h2>
            </div>
            <div class="col-lg-10">
                <input type="text" class="form-control" name="username" placeholder="请输入账户名" required autofocus/>
            </div>
            <div class="col-lg-10"></div>
            <div class="col-lg-10">
                <input type="password" class="form-control" name="password" placeholder="请输入密码" required autofocus/>
            </div>
            <div class="col-lg-10"></div>
            <div class="col-lg-10 mycheckbox checkbox">
                <input type="checkbox" class="col-lg-1">记住密码</input>
            </div>
            <div class="col-lg-10"></div>
            <div class="col-lg-10">
                <s:submit class="btn btn-success col-lg-12" value="登陆"/>
            </div>
        </div>
</div>
</s:form>
</body>
</html>
