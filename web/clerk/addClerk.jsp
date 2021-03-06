<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>添加业务员</title>
    <base href="<%=basePath%>">
    <style type="text/css">
        .textarea {width:300px;height:200px;resize:none;}
    </style>
</head>
<body>

<s:form action="clerk_add.action?status=1" method="POST"  namespace="/clerk" theme="simple" enctype="multipart/form-data">
    <s:fielderror fieldName="username" style="color:red"/>
    <s:label value="用户名:"/>
    <s:textfield name="role.username" />
    <br />
    <s:fielderror fieldName="password" style="color:red"/>
    <s:label value="密码:"/>
    <s:textfield name="role.password" type="password" />
    <br />
    <s:fielderror fieldName="name" style="color:red"/>
    <s:label value="业务员姓名:"/>
    <s:textfield name="clerk.name" />
    <br />
    <s:fielderror fieldName="identity" style="color:red"/>
    <s:label value="身份证:"/>
    <s:textfield name="clerk.identity"/>
    <br />
    <s:fielderror fieldName="salaryStandard" style="color:red"/>
    <s:label value="薪资标准:"/>
    <s:select list="salaryStandardList" listKey="id" name="clerk.salaryStandard.id" listValue="toString()" />
    <br />
    <s:fielderror fieldName="phone" style="color:red" />
    <s:label value="手机号码:" />
    <s:textfield name="clerk.phone" />
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
