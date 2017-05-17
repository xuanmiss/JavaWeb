<%--
  Created by IntelliJ IDEA.
  User: LCQ
  Date: 2017/5/15
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<s:form action="saveAction" method="POST"  namespace="/clerkBrand" theme="simple" enctype="multipart/form-data">

    <s:label value="业务员姓名:"/>
    <s:select list="clerkList" listKey="id" listValue="name" name="clerk.id" headerValue="--请选择业务员--"/>
    <br/>

    <s:label value="品牌名称:"/>
    <s:select list="brandList" listKey="id" listValue="name" name="brand.id" headerValue="--请选择品牌--"/>
    <br/>

    <s:label value="业务状态:" />
    <s:select list="# {'0':'暂停','1':'进行'}" listKey="key" listValue="value" name="clerkBrand.status" headerKey="0" headerValue="--请选择--"></s:select>
    <br/>
    <s:submit value="提交"/>
    <s:reset value="重置"/>
</s:form>
