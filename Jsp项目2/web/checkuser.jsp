<%--
  Created by IntelliJ IDEA.
  User: wym
  Date: 2017/11/3
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="com.wym.vo.User" pageEncoding="utf-8" %>
<jsp:useBean id="service" class="com.wym.service.IUserServiceImpl"/>
<%
     request.setCharacterEncoding("utf-8");
    /*String u1=request.getParameter("user").toString();
    String username=new String(u1.getBytes("ISO8859-1"),"UTF-8");*/
    String username=request.getParameter("user");
    String password=request.getParameter("pwd");

    String id=request.getParameter("id");

    User user=new User();
    user.setUsername(username);
    user.setPassword(password);

    if(service.queryUserByUsername(username)){
%>
    <script type="text/javascript">
    alert("改用户已被注册！");
    window.location="submit.jsp";
    </script>
<%
        return;
    }
    if(id!=""){
        user.setId(Integer.parseInt(id));
        if(service.update(user)){

%>
       <script type="text/javascript">
       alert("修改成功");
       window.location="submit.jsp";
       </script>
<%
       }else {
%>
       <script type="text/javascript">
       alert("修改失败");
       window.location="submit.jsp";
       </script>
<%
       }
     }else{
        if(service.add(user)){
%>
       <script type="text/javascript">
       alert("注册成功");
       window.location="submit.jsp";
       </script>
<%
       }else {
%>
       <script type="text/javascript">
       alert("注册失败");
       window.location="submit.jsp";
       </script>
<%
    }
%>

<%
    }
%>


