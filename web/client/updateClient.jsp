<%--
  Created by IntelliJ IDEA.
  User: miss
  Date: 2017/5/18
  Time: 0:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>更新客户信息</title>
    <base href="<%=basePath%>">
    <style type="text/css">
        .textarea {width:300px;height:200px;resize:none;}
    </style>
</head>
<body>
<s:form action="clientupdate.action?update=1" method="POST"  namespace="/client" theme="simple" >
    <input type="hidden" name="client.id" value="<s:property value="client.id"/>"/>
    <s:fielderror fieldName="name" style="color:red"/>
    <s:label value="客户姓名:"/>
    <s:textfield name="client.name" />
    <br />
    <s:fielderror fieldName="phone" style="color:red" />
    <s:label value="电话:" />
    <s:textfield name="client.phone" />
    <br/>
    <s:fielderror fieldName="address" style="color:red" />
    <s:label value="地址:" />
    <s:textfield name="client.address" />
    <br/>
    <s:fielderror fieldName="weichat" style="color:red" />
    <s:label value="微信号:" />
    <s:textfield name="client.weichat" />
    <br/>
    <s:fielderror fieldName="card" style="color:red" />
    <s:label value="银行卡号:" />
    <s:textfield name="client.card" />
    <br/>
    <s:submit value="提交"/>
    <s:reset value="重置"/>
</s:form>
</body>
</html>
