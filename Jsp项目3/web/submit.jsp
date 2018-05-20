<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"
         import="com.wym.vo.User,com.wym.service.IUserServiceImpl"%>
<%@ page import="com.wym.service.IUserService" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="w" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head >
  <title>简注册页面练习</title>
  <meta charset="utf-8">
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
    <div class="panel-heading">
      <span class="lead">注册用户 </span>
      <span class="lead">
        <%--   <%=request.getAttribute("msg")!=null?request.getAttribute("msg"):""%>--%>
        ${requestScope.msg!=null?requestScope.msg:""}
      </span>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <jsp:useBean id="s" class="com.wym.service.IUserServiceImpl"/>
      <span class="lead">在线用户 <%=s.online()%></span>

    </div>
    <div class="formcontainer">

      <form  name="myForm" class="form-horizontal" id="form1"
             action="user"
             method="post">
        <%
          // User u1=(User)request.getAttribute("user");
        %>
        <w:set var="u1" value="${requestScope.user}"/>
        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable">姓名</label>
            <div class="col-md-7">

              <input type="hidden" name="action"
                    <%-- value="<%=u1==null?"add":"edit"%>"/>--%>
                     value="${u1==null?"add":"edit"}"/>

              <input type="hidden" name="id"
                  <%--value="<%=u1!=null?u1.getId():""%>"/>--%>
                     value="${u1!=null?u1.id:""}"/>
              <input type="text" name="user" id="user"
                <%-- value="<%=u1!=null?u1.getUsername():""%>"--%>
                     value="${u1!=null?u1.username:""}"
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
                   <%--  value="<%=u1!=null?u1.getPassword():""%>"--%>
                     value="${u1!=null?u1.password:""}"
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
      <%--
        <%

          List<User> list =(List<User>) request.getAttribute("list");
          Iterator<User> it=list.iterator();
          int i=0;

          while(it.hasNext()){
              User u= it.next();
        %>
        --%>
        <w:forEach items="${requestScope.list}" var="u" varStatus="status">
        <tr>
          <td>
         <%-- <%=++i%>--%>
            ${status.count}
          </td>
          <td>
         <%-- <%=u.getUsername()%>--%>
            ${u.username}
          </td>
          <td>
           <%-- <%=u.getPassword()%>--%>
            ${u.password}
          </td>
          <td>
      <%--  <a href="user?action=queryid&&id=<%=u.getId()%>" class="btn btn-success custom-width">编辑</a>
            <a href="user?action=del&&id=<%=u.getId()%>" class="btn btn-danger custom-width">删除</a>
            --%>
        <a href="user?action=queryid&&id=${u.id}" class="btn btn-success custom-width">编辑</a>
        <a href="user?action=del&&id=${u.id}" class="btn btn-danger custom-width">删除</a>
          </td>
        </tr>
        </w:forEach>
      <%
       // }
      %>
        </tbody>
      </table>
    </div>
  </div>
</div>


</body>
</html>