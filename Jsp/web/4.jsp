<%--
  Created by IntelliJ IDEA.
  User: wym
  Date: 2017/10/31
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"%>
<html>
<head>
    <title>useBean</title>
</head>
<body>
<!-- 实例化-->
<jsp:useBean id="a" class="com.wym.vo.Animal">
    <jsp:setProperty name="a" property="color" value="blue" />
    <jsp:setProperty name="a" property="old" value="100"/>
</jsp:useBean>
<jsp:getProperty name="a" property="color"/>
<jsp:getProperty name="a" property="old"/>
<%--
<%
    a.setColor("yellow");
%>-
<%=a.getColor()%><br/>
<%=a.getOld()%>
--%>
</body>
</html>
