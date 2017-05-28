<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ymcvalu
  Date: 2017/5/28
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>入库管理</title>
</head>
<body>
    <h1>入库管理</h1>
    <table>
        <tr>
            <th>订单号</th>
            <th>品牌</th>
            <th>型号</th>
            <th>数量</th>
            <th>日期</th>
            <th>操作</th>
        </tr>
        <s:iterator value="pageBean.data" var="it">
            <tr>
                <td><s:property value="#it.order_no"/> </td>
                <td><s:property value="#it.model.brand.name"/> </td>
                <td><s:property value="#it.model.model"/> </td>
                <td><s:property value="quantity"/> </td>
                <td><s:date format="yyyy-MM-dd" name="#it.date"/> </td>
                <td>
                    <button type="button" >入库</button>
                </td>
            </tr>
        </s:iterator>
    </table>
</body>
</html>
