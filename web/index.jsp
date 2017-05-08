<%--
  Created by IntelliJ IDEA.
  User: ymcvalu
  Date: 2017/5/4
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <s:form action="login.action" namespace="/" theme="simple">
        <table align="center">
            <s:if test="msg!=null">
                <tr>
                    <td colspan="2" style="color:red"><s:property value="msg"/> </td>
                </tr>
            </s:if>
            <tr>
                <td><s:label value="用户名："/></td>
                <td><s:textfield name="username"/></td>
            </tr>
            <tr>
                <td><s:label value="密码："/></td>
                <td><s:password name="password"/></td>
            </tr>
            <tr>
                <td><s:submit value="登陆"/></td>
                <td><s:reset value="重置" /></td>
            </tr>
        </table>
    </s:form>

</body>
</html>
