<%--
  Created by IntelliJ IDEA.
  User: wym
  Date: 2017/10/31
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>head</h1>
<%
    String name=request.getParameter("username");
%>
<%=
    name+" is good boy"
%>