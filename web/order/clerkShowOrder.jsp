<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>订单列表查看</title>
    <base href="<%=basePath%>">
    <style type="text/css">
        td {text-align:center;padding:5px;margin:5px;}
        tr {line-height: 175%;}
        table {width:1000px;font-size: x-large }
    </style>
</head>
<body>
<h1 align="center">订单列表</h1>
<table align="center">
    <tr>
        <th>编号</th>
        <th>订单号</th>
        <th>型号</th>
        <th>客户</th>
        <th>总价</th>
        <th>下单时间</th>
        <th>数量</th>
        <th>订单状态</th>
        <th>业务员</th>
    </tr>

    <s:iterator value="pageBean.data" var="it">
        <tr>
            <td><s:property value="#it.id"/> </td>
            <td><s:property value="#it.order_no"/></td>
            <td><s:property value="#it.model.model"/></td>
            <td><s:property value="#it.receiver.name"/></td>
            <td><s:property value="#it.price"/></td>
            <td><s:property value="#it.date"/></td>
            <td><s:property value="#it.quantity"/></td>
            <td><s:property value="#it.status"/></td>
            <td><s:property value="#it.clerk.name"/></td>
        </tr>
    </s:iterator>
</table>
<jsp:include page="/common/page.jsp">
    <jsp:param name="url" value="/order/selectOrder.action?status=${requestScope.status}&client=${requestScope.client}"/>
</jsp:include>
</body>
</html>
