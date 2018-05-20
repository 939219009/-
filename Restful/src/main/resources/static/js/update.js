
var UPDATE_URL="http://127.0.0.1:8080/user/update";//跨域

$(function () {
    $("#update").click(function () {
        var json=JSON.stringify($("#form2").serializeObject());
        // alert(json);
        $.ajax({
            type: "POST",
            url:UPDATE_URL,
            contentType:"application/json;charset=UTF-8",//前往后传json/
            datatype:"JSON",//后往前传json
            data: json,
            statusCode:{
                201:function () {
                    alert("修改成功！")
                    window.location="show.html";
                }
            }
        })
    });
});