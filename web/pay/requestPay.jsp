<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ymcvalu
  Date: 2017/5/26
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>支付界面</title>
    <base href="<%=basePath%>">
    <script>
        window.onload=function () {
            setTimeout(function () {
                window.location.href="/alipay/handlePay?orderNo=<s:property value="orderNo"/>&amount=<s:property value="amount"/>"
            },3000)
        }
    </script>
</head>
<body>
    <h1 align="center">支付页面</h1>
    <div align="center">
        <img src="resources/images/pay.png" width="300px" height="300px">
    </div>
    <h3 align="center">请扫码支付</h3>
</body>
</html>
