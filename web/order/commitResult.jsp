<%--
  Created by IntelliJ IDEA.
  User: ymcvalu
  Date: 2017/5/26
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>支付结果</title>
    <script>

        window.onload=function () {
            setTimeout(function () {
                window.location.href="<%=basePath%>/order/requesAdd"
            },3000)
        }

    </script>
</head>
<body>
    <h1 align="center"><s:property value="msg"/> </h1>
</body>
</html>
