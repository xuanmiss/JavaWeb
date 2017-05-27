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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link  href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="bootstrap/js/util.js"></script>
    <script src="bootstrap/js/selectEnhance.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <![endif]-->
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
    </script>
    <style type="text/css">
        td {text-align:center;padding:5px;margin:5px;}
        tr {line-height: 175%;}
        table th,td{width:1000px;font-size: large;border:1px solid #CCCCCC; }
        table th,td{text-align:center;vertical-align:center;}
    </style>
</head>
<body>
<div id="acc" style="text-align: left">
    <h2 align="center">流动资金：<s:property value="account.flow"/> RMB </h2>
    <h2 align="center">固有资产：<s:property value="account.fixed"/> RMB </h2>
</div>
<div>
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
</div>

<jsp:include page="/common/page.jsp">
    <jsp:param name="url" value="/finance/account.action"/>
</jsp:include>
</body>
</html>
