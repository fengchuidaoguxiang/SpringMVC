<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/3/3
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>员工列表</h3>
    <h3>员工列表，当前登录用户：${user_in_session.username}</h3>
    <a href="/login.jsp">注销</a>
    <hr/>
    <a href="/employee/input">新增</a>
    <table border="1" cellspacing="0" cellpadding="0" width="500">
        <tr>
            <th>ID</th>
            <th>用户名</th>
            <th>密码</th>
            <th>年龄</th>
            <th>入职日期</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${employees}" var="e">
        <tr>
            <td>${e.id}</td>
            <td>${e.username}</td>
            <td>${e.password}</td>
            <td>${e.age}</td>
            <td>${e.hiredate}</td>
            <td>
                <a href="/employee/delete?id=${e.id}">删除</a>
                <a href="/employee/input?id=${e.id}">编辑</a>
            </td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
