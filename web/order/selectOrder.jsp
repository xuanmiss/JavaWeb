<%@ page pageEncoding="utf-8" contentType="text/html; uft8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<head>
    <title>查询订单</title>
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

    <%--<script>--%>
        <%--window.onload=function () {--%>
            <%--var param=new FormData()--%>
            <%--enhanceSelect("selectClerk",function () {--%>
                <%--return param--%>
            <%--},"pageNo",1,"/order/loadClerk",function (item,obj) {--%>
                <%--item.value=obj.id--%>
                <%--item.text=obj.name--%>
            <%--})--%>
        <%--}--%>
    <%--</script>--%>

    <style type="text/css">
        h1 {
            margin-bottom: 50px;
        }
        div {
            display: inline;
            margin-left: 200px;
        }

        p {
            margin-top: 80px;
            text-align: center;
        }
    </style>
</head>
<body>
<h1 align="center">订单查询</h1>
<s:form action="selectOrder" namespace="/order" theme="simple" >
    <div class="inline">
        <s:label value="选择业务员："/>
        <s:select id="selectClerk" name="clerk" list="clerks.data" listKey="id" listValue="name" headerKey="0" headerValue="--请选择--"/>
    </div>

    <div>
        <s:label value="选择状态：" />
        <s:select name="status" list="#{'1':'未发货','2':'已发货'}" headerKey="0" headerValue="--请选择--"/>
    </div>

    <div>
        <s:label value="选择客户："/>
        <s:select name="client" list="clients.data" listKey="id" listValue="name" headerKey="0" headerValue="--请选择--"/>
    </div>
    <br>

    <p>
        <s:submit value="提交" class="btn btn-default"/>
        <s:reset value="重置" class="btn btn-default"/>
    </p>
</s:form>
</body>
</html>
