<%--
  Created by IntelliJ IDEA.
  User: LCQ
  Date: 2017/5/21
  Time: 13:39
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
    <title align="center" font-size="20px">入库记录表</title>
    <base href="<%=basePath%>">
    <style type="text/css">
        table {
            font-family: verdana,arial,sans-serif;
            font-size:11px;
            color:#333333;
            border-width: 1px;
            border-color: #999999;
            border-collapse: collapse;
        }
        th {
            background:#b5cfd2;
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #999999;
        }
        td {
            background:#dcddc0;
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #999999;
        }
    </style>
</head>
<body>
<h1 align="center">入库记录表</h1>
<table align="center">
    <tr>
        <th>业务员编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>身份证号</th>
        <th>操作</th>
    </tr>
    <s:iterator value="pageBean.data" var="it">
        <tr>
            <td><s:property value="#it.id"/> </td>
            <td><s:property value="#it.batch"/></td>
            <td><s:property value="#it.clerk"/></td>
            <td><s:property value="#it.order_form"/></td>
            <td>
                <a href="/clerk/clerk_update.action?clerkId=<s:property value="#it.id"/>">修改</a>
                <a href="/clerk/clerk_delete.action?clerkId=<s:property value="#it.id"/>">删除</a>
            </td>
        </tr>
    </s:iterator>
</table>
<jsp:include page="/common/page.jsp">
    <jsp:param name="url" value="/purchase/selectAction.action"/>
</jsp:include>

</body>
