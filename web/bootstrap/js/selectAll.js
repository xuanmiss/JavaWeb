function selectAll(loadBy, url, selectObj){

    $.ajax({
        url:url,
        data:loadBy,
        type:"post",
        processData:false,
        contentType:false,
        success:function (data) {

            $("#stockView").text(data)

        }
    })
}