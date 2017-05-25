<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="S" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>销售业绩</title>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link  href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="bootstrap/js/util.js"></script>
    <script src="bootstrap/js/selectEnhance.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <![endif]-->
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
    </script>
    <script>
        function endiInfo(obj) {
            var orderId = $(obj).attr("id");
            //var parm = new FormData();
            //parm.append("purchaseOrderId", orderId);
            $("#purchaseOrderId").val(orderId);
        }
        function confirm() {
            var purchaseOrderId = $("#purchaseOrderId").val();
            var parm = new FormData();
            parm.append("purchaseOrderId", purchaseOrderId);
            $.ajax({
                type:"POST",
                url:"/finance/purchaseOrder",
                data:parm,
                processData:false,
                contentType:false,
                success:function (result) {
                    alert("付款成功！")
                    location.reload()
                }
                }
            )
        }
    </script>
    <style type="text/css">
        td {text-align:center;padding:5px;margin:5px;}
        tr {line-height: 175%;}
        table th,td{width:1000px;font-size: large;border:1px solid #CCCCCC; }
        table th,td{text-align:center;vertical-align:center;}
    </style>
</head>
<body>
<h1 align="center">进货统计</h1>
<table id="table" align="center">
    <tr>
        <th>订货单号</th>
        <th>型号</th>
        <th>负责人</th>
        <th>下单时间</th>
        <th>总价</th>
        <th>数量</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <s:iterator value="pageBean.data" var="it" status="s">
        <tr>
            <td><s:property value="#it.order_no"/></td>
            <td><s:property value="#it.model.model"/></td>
            <td><s:property value="#it.clerk.name"/></td>
            <td><s:date name="date" format="yyyy-MM-dd"/></td>
            <td><s:property value="#it.amount"/></td>
            <td><s:property value="#it.quantity"/></td>
            <td>
                <s:if test="#it.type==0">已取消</s:if>
                <s:elseif test="#it.type==1">待付款</s:elseif>
                <s:elseif test="#it.type==2">待付款已入库</s:elseif>
                <s:elseif test="#it.type==3">已付款待入库</s:elseif>
                <s:else>已入库完成</s:else>
            </td>
            <td>
                <s:if test="#it.type==1 || #it.type==2">
                <input id="${it.id}" class="btn btn-default" data-toggle="modal" data-target="#payment" type="button" value="付款" onclick="endiInfo(this)"/></s:if>
                </td>
        </tr>
    </s:iterator>
</table>


<!-- 模态框（Modal） -->
<div class="modal fade" id="payment" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button  type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modalTitle">确认付款</h4>
            </div>
            <div class="modal-body" id="modalBody">
                <h4 align="center">流动资金：<s:property value="account.flow"/> RMB </h4>
                <h4 align="center">固有资产：<s:property value="account.fixed"/> RMB </h4>
                <h4 align="center">付款金额：<s:property value="#it.amount"/> RMB </h4>
                <h4 align="center">剩余资产：<s:property value="account.fixed-#it.amount"/> RMB </h4>
            </div>
            <div class="modal-footer" id="modalFooter">
                <input type="hidden" name="purchaseOrderId" id="purchaseOrderId"/>
                <button type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true" onclick="confirm()">确认付款</button>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/common/page.jsp">
    <jsp:param name="url" value="/finance/purchase.action"/>
</jsp:include>
</body>
</html>
