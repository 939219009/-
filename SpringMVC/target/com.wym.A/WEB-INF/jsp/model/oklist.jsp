<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/31
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${stringList}<br/>
<c:forEach items="${stringList}" var="i">
    ${i}
</c:forEach>
</body>
</html>
