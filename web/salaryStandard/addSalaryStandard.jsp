<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>新增薪资标准</title>
    <base href="<%=basePath%>">
    <style type="text/css">
        .textarea {width:300px;height:200px;resize:none;}
    </style>
</head>
<body>
    <s:form action="salaryStandardAdd.action" method="POST" namespace="/salaryStandard" theme="simple">
        <s:fielderror fieldName="basicSalary" style="color:red"/>
        <s:label value="基础工资:"/>
        <s:textfield name="salaryStandard.basicSalary" />
        <br />
        <s:fielderror fieldName="commission" style="color:red"/>
        <s:label value="提成    :"/>
        <s:textfield name="salaryStandard.commission" />
        <br />
        <s:fielderror fieldName="description" style="color:red"/>
        <s:label value="具体描述:"/>
        <br />
        <s:textarea name="salaryStandard.description" class="textarea"/>
        <br />
        <s:submit value="提交"/>
        <s:reset value="重置"/>
    </s:form>
</body>
</html>
