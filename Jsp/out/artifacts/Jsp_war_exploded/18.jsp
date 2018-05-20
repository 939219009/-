<%--
  Created by IntelliJ IDEA.
  User: wym
  Date: 2017/11/2
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cookie[] cs=request.getCookies();
    for(Cookie c:cs)
    {
        if(c.getName().equals("user")){
            out.print(c.getValue());
        }
            else if(c.getName().equals("pwd")){
                out.print(c.getValue());
    }
    }
%>
</body>
</html>
