<%--
  Created by IntelliJ IDEA.
  User: wym
  Date: 2017/11/2
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=//取内存，不可跨页；
   request.getAttribute("username")
%>
<%
    //清除一个session键
    session.removeAttribute("use");
    //清除所以键，后get无效
   // session.invalidate();
%>
<%=//取内存，可以跨页
    session.getAttribute("use")
%>
</body>
</html>
