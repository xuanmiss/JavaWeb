<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>新增品牌型号</title>
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
<h2><s:property value="brandName"/></h2>
<h3>新增型号</h3>
<s:form action="handleUpdateModel.action" method="POST"  namespace="/brand" theme="simple" enctype="multipart/form-data">
    <input type="hidden" name="model.brand.id" value="${requestScope.brandId}"/>
    <input type="hidden" name="model.id" value="<s:property value="model.id"/>"/>
    <div class="form-group">
    <s:fielderror fieldName="model" style="color:red"/>
    <s:label value="型号:"/>
    <s:textfield class="form-control" name="model.model" />
    </div>
    <div class="form-group">
    <s:fielderror fieldName="format" style="color:red"/>
    <s:label value="规格:"/>
    <s:textfield class="form-control" name="model.format"/>
    </div>
    <div class="form-group">
    <s:fielderror fieldName="color" style="color:red"/>
    <s:label value="花色:"/>
    <s:textfield class="form-control" name="model.color" />
    </div>
    <div class="form-group">
    <s:fielderror fieldName="in_price" style="color:red"/>
    <s:label value="进价:"/>
    <s:textfield class="form-control" name="model.in_price"/>
    </div>
    <div class="form-group">
    <s:fielderror fieldName="sale_price" style="color:red"/>
    <s:label value="单价:"/>
    <s:textfield class="form-control" name="model.sale_price"/>
    </div>
    <div class="form-group">
    <s:fielderror fieldName="image" style="color:red"/>
    <s:label value="照片:"/>
    <img src="<s:property value="model.image"/>" width="100" height="100">
    <input type="hidden" name="model.image" value="<s:property value="model.image"/>"/>
    <s:file name="image"/>
    </div>
    <div class="form-group">
    <s:label value="推广日期:"/>
    <s:date name="model.date" format="yyyy-MM-dd"/>
    <input type="hidden" name="model.date" value="<s:property value="model.date"/>"/>
    </div>
    <input type="hidden" name="model.status" value="0"/>
    <s:submit class="btn-info btn-lg" value="提交"/>
    <s:reset class="btn-info btn-lg" value="重置"/>
</s:form>
</div>
</body>
</html>
