<%--
  Created by IntelliJ IDEA.
  User: wym
  Date: 2017/11/2
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <%
       pageContext.setAttribute("school","hlg");
   %>
<%@include file="15.jsp"%>
<jsp:include page="15.jsp"/>
</body>
</html>
