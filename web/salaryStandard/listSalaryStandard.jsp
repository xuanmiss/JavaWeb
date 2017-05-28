<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>薪资标准查看</title>
    <base href="<%=basePath%>">
    <style type="text/css">
        td {text-align:center;padding:5px;margin:5px;}
        tr {line-height: 175%;}
        table th,td{width:1000px;font-size: large;border:1px solid #CCCCCC; }
        table th,td{text-align:center;vertical-align:center;}
    </style>
</head>
<body>
<h1 align="center">薪资标准列表</h1>
<table align="center">
    <tr>
        <th>编号</th>
        <th>基础工资</th>
        <th>提成</th>
        <th>描述</th>
        <th>操作</th>
    </tr>
    <s:iterator value="pageBean.data" var="it">
        <tr>
            <td><s:property value="#it.id"/> </td>
            <td><s:property value="#it.basicSalary"/></td>
            <td><s:property value="#it.commission"/></td>
            <td><s:property value="#it.description"/></td>
            <td><a href="/salaryStandard/findByIdSalaryStandard.action?id=<s:property value="#it.id"/>">修改</a> <a href="/salaryStandard/deleteSalaryStandard.action?id=<s:property value="#it.id"/>">删除</a></td>
        </tr>
    </s:iterator>
</table>
<jsp:include page="/common/page.jsp">
    <jsp:param name="url" value="/salaryStandard/selectSalaryStandard.action"/>
</jsp:include>
</body>
</html>
