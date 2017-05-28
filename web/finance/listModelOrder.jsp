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
    <link rel="stylesheet" href="resources/css/fontsite.css">
    <script type="text/javascript">
        window.onload=function () {
            ms = $$("selectModel");
            ms.selectedIndex=<s:property value="modelId-1"/>;
        }
        function loadModel() {
            ms = $$("selectModel");
            si = ms.selectedIndex;
            mid = ms.options[si].value;
            window.location.href="/finance/getModelOrder.action?modelId="+mid;
        }
    </script>
    <style type="text/css">
        td {text-align:center;padding:5px;margin:5px;}
        tr {line-height: 175%;}
        table th,td{width:1000px;font-size: large;border:1px solid #CCCCCC; }
        table th,td{text-align:center;vertical-align:center;}
    </style>
</head>
<body>
<h1 align="center">瓷砖型号销售业绩</h1>
<div id="selModel" style="text-align: right;right:10px">
    <s:label value="选择瓷砖型号：" />
    <s:select id="selectModel" name="model.id" list="models" listKey="id" listValue="model"/>
    <button type="button" class="btn btn-default" onclick="loadModel()">查看</button>
    <% //<input id="modelId" name="modelId" value="<s:property value="modelId"/>"/> %>
    <br/>
</div>
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
    <jsp:param name="url" value="/finance/getModelOrder.action"/>
</jsp:include>
</body>
</html>
