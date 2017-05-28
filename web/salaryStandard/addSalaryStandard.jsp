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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link  href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="bootstrap/js/util.js"></script>
    <script src="bootstrap/js/selectEnhance.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <![endif]-->
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
    </script>
    
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
