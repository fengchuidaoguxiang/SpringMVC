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
    <form action="/save" method="post" enctype="multipart/form-data">
        姓名：<input type="text" name="username"/><br/>
        年龄：<input type="text" name="age"/><br/>
        文件：<input type="file" name="pic"/><br/>
             <input type="submit" name="提交"/>
    </form>
    <hr/>
    <a href="/download2?filename=13163193_145819676170_2.zip">13163193_145819676170_2.zip</a>
</body>
</html>
