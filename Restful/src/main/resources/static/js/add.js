
var REG_URL="http://127.0.0.1:8080/user/reg";//跨域

$(function () {
    $("#add").click(function () {
        var json=JSON.stringify($("#form1").serializeObject());
       // alert(json);
        $.ajax({
            type: "PUT",
            url:REG_URL,
            contentType:"application/json;charset=UTF-8",//前往后传json/
            datatype:"JSON",//后往前传json
            data: json,
            statusCode:{
                201:function () {
                    alert("注册成功！")
                }
            }
        })
    });
});