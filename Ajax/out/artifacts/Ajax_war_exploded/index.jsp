<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: wym
  Date: 2017/11/24
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
   String user=request.getParameter("user");
   String desc=request.getParameter("desc");
   String book=request.getParameter("book");
   user="Hello"+user;
   response.setContentType("text/html");
   response.setCharacterEncoding("utf-8");
   PrintWriter outt =response.getWriter();
   outt.print(user+"<br/>");
   outt.print(desc);
   outt.print(book);
   outt.flush();
   outt.close();

%>
