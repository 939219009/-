<%@ page contentType="text/html;charset=utf-8" language="java"  pageEncoding="UTF-8"
         import="com.wym.vo.User,com.wym.service.IUserServiceImpl"%>
<%@ page import="com.wym.service.IUserService" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.*" %>
<%  request.setCharacterEncoding("utf-8"); %>
<html>
<head >
  <title>简注册页面练习</title>
  <meta charset="utf-8" />
  <style>
    .username.ng-valid {
      background-color: lightgreen;
    }
    .username.ng-dirty.ng-invalid-required {
      background-color: red;
    }
    .username.ng-dirty.ng-invalid-minlength {
      background-color: yellow;
    }

    .email.ng-valid {
      background-color: lightgreen;
    }
    .email.ng-dirty.ng-invalid-required {
      background-color: red;
    }
    .email.ng-dirty.ng-invalid-email {
      background-color: yellow;
    }

  </style>
  <script type="text/javascript" src="js/jquery-1.11.0.js"></script>

  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <link href="css/app.css" rel="stylesheet"/>
  <script>
      $(function(){
          $("#form1").submit(function () {
              var user=$("#user").val();
              var pwd=$("#pwd").val();
              if(user==''){
                  $("#uerror").html('你的用户名不能为空');
                  return false;
              } else {
                  $("#uerror").html('');
              }
              if(pwd==''){
                  $("#perror").html('你的密码不能为空');
                  return false;
              }else {
                  $("#perror").html('');
              }
          });
          $("#rest").click(function () {
              $("#user").val('');
              $("#pwd").val('');
              $("#uerror").html('');
              $("#perror").html('');
          })
      });


  </script>
</head>
<body>
<div class="generic-container" >
  <div class="panel panel-default" >
    <div class="panel-heading"><span class="lead">注册用户 </span></div>
    <div class="formcontainer">

      <form  name="myForm" class="form-horizontal" id="form1"
             action="checkuser.jsp"
             method="post">
        <%

          IUserService service=new IUserServiceImpl();
          String id=request.getParameter("id");
          User u1=null;
          if(id!=null){ u1=service.queryUserById(Integer.parseInt(id));
          }

        %>

        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable">姓名</label>
            <div class="col-md-7">
              <input type="hidden" name="id"
                     value="<%=u1!=null?u1.getId():""%>"/>
              <input type="text" name="user" id="user"
                     value="<%=u1!=null?u1.getUsername():""%>"
                     class="username form-control input-sm"
                     placeholder="输入你的姓名"/>
              <div class="has-error">
                <span id="uerror"></span>
              </div>
            </div>
          </div>
        </div>


        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable" >密码</label>
            <div class="col-md-7">
              <input type="text" name="pwd" id="pwd"
                     value="<%=u1!=null?u1.getPassword():""%>"
                     class="password form-control input-sm"
                     placeholder="输入你的密码"
              />
              <div class="has-error" >
                <span id="perror"></span>

              </div>
            </div>
          </div>
        </div>



        <div class="row">
          <div class="form-actions floatRight">
            <input type="submit" id="add"
                   value="提交"
                   class="btn btn-primary btn-sm"
            >
            <button type="button" id="rest"
                    class="btn btn-warning btn-sm">复原</button>
          </div>
        </div>
      </form>
    </div>
  </div>
  <div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading"><span class="lead">用户列表 </span></div>
    <div class="tablecontainer">
      <table class="table table-hover">
        <thead>
        <tr>
          <th>ID.</th>
          <th>用户名</th>
          <th>密码</th>
          <th width="20%"></th>
        </tr>
        </thead>
        <tbody>
        <%

          List<User> list =service.queryAll();
          Iterator<User> it=list.iterator();
          int i=0;

          while(it.hasNext()){
            User u= it.next();
        %>
        <tr>
          <td>
            <%=++i%>
          </td>
          <td>
            <%=u.getUsername()%>
          </td>
          <td>
            <%=u.getPassword()%>
          </td>
          <td>
            <a href="submit.jsp?id=<%=u.getId()%>" class="btn btn-success custom-width">编辑</a>
            <a href="del.jsp?id=<%=u.getId()%>" class="btn btn-danger custom-width">删除</a>
          </td>
        </tr>
        <%
          }
        %>
        </tbody>
      </table>
    </div>
  </div>
</div>


</body>
</html>