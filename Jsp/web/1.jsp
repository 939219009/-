<%--
  Created by IntelliJ IDEA.
  User: wym
  Date: 2017/10/31
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
     for(int i=0;i<10;i++)
     {
         if(i%2==0){
%>
   <font color='red'><%=i%></font>
<%
    }else{
%>
   <font color='yellow'><%=i%></font>
<%
     }
    }
%>
</body>
</html>
