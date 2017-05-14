<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%--
  Created by IntelliJ IDEA.
  User: chenshihong
  Date: 2017/5/14
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增品牌</title>
    <base href="<%=basePath%>">
    <style type="text/css">
        .textarea {width:300px;height:200px;resize:none;}
    </style>
</head>
<body>
<s:form action="carryUpdateBrand.action" method="POST"  namespace="/brand" theme="simple" enctype="multipart/form-data">
    <input type="hidden" name="brand.id" value="<s:property value="brand.id"/>"/>
    <s:fielderror fieldName="name" style="color:red"/>
    <s:label value="品牌名:"/>
    <s:textfield name="brand.name" />
    <br />
    <s:fielderror fieldName="supplier" style="color:red"/>
    <s:label value="供应商:"/>
    <s:textfield name="brand.supplier" />
    <br />
    <s:fielderror fieldName="description" style="color:red"/>
    <s:label value="品牌描述:"/>
    <br />
    <s:textarea name="brand.description"  class="textarea"/>
    <br />
    <s:fielderror fieldName="logo" style="color:red"/>
    <s:label value="logo:"/>
    <img src="<s:property value="brand.logo"/>" width="80" height="80">
    <input type="hidden" name="brand.logo" value="<s:property value="brand.logo"/>"/>
    <s:file name="logo" />
    <br/>
    <s:label value="创建时间:"/>
    <s:date name="brand.date" format="yyyy-MM-dd"/>
    <input type="hidden" name="brand.date" value="<s:property value="brand.date"/>"/>
    <br/>
    <s:radio list="#{'0':'在市','1':'下市'}" name="brand.status" />
    <br/>
    <s:submit value="提交"/>
    <s:reset value="重置"/>
</s:form>
</body>
</html>
