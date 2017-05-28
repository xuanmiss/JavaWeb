<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ymcvalu
  Date: 2017/5/28
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>申请进货</title>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link  href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="bootstrap/js/util.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <![endif]-->
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script>
        window.onload=function () {
            $$("brandSel").onchange = function () {
                var brandId = $$("requestIn").brandId.value
                var param = new FormData()
                param.append("brandId", brandId)
                $.ajax({
                    url: "/stock/loadModel",
                    type: "post",
                    processData: false,
                    contentType: false,
                    data: param,
                    success: function (models) {
                        var select = $$("modelSel")
                        clearChildren(select)
                        for (var i = 0; i < models.length; i++) {
                            var option = document.createElement("option")
                            option.value = models[i].id
                            option.text = models[i].model
                            select.add(option, null)
                        }
                        if (models.length == 0) {
                            var option = document.createElement("option")
                            option.value = 0
                            option.text = "-无型号信息-"
                            select.add(option, null)
                        }
                    }
                })
            }
            $$("submit").onclick = function () {
                var modelId = $$("requestIn").modelId.value
                var count = $$("requestIn").count.value
                if (modelId <= 0) {
                    alert("型号信息有误！")
                    return
                }
                var param = new FormData()
                //purchaseOrder
                param.append("purchaseOrder.model.id", modelId)
                param.append("purchaseOrder.quantity", count)
                $.ajax({
                    url: "/purchase/handleAdd",
                    type: "post",
                    processData: false,
                    contentType: false,
                    data: param,
                    success: function (msg) {
                        $("#myModalLabel").text("申请结果")
                        $("#myModalBody").text(msg)
                        setTimeout(function () {
                            window.location.href="/purchase/requestAdd"
                        },1000)
                    }

                })
            }
        }
    </script>
</head>
<body>
    <h1>安排进货</h1>
    <s:form theme="simple" id="requestIn">
        <label>品牌：</label>
        <s:select list="brands" listKey="id" listValue="name" name="brandId" id="brandSel" />
        <br />
        <label>型号：</label>
        <s:select list="models" listKey="id" listValue="model" name="modelId" id="modelSel" />
        <br />
        <label>数量：</label>
        <input type="number" value="1000" min="1000" max="100000000" name="count">
        <br />
        <button type="button" id="submit" class="btn btn-default" data-toggle="modal" data-target="#myModal">提交</button>
        <s:reset value="重置" class="btn btn-default" />
    </s:form>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel"></h4>
                </div>
                <div class="modal-body" id="myModalBody">
                </div>
                <div class="modal-footer" id="myModalFooter"></div>
            </div>
        </div>
    </div>
</body>
</html>
