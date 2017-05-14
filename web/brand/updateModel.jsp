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
    <style type="text/css">
        .textarea {width:300px;height:200px;resize:none;}
    </style>
</head>
<body>
<h1><s:property value="brandName"/></h1>
<h3>新增型号</h3>
<s:form action="handleUpdateModel.action" method="POST"  namespace="/brand" theme="simple" enctype="multipart/form-data">
    <input type="hidden" name="model.brand.id" value="${requestScope.brandId}"/>
    <input type="hidden" name="model.id" value="<s:property value="model.id"/>"/>
    <s:fielderror fieldName="model" style="color:red"/>
    <s:label value="型号:"/>
    <s:textfield name="model.model" />
    <br /><br />
    <s:fielderror fieldName="format" style="color:red"/>
    <s:label value="规格:"/>
    <s:textfield name="model.format"/>
    <br /><br />
    <s:fielderror fieldName="color" style="color:red"/>
    <s:label value="花色:"/>
    <s:textfield name="model.color" />
    <br /><br />

    <s:fielderror fieldName="in_price" style="color:red"/>
    <s:label value="进价:"/>
    <s:textfield name="model.in_price"/>
    <br /><br />

    <s:fielderror fieldName="sale_price" style="color:red"/>
    <s:label value="单价:"/>
    <s:textfield name="model.sale_price"/>
    <br /><br />

    <s:fielderror fieldName="image" style="color:red"/>
    <s:label value="照片:"/>
    <img src="<s:property value="model.image"/>" width="80" height="80">
    <input type="hidden" name="model.image" value="<s:property value="model.image"/>"/>
    <s:file name="image"/>
    <br/>
    <s:label value="推广日期:"/>
    <s:date name="model.date" format="yyyy-MM-dd"/>
    <input type="hidden" name="model.date" value="<s:property value="model.date"/>"/>
    <br/>
    <s:radio list="#{'0':'在市','1':'下市'}" name="model.status" />
    <br/>
    <s:submit value="提交"/>
    <s:reset value="重置"/>
</s:form>
</body>
</html>
