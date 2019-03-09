<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/3/3
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--<c:forEach var="err" items="${errors}">--%>
        <%--<span style="color:red">${err.defaultMessage}</span><br/>--%>
    <%--</c:forEach>--%>

    <h3>编辑员工</h3>
    <%--<form action="/employee/saveOrUpdate" method="post">--%>
        <%--<input type="hidden" name="id" value="${employee.id}"/><br/>--%>
        <%--账户<input type="text" name="username" value="${employee.username}"/><br/>--%>
        <%--密码<input type="text" name="password" value="${employee.password}"/><br/>--%>
        <%--年龄<input type="text" name="age" value="${employee.age}"><br/>--%>
        <%--入职<input type="text" name="hiredate" value="${employee.hiredate}"/><br/>--%>
        <%--<input type="submit" value="保存"/>--%>
    <%--</form>--%>

 <hr/>
    <form:form action="/employee/saveOrUpdate" modelAttribute="employee">
        <form:errors path="*"/>
        <form:hidden path="id"/><br/>
        账号<form:input path="username"/><form:errors path="username"/><br/>
        密码<form:password path="password" showPassword="true"/><form:errors path="password"/><br/>
        年龄<form:input path="age"/><br/>
        入职<form:input path="hiredate"/><br/>
        <input type="submit" value="保存"/>
    </form:form>
</body>
</html>
