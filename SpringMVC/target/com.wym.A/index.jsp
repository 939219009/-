<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/31
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/h1/go2">第一个SpringMVC</a>
<form action="/h1/go">
    用户名:<input type="text" name="username"/><br/>
    密码：<input type="text" name="password"/><br/>
    <input type="submit" name="submit"/><br/>
</form>

<a href="/h1/ok?username=wym">通过RequestParam传值</a><br/>
<a href="/h1/ok1?role=wym&&role=ext">通过RequestParam传多值</a><br/>
<a href="/h1/ant/username/wxt">通过PathVariable传值</a><br/>
<a href="/h1/cookie">通过Cookie传值</a><br/>
<a href="/h2/session">通过Session传值</a><br/>

<h1>通过ModelAttribute前->后传值</h1>
<form action="/model/go">
    用户名:<input type="text" name="username"><br/>
    密码：<input type="password" name="password"><br/>
    <input type="submit">
</form>
<h1>通过ModelAttribute前->后 后—>前传值</h1>
<form action="/model/ok">
    用户名:<input type="text" name="username"><br/>
    密码：<input type="password" name="password"><br/>
    <input type="submit">
</form>

<a href="/model/oklist">后->前传列表</a><br/>
<a href="/model/okmap">后->前传列表map</a><br/>

<a href="/vc/show">校验</a>
</body>
</html>
