<%--
  Created by IntelliJ IDEA.
  User: LCQ
  Date: 2017/5/21
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<h1>入库</h1>
<s:form action="saveAction" method="POST"  namespace="/purchase" theme="simple" enctype="multipart/form-data">
    <s:label value="批次:"/>
    <s:select list="batchOption" listKey="id" listValue="name" name="batch.id" headerKey="0" headerValue="--请选择批次--"/>
    <br/>
    <s:label value="业务员名称:"/>
    <s:select list="clerkOption" listKey="id" listValue="name" name="clerk.id" headerKey="0" headerValue="--请选择业务员--"/>
    <br/>
    <s:label value="订单:"/>
    <s:select list="orderOption" listKey="id" listValue="name" name="order.id" headerKey="0" headerValue="--请选择订单--"/>
    <br/>
    <s:submit value="提交"/>
    <s:reset value="重置"/>
</s:form>