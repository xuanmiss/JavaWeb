<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>业务员查看</title>
    <base href="<%=basePath%>">
    <style type="text/css">
        td {text-align:center;padding:5px;margin:5px;}
        tr {line-height: 175%;}
        table {width:1000px;font-size: x-large }
    </style>
</head>
<body>
<h1 align="center">业务员列表</h1>
<table align="center">
    <tr>
        <th>业务员编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>身份证号</th>
        <th>住址</th>
        <th>生日</th>
        <th>手机号码</th>
        <th>状态</th>
        <th>职位</th>
        <th>入职时间</th>
        <th>工资卡卡号</th>
    </tr>
    <% String tmpS = null;
       request.setAttribute("tmpS", tmpS);
    %>
    <s:iterator value="pageBean.data" var="it">
        <tr>
            <td><s:property value="#it.id"/> </td>
            <td><s:property value="#it.name"/></td>
            <td><s:property value="#it.sex"/></td>
            <td><s:property value="#it.identity"/></td>
            <td><s:property value="#it.address"/></td>
            <s:if test="#sex==1">#requset.tmpS="男"</s:if>
            <s:else>#request.tmpS="女"</s:else>
            <td><s:property value="#request.tmpS"/></td>
            <td><s:property value="#it.identity"/></td>
            <td><s:property value="#it.address"/></td>
            <td><s:date name="birthday" format="yyyy-MM-dd"/></td>
            <td><s:property value="#it.phone"/></td>
            <td><s:property value="#it.status"/></td>
            <td><s:property value="#it.duties"/></td>
            <td><s:property value="#it.entry_time"/></td>
            <td><s:property value="#it.salary_card"/></td>
            </tr>
    </s:iterator>
</table>
<jsp:include page="/common/page.jsp">
    <jsp:param name="url" value="/clerk/selectClerk.action"/>
</jsp:include>
</body>
</html>
