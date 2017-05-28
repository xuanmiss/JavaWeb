function selectAll(loadBy, url, selectObj, msg, getItem){
    selectObj.empty()
    $.ajax({
        url:url,
        data:loadBy,
        type:"post",
        processData:false,
        contentType:false,
        success:function (data) {
            var l = data.length
            if(l == 0)
                alert(msg)
            else for(var i=0; i<l; i++)
                selectObj.append(getItem(data[i]))
        }
    })

}