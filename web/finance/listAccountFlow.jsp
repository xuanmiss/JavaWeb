<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>账户明细</title>
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
    <link rel="stylesheet" href="resources/css/fontsite.css">
    <script>
        function payInfo(obj) {
            var orderId = $(obj).attr("id");
            var param = new FormData();
            param.append("accountFlowId", orderId);
            $("#accountFlowId").val(orderId);
            $.ajax({
                url:"/finance/loadAccountFlow",
                data:param,
                type:"post",
                processData:false,
                contentType:false,
                success:function (amount) {
                    str= "<h4 align='center'>付款金额：" + amount + "RMB </h4>" +
                        "<div align='center'>" +
                        "<img src='resources/images/pay.png' width='300px' height='300px'>" +
                        "</div>" +
                        "<h3 align='center'>请扫码支付</h3>";
                    $("#modalBody").html(str)
                }
            })
        }
        function confirm() {
            var accountFlowId = $("#accountFlowId").val();
            var parm = new FormData();
            parm.append("accountFlowId", accountFlowId);
            $.ajax({
                    type:"post",
                    url:"/finance/accountPayArrears",
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
   < <style type="text/css">
        td {text-align:center;padding:5px;margin:5px;}
        tr {line-height: 175%;}
        table th,td{width:1000px;font-size: large;border:1px solid #CCCCCC; }
        table th,td{text-align:center;vertical-align:center;}
    </style>
</head>
<body>
<div>
    <h2 align="center">流动资金：<s:property value="account.flow"/> RMB </h2>
    <h2 align="center">固有资产：<s:property value="account.fixed"/> RMB </h2>
</div>
<div>
<table>
    <tr>
        <th>流水单号</th>
        <th>金额</th>
        <th>负责人</th>
        <th>流水描述</th>
        <th>类型</th>
        <th>时间</th>
        <th>操作</th>
    </tr>
    <s:iterator value="pageBean.data" var="it">
        <tr>
            <td><s:property value="#it.id"/> </td>
            <td>
                <s:property value="#it.amount"/>
            </td>
            <td><s:property value="#it.clerk.name"/></td>
            <td><s:property value="#it.description"/></td>
            <td>
                <s:if test="#it.type==1">订货支出</s:if>
                <s:elseif test="#it.type==2">订单收入</s:elseif>
                <s:elseif test="#it.type==3">工资支出</s:elseif>
                <s:elseif test="#it.type==4">客户白条</s:elseif>
                <s:else>白条已还款</s:else>
            </td>
            <td><s:date name="date" format="yyyy-MM-dd"/></td>
            <td>
                <s:if test="#it.type==4">
                <input id="${it.id}" class="btn btn-default" data-toggle="modal" data-target="#payment" type="button" value="付款" onclick="payInfo(this)"/>
                </s:if>
            </td>
        </tr>
    </s:iterator>
</table>
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="payment" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button  type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modalTitle">客户付款界面</h4>
            </div>
            <div class="modal-body" id="modalBody">
            </div>
            <div class="modal-footer" id="modalFooter">
                <input type="hidden" name="accountFlowId" id="accountFlowId"/>
                <button type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true" onclick="confirm()">确认付款</button>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/common/page.jsp">
    <jsp:param name="url" value="/finance/account.action"/>
</jsp:include>
</body>
</html>
