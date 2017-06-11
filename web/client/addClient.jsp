<%--
  Created by IntelliJ IDEA.
  User: miss
  Date: 2017/5/17
  Time: 23:28
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
    <title>添加客户</title>
    <base href="<%=basePath%>">
    <style type="text/css">
        .textarea {width:300px;height:200px;resize:none;}
    </style>
</head>
<body>
<s:form action="clientadd.action" method="POST"  namespace="/client" theme="simple" enctype="multipart/form-data">
    <s:fielderror fieldName="name" style="color:red"/>
    <s:label value="客户姓名:"/>
    <s:textfield name="client.name" />
    <br />
    <s:fielderror fieldName="phone" style="color:red"/>
    <s:label value="电话号码:"/>
    <s:textfield name="client.phone"/>
    <br />
    <s:fielderror fieldName="weichat" style="color:red" />
    <s:label value="微信号码:" />
    <s:textfield name="client.weichat" />
    <br/>
    <s:fielderror fieldName="address" style="color:red" />
    <s:label value="地址:" />
    <s:textfield name="client.address" />
    <br/>
    <s:fielderror fieldName="reposal" style="color:red" />
    <s:label value="信用值:" />
    <s:textfield name="client.reposal" value="50" />
    <br/>
    <s:fielderror fieldName="status" style="color:red" />
    <s:label value="状态:" />
    <s:textfield name="client.status"  value="1"/>
    <br/>
    <s:fielderror fieldName="card" style="color:red" />
    <s:label value="银行卡号:" />
    <s:textfield name="client.card" />
    <br/>
    <s:fielderror fieldName="sex" style="color:red" />
    <s:label value="性别:" />
    <s:select name="client.sex" list="# {'m':'男','w':'女'}"/>
    <br/>
    <s:submit value="提交"/>
    <s:reset value="重置"/>
</s:form>
</body>
</html>
