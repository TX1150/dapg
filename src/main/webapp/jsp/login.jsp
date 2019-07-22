<%--
  Created by IntelliJ IDEA.
  User: Xian
  Date: 2019/7/22
  Time: 3:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="icon" href="<%=basePath%>static/library/images/favicon.ico" type="image/x-icon" />

</head>
<body>
    <form action="<%=basePath%>login" method="post">
        <input type="text" name="username">
        <input type="password" name="password">
        <input type="submit" value="提交">
    </form>
</body>
</html>
