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
<table align="center" width="100%">
    <tr>
        <td>编号</td>
        <td>批次</td>
        <td>业务员</td>
        <td>订单号</td>
        <td>操作</td>
    </tr>
    <s:iterator value="pageBean.data" var="it" status="st">
        <td><s:property value="it.id"/></td>
        <td><s:property value="it.batch"/></td>
        <td><s:property value="it.clerk"/></td>
        <td><s:property value="it.order_form"/></td>
        <td><a href="/purchase/formAction.action">新增入库</a></td>
    </s:iterator>
</table>
<jsp:include page="/common/page.jsp">
    <jsp:param name="url" value="/purchase/selectAction.action"/>
</jsp:include>

</body>
