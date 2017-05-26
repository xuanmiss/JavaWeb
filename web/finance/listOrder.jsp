<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>销售业绩</title>
    <base href="<%=basePath%>">
    <style type="text/css">
        td {text-align:center;padding:5px;margin:5px;}
        tr {line-height: 175%;}
        table th,td{width:1000px;font-size: large;border:1px solid #CCCCCC; }
        table td{text-align:center;vertical-align:center;}
    </style>
</head>
<body>
<h1 align="center">销售业绩</h1>
<table align="center">
    <tr>
        <th>订单号</th>
        <th>型号</th>
        <th>业务员</th>
        <th>客户</th>
        <th>下单时间</th>
        <th>总价</th>
        <th>数量</th>
        <th>状态</th>
    </tr>
    <s:iterator value="pageBean.data" var="it">
        <tr>
            <td><s:property value="#it.order_no"/> </td>
            <td><s:property value="#it.model.model"/></td>
            <td><s:property value="#it.clerk.name"/></td>
            <td><s:property value="#it.receiver.name"/></td>
            <td><s:date name="date" format="yyyy-MM-dd"/></td>
            <td><s:property value="#it.price"/></td>
            <td><s:property value="#it.quantity"/></td>
            <td>
                <s:if test="#it.status==0">已取消</s:if>
                <s:elseif test="#it.status==1">待付款</s:elseif>
                <s:elseif test="#it.status==2">待出库</s:elseif>
                <s:else>已完成</s:else>
            </td>
        </tr>
    </s:iterator>
</table>


<jsp:include page="/common/page.jsp">
    <jsp:param name="url" value="/finance/selectOrder.action"/>
</jsp:include>
</body>
</html>
