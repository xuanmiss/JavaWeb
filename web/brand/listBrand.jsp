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
    <style type="text/css">
        td {text-align:center;padding:5px;margin:5px;}
        tr {line-height: 175%;}
        table {width:1000px;font-size: x-large }
    </style>
</head>
<body>
<h1 align="center">品牌列表</h1>
<table align="center">
    <tr>
        <th>品牌编号</th>
        <th>品牌logo</th>
        <th>品牌名</th>
        <th>品牌创建时间</th>
        <th>操作</th>
    </tr>
    <s:iterator value="pageBean.data" var="it">
        <tr>
            <td><s:property value="#it.id"/> </td>
            <td><img src="<s:property value="logo"/>" width="75" height="75"></td>
            <td><s:property value="#it.name"/></td>
            <td><s:date name="date" format="yyyy-MM-dd"/></td>
            <td><a href="">管理</a> <a href="/brand/selectModel.action?brandId=<s:property value="#it.id"/>">查看</a></td>
        </tr>
    </s:iterator>
</table>
<jsp:include page="/common/page.jsp">
    <jsp:param name="url" value="/brand/selectBrand.action"/>
</jsp:include>
</body>
</html>
