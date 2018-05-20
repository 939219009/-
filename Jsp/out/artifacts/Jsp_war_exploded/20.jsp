<%--
  Created by IntelliJ IDEA.
  User: wym
  Date: 2018/2/6
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.wym.vo.Animal"%>
<html>
<head>
    <title>Title</title>
    <%
        Animal animal=new Animal(10,"red");
    %>
</head>
<body>


<%=animal.getColor()%>
<br/>
<%
    out.print(animal.getOld());
%>
</body>
</html>
