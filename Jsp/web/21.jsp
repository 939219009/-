<%--
  Created by IntelliJ IDEA.
  User: wym
  Date: 2018/2/7
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=config.getServletName()%>
<%=config.getServletContext()%>
<%=config.getInitParameter("count")%>
</body>
</html>
