<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>型号查看</title>
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
    <style type="text/css">
        td {text-align:center;padding:5px;margin:5px;}
        tr {line-height: 175%;}
        table th,td{width:1000px;font-size: large;border:1px solid #CCCCCC; }
        table th,td{text-align:center;vertical-align:center;}
    </style>
    <s:if test="flag==1">
        <script language="javascript">
            alert("该型号不能被删除!");
        </script>
    </s:if>
</head>
<body>
<h1 align="center"><s:property value="brand"/> </h1>

<table align="center">
    <tr>
        <th>样图</th>
        <th>型号</th>
        <th>规格<sub>(mm)</sub></th>
        <th>花色</th>
        <th>单价</th>
        <th>上市时间</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <s:iterator value="pageBean.data" var="it">
        <tr>
            <td><img src="<s:property value="image"/>"  width="105" height="105"/></td>
            <td><s:property value="model"/></td>
            <td><s:property value="format"/></td>
            <td><s:property value="color"/></td>
            <td><s:property value="sale_price"/> </td>
            <td><s:date name="date" format="yyyy-MM-dd"/></td>
            <td><s:if test="status==0">在市</s:if><s:else>下市</s:else></td>
            <td>
                <a href="/brand/requestUpdateModel.action?brandId=<s:property value="brand.id"/>&modelId=<s:property value="id"/>">修改</a>
                <a href="/brand/deleteModel.action?brandId=<s:property value="brandId"/>&modelId=<s:property value="id"/>">删除</a>
            </td>
        </tr>
    </s:iterator>
</table>
<%--添加页面链接，需要传递品牌Id作为参数--%>
<a href="/brand/requestAddModel.action?brandId=<s:property value="brandId"/>"><img src="resources/images/add.jpg" width="100" height="100" style="position: fixed;z-index:100;right:50px;bottom:50px;"/></a>

<jsp:include page="/common/page.jsp">
    <jsp:param name="url" value="/brand/selectModel.action?brandId=${requestScope.brandId}"/>
</jsp:include>
</body>
</html>
