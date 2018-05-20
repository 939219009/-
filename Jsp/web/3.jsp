<%--
  Created by IntelliJ IDEA.
  User: wym
  Date: 2017/10/31
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  import="com.wym.vo.Animal"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    Animal a=new Animal();
    a.setOld(22);
    a.setColor("red");
%>
<%=a.getColor()%>
<%=a.getOld()%>
<form id="id" action="2.jsp"  method="get"enctype="application/x-www-form-urlencoded">
用户名 ：<input type="text" name="username" />
密码 ：<input type="password" name="pwd" />
    <input type="submit" name="submit" value="提交"/>
</form>
</body>
</html>
