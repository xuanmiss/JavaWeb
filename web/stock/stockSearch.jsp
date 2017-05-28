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
    <title>库存查看</title>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link  href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="bootstrap/js/util.js"></script>
    <script src="bootstrap/js/selectAll.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <![endif]-->
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>

    <script>
        window.onload=function () {

            $("#selectBrand").change(function () {
                si = this.selectedIndex
                brandId = this.options[si].value
                var param = new FormData()
                param.append("brandId", brandId)
                $.ajax({
                    url:"/stock/loadModel",
                    type:"post",
                    processData:false,
                    contentType:false,
                    data:param,
                    success:function (data) {
                        alert(data.length)
                    }

                })
            })

        }
    </script>
</head>
<body>
<h1>库存信息查询</h1>
<s:form action="stockView?status=1" namespace="/stock" theme="simple" >
    <s:label value="选择品牌："/>
    <s:select id="selectBrand" name="brandId" list="brandList" listKey="id" listValue="name"/>
    <br />
    <div id="brandError"/>
    <s:label value="选择型号：" />
    <select id="selectModel"></select>
    <br />
    <div id="modelError"/>
    <s:label value="选择批次：" />
    <select id="selectBatch"></select>
    <br />
    <div id="batchError"/>
    <s:submit value="提交" class="btn btn-default"/>
    <s:reset value="重置" class="btn btn-default"/>
    <div id="debug"></div>
</s:form>

</body>
</html>
