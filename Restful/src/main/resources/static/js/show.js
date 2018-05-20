
var SHOW_URL="http://127.0.0.1:8080/user/show";//跨域

$(function () {
    $.ajax({
         type:"GET",
         dataType:"JSON",
         url:SHOW_URL,
         statusCode:{
             200:function (data) {
                 $("#list tbody").empty();
                 var str="<tbody>"+
                 "<tr>"+
                     "<td>"+ "序号"+ "</td>"+
                     "<td>"+ "用户名"+ "</td>"+
                     "<td>"+ "密码"+ "</td>"+
                     "<td>"+ "操作"+ "</td>"+
                 "</tr>"
                  var str1="";
                 $(data).each(function (i) {
                     var id=data[i].id;
                     var username=data[i].username;
                     var password=data[i].password;

                     str1=str1+"<tr>" +
                         "<td>"+(i+1)+"</td>" +
                         "<td>"+username+"</td>" +
                         "<td>"+password+"</td>" +
                         "<td><a href='#' onclick='del("+data[i].id+")'>删除</a></td> &nbsp;&nbsp;" +
                         "<td><a href='update.html?id="+data[i].id+"'>修改</a></td>" +
                         "</tr>"
                 })
                 var b="</tbody>";
                 var end=str+str1+b;
                 $("#list").append(end);
             }
         }
    })
})