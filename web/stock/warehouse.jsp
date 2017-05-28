<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ymcvalu
  Date: 2017/5/28
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>入库管理</title>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link  href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="bootstrap/js/util.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <![endif]-->
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
    </script>

    <style type="text/css">
        td {text-align:center;padding:5px;margin:5px;}
        tr {line-height: 175%;}
        table th,td{width:1000px;font-size: large;border:1px solid #CCCCCC; }
        table th,td{text-align:center;vertical-align:center;}
    </style>

    <script>
        function btnClick(target) {
            $("#myModalLabel").text("入库登记")
            var str="<form id='batchIn'>"
            str+="<label>批次号：</label>"
            str+="<input type='text' name='batchNo' />"
            str+="</form>"
            $("#myModalBody").html(str)
            $$("inBtn").onclick=function () {
                var orderNo=target.title
                var batchNo=$$("batchIn").batchNo.value
                if(batchNo==null||batchNo==""){
                    alert("请输入批次号")
                    return
                }

                var param=new FormData()
                param.append("purchase.batch.batch_no",batchNo)
                param.append("purchase.order.order_no",orderNo)

                $.ajax({
                    url: "/purchase/handleIn.action",
                    type: "post",
                    processData: false,
                    contentType: false,
                    data: param,
                    success:function (msg) {
                        $("#myModalBody").text(msg)
                        $$("inBtn").onclick=null
                        setTimeout(function () {
                            window.location.href="/purchase/requestIn"
                         },1000)
                    }
                })
            }
        }

        function cancleBtn(target) {
            $("#myModalLabel").text("取消入库申请")
            $("#myModalBody").html("说明:<br />该操作将取消入库申请，如果该申请已经向厂家预付款项，将无法取消!")
            $("#inBtn").text("取消申请")
            $$("inBtn").onclick = function () {
                var param = new FormData()
                param.append("purchaseOrder.order_no", target.title)
                $.ajax({
                    url: "/purchase/cancleIn.action",
                    type: "post",
                    processData: false,
                    contentType: false,
                    data: param,
                    success: function (msg) {
                        $("#myModalLabel").text("取消结果")
                        $("#myModalBody").text(msg)
                        $$("inBtn").onclick = null
                        setTimeout(function () {
                            window.location.href = "/purchase/requestIn"
                        }, 1000)
                    }
                })
            }
        }
    </script>
</head>
<body>
    <h1 align="center">入库管理</h1>
    <table>
        <tr>
            <th>订单号</th>
            <th>品牌</th>
            <th>型号</th>
            <th>数量</th>
            <th>日期</th>
            <th>操作</th>
        </tr>
        <s:iterator value="pageBean.data" var="it">
            <tr>
                <td><s:property value="#it.order_no"/> </td>
                <td><s:property value="#it.model.brand.name"/> </td>
                <td><s:property value="#it.model.model"/> </td>
                <td><s:property value="quantity"/> </td>
                <td><s:date format="yyyy-MM-dd" name="#it.date"/> </td>
                <td>
                    <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal" onclick="btnClick(this);" title="<s:property value="#it.order_no"/>">入库</button>
                    <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal" onclick="cancleBtn(this);" title="<s:property value="#it.order_no"/>">取消</button>
                </td>
            </tr>
        </s:iterator>
    </table>
    <jsp:include page="/common/page.jsp">
        <jsp:param name="url" value="/purchase/requestIn.action"/>
    </jsp:include>


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
                <div class="modal-footer" id="myModalFooter">
                    <button type="button" class="btn btn-default" id="inBtn" >入库</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
