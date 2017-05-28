<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>出库信息</title>
    <base href="<%=basePath%>">
    <style type="text/css">
        td {text-align:center;padding:5px;margin:5px;}
        tr {line-height: 175%;}
        table {width:1000px;font-size: x-large }
    </style>
</head>
<body>
<h1 align="center">出库信息列表</h1>
<table align="center">
    <tr>
        <th>出库信息编号</th>
        <th>订单号</th>
        <th>业务员</th>
        <th>批次号</th>

    </tr>
    <s:iterator value="pageOfShipments.data" var="it">
        <tr>
            <td><s:property value="#it.id"/> </td>
            <td><s:property value="#it.order_form.order_no"/></td>
            <td><s:property value="#it.clerk"/></td>
            <td><s:property value="#it.batch.batch_no"/></td>

            <br />

        </tr>
    </s:iterator>
</table>
<jsp:include page="/common/page.jsp">
    <jsp:param name="url" value="/shipment/selectShipments.action"/>
</jsp:include>
</body>
</html>
