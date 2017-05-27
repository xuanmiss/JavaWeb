<%@ page pageEncoding="utf-8" contentType="text/html; uft8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>瓷砖管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="bootstrap/js/util.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <![endif]-->
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
    </script>
    <script type="text/javascript">
        window.onload=function (){
        }
    </script>
    <style type="text/css">
        td {text-align:center;padding:5px;margin:5px;}
        th {text-align:center;}
        tr {line-height: 175%;}
        table th,td{width:1000px;font-size: large;border:1px solid #CCCCCC; }
        table td{text-align:center;vertical-align:center;}
    </style>
</head>
<body>
    <h1 align="center">出库管理</h1>

    <table>

        <tr>
            <th>订单号</th>
            <th>品牌</th>
            <th>型号</th>
            <th>数量</th>
            <th>收货人</th>
            <th>收货人电话</th>
            <th>收货人地址</th>
            <th>操作</th>
        </tr>
        <s:iterator value="pageBean.data" var="it">
            <tr>

                <td><s:property value="#it[0].order_no"/> </td>
                <td><s:property value="#it[0].model.brand.name"/></td>
                <td><s:property value="#it[0].model.model"/></td>
                <td><s:property value="#it[0].quantity"/></td>
                <td><s:property value="#it[0].receiver.name"/></td>
                <td><s:property value="#it[0].receiver.phone"/></td>
                <td><s:property value="#it[0].receiver.address"/></td>
                <td>
                    <s:if test="#it[1]">
                        <input type="button" value="出库" class="btn btn-default" />
                    </s:if>
                    <s:else>
                        <input type="button" value="进货" class="btn btn-default" />
                    </s:else>
                </td>

            </tr>
        </s:iterator>
    </table>


    <jsp:include page="/common/page.jsp">
        <jsp:param name="url" value="/shipment/getUndoOrder.action" />
    </jsp:include>

<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modalTitle"></h4>
            </div>
            <div class="modal-body" id="modalBody"></div>
            <div class="modal-footer" id="modalFooter">
            </div>
        </div>
    </div>
</div>
</body>
</html>