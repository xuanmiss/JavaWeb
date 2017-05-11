<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>品牌查看</title>
    <base href="<%=basePath%>">
</head>
<body>
<h1 align="center">基金产品查询结果</h1>
<table align="center">
    <tr>
        <th>品牌编号</th>
        <th>品牌名</th>
        <th>品牌创建时间</th>
        <th>操作</th>
    </tr>
    <s:iterator value="pageBean.data" var="it">
        <tr>
            <td><s:property value="#it.id"/> </td>
            <td><s:property value="#it.name"/></td>
            <td><s:date name="date" format="yyyy-MM-dd"/></td>
            <td><a href="">管理</a> <a href="">查看</a></td>
        </tr>
    </s:iterator>
</table>
<jsp:include page="/common/page.jsp" />
</body>
</html>
