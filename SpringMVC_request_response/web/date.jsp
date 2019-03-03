<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/3/2
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("myDate",new Date());
    %>
    北京时间：<fmt:formatDate value="${myDate}" pattern="yyyy-MM-dd HH:mm:ss"/><br/>
    北京时间：${myDate}
</body>
</html>
