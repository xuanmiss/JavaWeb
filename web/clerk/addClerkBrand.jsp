<%@ page import="entity.Clerk" %>
<%@ page import="java.util.List" %>
<%@ page import="util.PageBean" %>
<%@ page import="entity.Brand" %><%--
  Created by IntelliJ IDEA.
  User: LCQ
  Date: 2017/5/15
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--表单下拉菜单栏显示数据库数据（尚未实现）--%>
    <s:form action="saveAction" method="POST">
        <s:radio name="clerkBrand.status" label="请选择业务状态" labelposition="top"
        list="#{'0':'暂停','1':'进行'}" listKey="key" listValue="value"/>
        </br>
        <s:submit value="提交"/>
        <s:reset value="取消"/>
    </s:form>
</body>
</html>
