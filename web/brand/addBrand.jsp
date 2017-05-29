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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
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
</head>
<body>
<div class = "col-xs-12 col-sm-6 col-md-4 col-lg-3">
    <h2>添加品牌</h2>
    <s:form action="addBrand.action" method="POST"  namespace="/brand" theme="simple" enctype="multipart/form-data">
        <div class="form-group">
        <s:fielderror fieldName="name" style="color:red"/>
        <s:label value="品牌名:"/>
        <s:textfield class="form-control" name="brand.name" />
        </div>
        <div class="form-group">
        <s:fielderror fieldName="supplier" style="color:red"/>
        <s:label value="供应商:"/>
        <s:textfield class="form-control" name="brand.supplier"/>
        </div>
        <div class="form-group">
        <s:fielderror  fieldName="description" style="color:red"/>
        <s:label value="品牌描述:"/>
        <s:textarea name="brand.description" style="resize:none;" class="form-control" />
        </div>
    <div class="form-group">
        <s:fielderror   fieldName="logo" style="color:red"/>
        <s:label value="logo:"/>
        <s:file name="logo" />
    </div>
        <s:submit class="btn-info btn-lg" value="提交"/>
        <s:reset class="btn-info btn-lg" value="重置"/>
    </s:form>
</div>
</body>
</html>
