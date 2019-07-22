<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>文件上传</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="<%=basePath%>static/library/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>static/library/css/bootstrap.min.css">
    <link rel="icon" href="<%=basePath%>static/library/images/favicon.ico" type="image/x-icon" />

</head>
<body>
<div class="layui-upload">
    <div class="container">
        <div class="row">
            <div  class="col-sm-4 searc-log">
                <button type="button" class="layui-btn layui-btn-normal" id="test8">选择文件</button>
            </div>
            <div  class="col-sm-4 searc-log">
                <button type="button" class="layui-btn" id="test9" style="text-align: center;">开始上传</button>
            </div>
        </div>
    </div>
</div>

<script src="<%=basePath%>static/library/js/jquery-3.4.1.min.js"></script>
<script src="<%=basePath%>static/library/js/bootstrap.min.js"></script>
<script src="<%=basePath%>static/library/layui.js"></script>
<script>
    layui.use('upload', function() {
        var $ = layui.jquery, upload = layui.upload;
        upload.render({
            elem: '#test8'
            , url: '<%=basePath%>upload/${path}'
            , auto: false
            //,multiple: true
            , bindAction: '#test9'
            , done: function (res) {
                console.log(res)
            }
        });
    });
</script>
</body>
</html>
