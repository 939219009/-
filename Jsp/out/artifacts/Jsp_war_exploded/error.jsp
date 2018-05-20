<%--
  Created by IntelliJ IDEA.
  User: wym
  Date: 2017/10/31
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>ERROR</h1>
<%=
    java.net.URLDecoder.decode(request.getParameter("pwd"),"utf-8")
%>
</body>
</html>
