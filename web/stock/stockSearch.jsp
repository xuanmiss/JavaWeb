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
                $("#selectBatch").empty()
                si = this.selectedIndex
                brandId = this.options[si].value
                var param = new FormData()
                param.append("brandId", brandId)
                msg = "当前品牌下没有型号信息！！！"
                selectAll(param, "stock/loadModel", $("#selectModel"), msg, function(obj){
                    item = "<option value='" + obj.id + "'>" + obj.model + "</option>"
                    return item
                })
            })

            $("#selectModel").change(function () {

                //获取modelId
                si = this.selectedIndex
                modelId = this.options[si].value
                var param = new FormData()
                param.append("modelId", modelId)
                msg = "当前型号下没有批次信息！！！"

                selectAll(param, "stock/loadBatch", $("#selectBatch"), msg, function(obj){
                    item = "<option value='" + obj.id + "'>" + obj.batch_no + "</option>"
                    return item
                })
            })
            //点击时如果只有一个元素则自动加载batch
            $("#selectModel").click(function(){
                //获取modelId
                if(this.options.length == 1){
                    //获取modelId
                    modelId = this.options.item(0).value
                    var param = new FormData()
                    param.append("modelId", modelId)
                    msg = "当前型号下没有批次信息！！！"

                    selectAll(param, "stock/loadBatch", $("#selectBatch"), msg, function(obj){
                        item = "<option value='" + obj.id + "'>" + obj.batch_no + "</option>"
                        return item
                    })
                }
            })



            $("#search").click(function () {
                $("#brandError").empty()
                $("#modelError").empty()
                $("#batchError").empty()
                $("#modalTitle").text("错误！")
                if($("#selectBrand")[0].selectedIndex < 0)
                    //$("#brandError").text("请选择品牌信息！")
                    $("#modalBody").text("请选择品牌信息！")
                else if($("#selectModel")[0].selectedIndex < 0)
                    //$("#modelError").text("请选择型号信息！")
                    $("#modalBody").text("请选择型号信息！")
                else if($("#selectBatch")[0].selectedIndex < 0)
                    //$("#batchError").text("请选择批次信息！")
                    $("#modalBody").text("请选择批次信息！")
                else {
                    url = "stock/stockViewAction.action?status=1"
                    si = $("#selectBatch")[0].selectedIndex
                    id = $("#selectBatch")[0].options[si].value
                    param = new FormData()
                    param.append("batchId", id)
                    msg = "当前批次下的仓库为空！"
                    $.ajax({
                        url:url,
                        data:param,
                        type:"post",
                        processData:false,
                        contentType:false,
                        success:function (data) {
                            var l = data.length
                            if(l == 0)
                                alert(msg)
                            else {
                                brand = $("#selectBrand")[0].options[$("#selectBrand")[0].selectedIndex].text
                                model = $("#selectModel")[0].options[$("#selectModel")[0].selectedIndex].text
                                batch = $("#selectBatch")[0].options[$("#selectBatch")[0].selectedIndex].text
                                $("#modalTitle").text(brand)
                                str=
                                    "<label>型号："+model+"</label><br/>"+
                                    "<label>批次："+batch+"</label><br/>"+
                                    "<label>数量："+data[0].count+"</label><br/>"
                                $("#modalBody").html(str)
                            }
                        }
                    })//ajax
                }

            })


        }
    </script>
</head>
<body>
<h1>库存信息查询</h1>

    <s:label value="选择品牌："/>
    <s:select id="selectBrand" name="brandId" list="brandList" listKey="id" listValue="name"/>
    <br />
    <label id="brandError" style="color: #bb0000"></label>
    <br />
    <s:label value="选择型号：" />
    <s:select id="selectModel" name="modelId" list="modelList" listKey="id" listValue="model"/>
    <br />
    <label id="modelError" style="color: #bb0000"></label>
    <br />
    <s:label value="选择批次：" />
    <select id="selectBatch"></select>
    <br />
    <label id="batchError" style="color: #bb0000"></label>
    <br />
<input id="search" class="btn btn-default" data-toggle="modal" data-target="#modal" type="button" value="查看" />
    <div id="stockView"></div>

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

</body>
</html>
