<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>新增品牌</title>
    <base href="<%=basePath%>">
    <style type="text/css">
        .textarea {width:300px;height:200px;resize:none;}
    </style>
</head>
<body>
    <s:form action="addBrand.action" method="POST"  namespace="/brand" theme="simple" enctype="multipart/form-data">
        <s:fielderror fieldName="name" style="color:red"/>
        <s:label value="品牌名:"/>
        <s:textfield name="brand.name" />
        <br />
        <s:fielderror fieldName="supplier" style="color:red"/>
        <s:label value="供应商:"/>
        <s:textfield name="brand.supplier"/>
        <br />
        <s:fielderror fieldName="description" style="color:red"/>
        <s:label value="品牌描述:"/>
        <br />
        <s:textarea name="brand.description" class="textarea"/>
        <br />
        <s:fielderror fieldName="logo" style="color:red"/>
        <s:label value="logo:"/>
        <s:file name="logo" />
        <br/>
        <s:submit value="提交"/>
        <s:reset value="重置"/>
    </s:form>
</body>
</html>
