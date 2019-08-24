<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>贤哥导航</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="<%=basePath%>static/library/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>static/library/css/bootstrap.min.css">
    <link rel="icon" href="<%=basePath%>static/library/images/favicon.ico" type="image/x-icon" />

    <style>
        .upresume{
            margin: 0;
            padding: 10px;
            color: #38f;
        }
        .submit{
            width: 25%;
            background: #28f;
            border: none;
            font-size: 18px;
            color: white;
            border-radius: 0 25px 25px 0;
            height: 53px;
            margin-left: -5px;
        }
        .searc-log{
            background: url(<%=basePath%>static/library/images/log.png) no-repeat 50% 50%;
            height: 256px;
            background-size: contain;
        }
        .in-text{
            padding: 12px 10px 12px 30px;
            font-size: 18px;
            border-radius: 25px 0px 0px 25px;
            border: 1px solid #ccc;
            width: 75%;
        }
        .upresume a:hover{
            color: black;
        }
    </style>
</head>
<body>
<div class="upresume">
    <a href="<%=basePath%>upresume" style="float: right;" target="_parent">上传简历</a>
<div style="clear: right;">
    <form action="<%=basePath%>search" method="get">
        <div class="container">
            <div class="row">
                <div  class="col-sm-12 searc-log"></div>
                <div  class="col-sm-12">
                    <input id="key" type="text" class="in-text" name="key" value="test_*">
                    <button id="sub" type="submit" class="submit">搜索</button>
                </div>
            </div>
            <div style="text-align: center;font-size: 14px">*可使用文件名或简历MD5值进行搜索</div>
            <div style="text-align: center;font-size: 14px">*测试文件：test_a.pdf ~ test_z.pdf</div>
            <div id="note" style="text-align: center;font-size: 14px">*请开启JavaScript</div>
        </div>
    </form>
</div>
<script src="<%=basePath%>static/library/js/jquery-3.4.1.min.js"></script>
<script src="<%=basePath%>static/library/js/bootstrap.min.js"></script>
<script src="<%=basePath%>static/library/layui.js"></script>
<script>
    var note    = document.getElementById("note");
    note.style.display="none";
</script>
</body>
</html>