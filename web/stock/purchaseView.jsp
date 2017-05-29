<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>入库信息</title>
    <base href="<%=basePath%>">
    <style type="text/css">
        td {text-align:center;padding:5px;margin:5px;}
        tr {line-height: 175%;}
        table {width:1000px;font-size: x-large }
    </style>
</head>
<body>
<h1 align="center">入库信息列表</h1>
<table align="center">
    <tr>
        <th>入库信息编号</th>
        <th>订单号</th>
        <th>负责人</th>
        <th>批次号</th>
        <th>时间</th>
        <th>类型</th>
    </tr>
    <s:iterator value="pageOfPurchase.data" var="it">
        <tr>
            <td><s:property value="#it.id"/> </td>
            <td><s:property value="#it.order.order_no"/></td>
            <td><s:property value="#it.clerk"/></td>
            <td><s:property value="#it.batch.batch_no"/></td>
            <td><s:date name="#it.order.date" format="yyyy-MM-dd" /></td>
            <td><s:if test="#it.order.type==0">已取消</s:if>
                <s:elseif test="#it.order.type==1">待付款</s:elseif>
                <s:elseif test="#it.order.type==2">待付款已入库</s:elseif>
                <s:elseif test="#it.order.type==3">已付款待入库</s:elseif>
                <s:else>已入库完成</s:else>
            </td>
            <br />

        </tr>
    </s:iterator>
</table>
<jsp:include page="/common/page.jsp">
    <jsp:param name="url" value="/purchase/selectPurchase.action"/>
</jsp:include>
</body>
</html>
