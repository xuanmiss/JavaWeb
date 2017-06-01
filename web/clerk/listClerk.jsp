<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>业务员查看</title>
    <base href="<%=basePath%>">
    <style type="text/css">
        td {text-align:center;padding:5px;margin:5px;}
        tr {line-height: 175%;}
        table {width:1000px;font-size: x-large }
    </style>
</head>
<body>
<h1 align="center">业务员列表</h1>
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
            <td><s:property value="#it.name"/></td>
            <td><s:if test="#it.sex=='m'">男</s:if><s:else>女</s:else></td>
            <td><s:property value="#it.identity"/></td>
            <td>

                <a href="/clerk/clerk_update.action?clerkId=<s:property value="#it.id"/>">修改</a>
                <a href="/clerk/clerk_delete.action?clerkId=<s:property value="#it.id"/>">删除</a>
            </td>
            <br />

        </tr>
    </s:iterator>
</table>
<jsp:include page="/common/page.jsp">
    <jsp:param name="url" value="/clerk/clerk_select.action"/>
</jsp:include>
</body>
</html>
