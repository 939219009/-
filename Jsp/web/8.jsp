<%--
  Created by IntelliJ IDEA.
  User: wym
  Date: 2017/11/2
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8"/>
</head>
<body>
<%
    request.setAttribute("username","wym");
    session.setAttribute("use","girl");
%>
<%--<jsp:include page="10.jsp"/>--%>
<a href="10.jsp">跳转10.jsp</a>
<form method="get" action="9.jsp" name="form">
    用户： <input type="text" name="username"/><br/>
    密码： <input type="password" name="pwd"/><br/>
    爱好： 足球<input type="checkbox" value="foot" name="interest"/>
           篮球<input type="checkbox" value="bask" name="interest"/>
           排球<input type="checkbox" value="voll" name="interest"/>
    <input type="submit" name="submit" value="确认">
</form>
</body>
</html>
