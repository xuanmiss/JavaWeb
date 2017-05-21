<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%--
  Created by IntelliJ IDEA.
  User: chenshihong
  Date: 2017/5/11
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>品牌管理</title>
    <s:if test="isExit==1">
        <script language="javascript">
            alert("品牌仍存在型号无法删除！");
        </script>
    </s:if>
    <base href="<%=basePath%>">
    <style type="text/css">
        td {text-align:center;padding:5px;margin:5px;}
        tr {line-height: 175%;}
        table {width:1000px;font-size: x-large }
    </style>
</head>
<body>
<h1 align="center">品牌详细信息</h1>
<table align="center">
    <tr>
        <th>品牌编号</th>
        <th>品牌logo</th>
        <th>品牌名</th>
        <th>品牌创建时间</th>
        <th>品牌描述</th>
        <th>供应商</th>
        <th>上市情况</th>
    </tr>
   <tr>
        <td><s:property value="brand.id"/> </td>
        <td><img src="<s:property value="brand.logo"/>" width="75" height="75"></td>
        <td><s:property value="brand.name"/></td>
        <td><s:date name="brand.date" format="yyyy-MM-dd"/></td>
        <td><s:property value="brand.description"/> </td>
        <td><s:property value="brand.supplier"/> </td>
        <td>
            <s:if test="brand.status==0">
            在市
            </s:if>
            <s:else>
            下市
            </s:else>
        </td>
    </tr>
</table>
<h2><a href="/brand/deleteBrand.action?brandId=<s:property value="brand.id"/>">删除</a></h2>
<h2><a href="/brand/requestUpdateBrand.action?brandId=<s:property value="brand.id"/>">修改</a></h2>



</body>
</html>
