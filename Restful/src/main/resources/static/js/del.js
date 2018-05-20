
var DEL_URL="http://127.0.0.1:8080/user/del";//跨域

function del(i) {
    $.ajax({
        type: "DELETE",
        url:DEL_URL+"/"+i,
        statusCode:{
            201:function () {
                alert("删除成功！");
                window.location="show.html";
            }
        }
    })
}