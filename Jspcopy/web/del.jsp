<%@ page import="com.wym.service.IUserService" %>
<%@ page import="com.wym.service.IUserServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: wym
  Date: 2017/11/4
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String id=request.getParameter("id");
    IUserService service=new IUserServiceImpl();

    if(service.del(Integer.parseInt(id))){
%>
<script type="text/javascript">
    window.location="submit.jsp";
</script>
<%
}else {
%>
<script type="text/javascript">
    alert("删除失败");
    window.location="submit.jsp";
</script>
<%
    }
%>
</body>
</html>
