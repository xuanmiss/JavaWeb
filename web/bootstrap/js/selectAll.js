function selectAll(loadBy, url, selectObj){

    $.ajax({
        url:url,
        data:loadBy,
        type:"post",
        processData:false,
        contentType:false,
        success:function (obj) {


           for(var i=0; i<list.length; i++){

                var item = document.createElement("option")
                item.value=list[i].id
                item.text=list[i].name
                selectObj.add(item, null)
            }
        }
    })
}