<%--
  Created by IntelliJ IDEA.
  User: wym
  Date: 2017/11/2
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>application</title>
</head>
<body>
<%
    int count=Integer.parseInt(application.getInitParameter("count"));
    if(application.getAttribute("num")==null) //如果没有该键
    {
        application.setAttribute("num",count);
    }
    int num=Integer.parseInt(application.getAttribute("num").toString());
    application.setAttribute("num",++num);
%>
<h1>该网页有<%=application.getAttribute("num").toString()%> 浏览量</h1>

</body>
</html>
