<%--
  Created by IntelliJ IDEA.
  User: wym
  Date: 2017/10/31
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name="wym";
    if(name.equals("wym"))
    {
%>
<jsp:forward page="success.jsp">
    <jsp:param name="pwd" value='<%=java.net.URLEncoder.encode("吴云明","UTF-8")%>'/>
</jsp:forward>
<%
    }
    else{
%>
<jsp:forward page="error.jsp">
    <jsp:param name="pwd" value="666"/>
</jsp:forward>
<%
    }
%>

</body>
</html>
