<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title align="center" font-size="20px">业务列表</title>
    <base href="<%=basePath%>">
    <style type="text/css">
        table {
            font-family: verdana,arial,sans-serif;
            font-size:11px;
            color:#333333;
            border-width: 1px;
            border-color: #999999;
            border-collapse: collapse;
        }
         th {
            background:#b5cfd2;
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #999999;
        }
         td {
            background:#dcddc0;
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #999999;
        }
    </style>
</head>
<body>
    <h1 align="center" >业务列表</h1>
    <table align="center" width="100%">
        <tr>
            <td>业务编码</td>
            <td>业务员姓名</td>
            <td>推广业务</td>
            <td>业务开始时间</td>
            <td>业务状态</td>
            <td>操作</td>
        </tr>
        <s:iterator value="pageBean.data" var="it" status="st">
            <tr>
                <td><s:property value="#it.id"/></td>
                <td><s:property value="#it.clerk"/></td>
                <td><s:property value="#it.brand"/></td>
                <td><s:property value="#it.date"/></td>
                <td><s:if test="#it.status==1">进行中</s:if>
                    <s:else>结束</s:else>
                </td>
                <td><a href="/clerkBrand/beginAction.action?id=<s:property value="#it.id"/>">开始</a>
                    <a href="/clerkBrand/stopAction.action?id=<s:property value="#it.id"/>">暂停</a>
                    <a href="/clerkBrand/removeAction.action?id=<s:property value="#it.id"/>">删除</a>
                </td>

            </tr>
        </s:iterator>
    </table>
    <jsp:include page="/common/page.jsp">
        <jsp:param name="url" value="/clerkBrand/selectAction.action"/>
    </jsp:include>

</body>
