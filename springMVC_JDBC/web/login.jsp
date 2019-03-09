<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/3/3
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <span style="color:red">${errorMsg}</span>
    <%
        session.invalidate();
    %>
    <h3>登录界面</h3>
    <form action="/login" method="post">
        账户<input type="text" name="username" /><br/>
        密码<input type="text" name="password" /><br/>
        <input type="submit" value="登录"/>
    </form>
</body>
</html>
