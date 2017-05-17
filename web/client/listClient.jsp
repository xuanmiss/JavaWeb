<%--
  Created by IntelliJ IDEA.
  User: miss
  Date: 2017/5/16
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>客户信息</title>
    <base href="<%=basePath%>">
    <style type="text/css">
        td {text-align:center;padding:5px;margin:5px;}
        tr {line-height: 175%;}
        table {width:1000px;font-size: x-large }
    </style>
</head>
<body>
<h1 align="center">客户列表</h1>
<table align="center">
    <tr>
        <th>客户ID</th>
        <th>客户姓名</th>
        <th>手机号码</th>
        <th>地址</th>
        <th>操作</th>
    </tr>
    <s:iterator value="pageBean.data" var="it">
        <tr>
            <td><s:property value="#it.id"/> </td>
            <td><s:property value="#it.name"/></td>
            <td><s:property value="#it.phone"/></td>
            <td><s:property value="#it.address"/></td>
            <td><a href="/client/clientupdate.action?clientId=<s:property value="#it.id"/>">修改</a>
                <a href="/client/clientdelete.action?clientId=<s:property value="#it.id"/>">删除</a></td>
        </tr>
    </s:iterator>
</table>
<jsp:include page="/common/page.jsp">
    <jsp:param name="url" value="/client/selectClient.action"/>
</jsp:include>
</body>
</html>
