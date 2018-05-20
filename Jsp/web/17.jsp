<%--
  Created by IntelliJ IDEA.
  User: wym
  Date: 2017/11/2
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cookie c=new Cookie("user","wym");
    c.setMaxAge(100);
    Cookie c2=new Cookie("pwd","939219009");
    c2.setMaxAge(100);
    response.addCookie(c);
    response.addCookie(c2);
//    c.setMaxAge(0);
//    response.addCookie(c);
//    c2.setMaxAge(0);
%>
<h3>存储成功</h3>
<a href="18.jsp">点击</a>
</body>
</html>
