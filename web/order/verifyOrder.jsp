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
    <title>订单确认</title>
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

    <style type="text/css">
        td {text-align:center;padding:5px;margin:5px;}
        tr {line-height: 175%;}
        table {width:1000px;font-size: x-large;align-self: center }
    </style>
    <script>
        window.onload=function () {
            var commit=$$("commit")
            var orderNo=<s:property value="order.order_no" />
            commit.onclick=function () {
                $("#modalTitle").text("选择付款方式")
                $("#modalBody").html(
                    "<input type='button' id='arrear' class='btn btn-default' value='白条支付'/>"
                    +"  "
                    + "<input type='button' id='transfer' class='btn btn-default' value='网银支付' />"
                )
                $$("arrear").onclick=function () {
                    var param=new FormData()
                    param.append("order.order_no",orderNo)
                    $.ajax({
                        url:"/order/commitByArrear",
                        data:param,
                        processData:false,
                        contentType:false,
                        type:"post",
                        success:function (msg) {
                            $("#modalTitle").text("付款结果")
                            $("#modalBody").text(msg)
                            setTimeout(function () {
                                window.location.href="<%=basePath%>/order/requesAdd"
                            },500)
                        }
                    })
                }
                $$("transfer").onclick=function () {
                    window.location.href="<%=basePath%>/alipay/requestPay?orderNo=<s:property value="order.order_no"/>&amount=<s:property value="order.price"/>"
                }
            }
        }
    </script>

</head>
<body>
    <h1 align="center">订单确认</h1>
    <table>
        <tr><td>订单号：</td><td><s:property value="order.order_no"/></td></tr>
        <tr><td>品牌：</td><td><s:property value="order.model.brand.name"/> </td></tr>
        <tr><td>型号：</td><td><s:property value="order.model.model"/> </td></tr>
        <tr><td>数量：</td><td><s:property value="order.quantity"/> </td></tr>
        <tr><td>总价：</td><td><s:property value="order.price"/> </td></tr>
        <tr><td>收货人：</td><td><s:property value="order.receiver.name"/> </td></tr>
        <tr><td>收货地址：</td><td><s:property value="order.receiver.address"/> </td></tr>
        <tr>
            <td colspan="2">
            <s:form action="cancelOrder" namespace="/order">
                <s:hidden name="order.order_no"/>
                <s:submit  value="取消订单" class="btn btn-default" id="cancel"/>
            </s:form>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                    <s:submit value="提交订单" class="btn btn-default" id="commit" data-toggle="modal" data-target="#modal" />
            </td>
        </tr>
    </table>

    <!-- 模态框（Modal） -->
    <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="modalTitle"></h4>
                </div>
                <div class="modal-body" id="modalBody"></div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
