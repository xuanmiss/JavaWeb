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
    <input type="hidden" name="clerk.id" value="${requestScope.clerkId}"/>
    <s:fielderror fieldName="name" style="color:red"/>
    <s:label value="业务员姓名:"/>
    <s:textfield name="clerk.name" />
    <br />
    <s:fielderror fieldName="sex" style="color:red" />
    <s:label value="性别:" />
    <s:select list="# {'m':'男','f':'女'}" listKey="key" listValue="value" name="clerk.sex" headerKey="clerk.sex"></s:select>
    <br/>
    <s:fielderror fieldName="address" style="color:red" />
    <s:label value="地址:" />
    <s:textfield name="clerk.address" />
    <br/>
    <s:fielderror fieldName="status" style="color:red" />
    <s:label value="状态:" />
    <s:select list="# {'0':'退休','1':'在职','2':'离职'}" listKey="key" listValue="value" name="clerk.status" headerKey="clerk.status"></s:select>
    <br/>
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
