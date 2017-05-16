<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>更新业务员</title>
    <base href="<%=basePath%>">
    <style type="text/css">
        .textarea {width:300px;height:200px;resize:none;}
    </style>
</head>
<body>
<s:form action="clerk_update.action?update=1" method="POST"  namespace="/clerk" theme="simple" enctype="multipart/form-data">
    <s:fielderror fieldName="name" style="color:red"/>
    <s:label value="业务员姓名:"/>
    <s:textfield name="clerk.name" />
    <br />
    <s:fielderror fieldName="address" style="color:red" />
    <s:label value="地址:" />
    <s:textfield name="clerk.address" />
    <br/>
    <s:fielderror fieldName="weichat" style="color:red" />
    <s:label value="微信号码:" />
    <s:textfield name="clerk.weichat" />
    <br/>
    <s:submit value="提交"/>
    <s:reset value="重置"/>
</s:form>
</body>
</html>
