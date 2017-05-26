<%--
  Created by IntelliJ IDEA.
  User: ymcvalu
  Date: 2017/5/21
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
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
    <title>新增订单</title>
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

    <script>
        window.onload=function () {
            const brandId=<s:property value="brand.id"/>
            var param=new FormData()
            param.append("brand.id",brandId)
            enhanceSelect("selectModel",function () {
                param=new FormData()
                param.append("brand.id",brandId)
                return param
            },"pageNo",1,"/order/loadModel",function (item,obj) {
                item.value=obj.id
                item.text=obj.model
            })
            enhanceSelect("selectClient",function () {
                param =new FormData()
                return param
            },"pageNo",1,"order/loadClient",function (item,obj) {
                item.value=obj.id
                item.text=obj.name
            })
            $$("watchModel").onclick=function () {
                ms=$$("selectModel")
                si=ms.selectedIndex
                mid=ms.options[si].value
                param=new FormData()
                param.append("modelId",mid)
                $.ajax({url:"/brand/getModel",
                    data:param,
                    type:"post",
                    processData:false,
                    contentType:false,
                    success:function (model) {
                        $("#modalTitle").text(model["brand"].name)
                        str= "<img src='"+model.image+"' width='100' height='100'/><br/>"+
                                "<label>型号："+model.id+"</label><br/>"+
                                "<label>规格："+model.format+"</label><br/>"+
                                "<label>花色："+model.color+"</label><br/>"+
                                "<label>单价："+model.sale_price+"</label><br/>" 
                        $("#modalBody").html(str)
                    }
                })
            }
        }
    </script>
</head>
<body>
<h1>新增订单</h1>
<s:form action="handleAdd" namespace="/order" theme="simple" >
    <s:label value="选择客户："/>
    <s:select id="selectClient" name="order.receiver.id" list="clients" listKey="id" listValue="name"/>
    <br/>
    <label>品牌：${requestScope.brand.name}</label>
    <br/>
    <s:label value="选择型号：" />
    <s:select id="selectModel" name="order.model.id" list="models" listKey="id" listValue="model"/>
    <input id="watchModel" class="btn btn-default" data-toggle="modal" data-target="#modal" type="button" value="查看" />

    <br/>

    <s:label value="数量："/>
    <input type="number" name="order.quantity" required="true" min="1" max="10000" value="1"/>
    <br/>
    <s:submit value="提交" class="btn btn-default"/>
    <s:reset value="重置" class="btn btn-default"/>
</s:form>



<!-- 模态框（Modal） -->
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
<p id="debug"></p>
</body>
</html>
