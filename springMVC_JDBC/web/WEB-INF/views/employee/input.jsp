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
    <h3>编辑员工</h3>
    <form action="/employee/saveOrUpdate" method="post">
        <input type="hidden" name="id" value="${employee.id}"/><br/>
        账户<input type="text" name="username" value="${employee.username}"/><br/>
        密码<input type="text" name="password" value="${employee.password}"/><br/>
        年龄<input type="text" name="age" value="${employee.age}"><br/>
        入职<input type="text" name="hiredate" value="${employee.hiredate}"/><br/>
        <input type="submit" value="保存"/>
    </form>
</body>
</html>
