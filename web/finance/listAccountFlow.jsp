<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>账户明细</title>
    <base href="<%=basePath%>">
    <style type="text/css">
        td {text-align:center;padding:5px;margin:5px;}
        tr {line-height: 175%;}
        table th,td{width:1000px;font-size: large;border:1px solid #CCCCCC; }
        table td{text-align:center;vertical-align:center;}
    </style>
</head>
<body>
<h2 align="center">流动资金：<s:property value="account.flow"/> RMB </h2>
<h2 align="center">固有资产：<s:property value="account.fixed"/> RMB </h2>
<table align="center">
    <tr>
        <th>流水单号</th>
        <th>金额</th>
        <th>负责人</th>
        <th>流水描述</th>
        <th>类型</th>
        <th>时间</th>
    </tr>
    <s:iterator value="pageBean.data" var="it">
        <tr>
            <td><s:property value="#it.id"/> </td>
            <td>
                <s:property value="#it.amount"/>
            </td>
            <td><s:property value="#it.clerk.name"/></td>
            <td><s:property value="#it.description"/></td>
            <td>
                <s:if test="#it.type==1">订货支出</s:if>
                <s:elseif test="#it.type==2">订单收入</s:elseif>
                <s:else>工资支出</s:else>
            </td>
            <td><s:date name="date" format="yyyy-MM-dd"/></td>
        </tr>
    </s:iterator>
</table>


<jsp:include page="/common/page.jsp">
    <jsp:param name="url" value="/finance/account.action"/>
</jsp:include>
</body>
</html>
