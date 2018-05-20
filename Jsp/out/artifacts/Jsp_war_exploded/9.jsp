<%--
  Created by IntelliJ IDEA.
  User: wym
  Date: 2017/11/2
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=request.getQueryString()%>
<%
    request.setCharacterEncoding("UTF-8");//Tomcat默认字符编码 ISO-8859 改为请求页面一致的编码
    String username=request.getParameter("username");//取地址栏的内容；
    String pwd=request.getParameter("pwd");
    //out.print(username);
    String[] str=request.getParameterValues("interest");
    for(String s:str)
    {
%>
     <%=s%>
<%
    }
%>
<%=username%>
<%=pwd%>
</body>
</html>
