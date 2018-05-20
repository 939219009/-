<%--
  Created by IntelliJ IDEA.
  User: wym
  Date: 2017/11/2
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>猜字母游戏</title>
    <meta charset="UTF-8"/>
</head>
<body>
<%
    char count=(char)(Math.random()*26+'a');
    session.setAttribute("rand",count);
   // out.print(count);
%>
<form method="post" action="12.jsp" name="form" id="form">
 请输入你要猜的字母：<br/><input type="text" name="gess"/>
 <input type="submit" value="确认"/>

</form>
</body>
</html>
