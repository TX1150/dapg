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
    <meta charset="utf-8" />
    <link href="<%=basePath%>static/library/css/login.css" type="text/css" rel="stylesheet" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="<%=basePath%>static/library/images/favicon.ico" type="image/x-icon" />

</head>
<body style="background: #fff url(<%=basePath%>static/library/images/48253260_p0_master1200.jpg) no-repeat; background-attachment: fixed; background-size: 100% 100%;">
<div class="user-body-bg"></div>
<div class="user-login-bg"></div>
<div class="user-bottom-bg"></div>
<div class="login-box">
    <form action="<%=basePath%>login" method="post">
        <label class="form-inline">
            <div class="form-inline-font">
                用户名 :
            </div>
            <div class="form-inline-input">
                <input type="text" name="username" maxlength="8"/>
            </div>
        </label>
        <label class="form-inline">
            <div class="form-inline-font">
                密码 :
            </div>
            <div class="form-inline-input">
                <input type="password" name="password" maxlength="16" />
            </div>
        </label>
        <label class="form-inline">
            <div class="form-inline-font">
                验证 :
            </div>
            <div class="form-inline-input">
                <div class="code-box" id="code-box">
                    <input type="text" name="code" class="code-input" />
                    <p></p>
                    <span>>>></span>
                </div>
            </div>
        </label>

        <div class="login-btn">
            <div class="user-btn-link">
                <a href="">找回密码？</a>
            </div>
            <button type="submit">登录</button>
        </div>
    </form>
</div>
<script src="<%=basePath%>static/library/js/login.js"></script>
<script>

    window.addEventListener('load',function(){

        //code是后台传入的验证字符串
        var code = "jsaidaisd656",
            codeFn = new moveCode(code);

        //获取当前的code值
        //console.log(codeFn.getCode());

        //改变code值
        //code = '46asd546as5';
        //codeFn.setCode(code);

        //重置为初始状态
        //codeFn.resetCode();
    });
</script>
</body>
</html>
