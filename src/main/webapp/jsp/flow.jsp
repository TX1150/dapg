<%--
  Created by IntelliJ IDEA.
  User: Xian
  Date: 2019/8/10
  Time: 1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<html lang="zh">
<head>
    <title>爬虫Ajax抓取测试</title>
    <link rel="stylesheet" href="<%=basePath%>static/library/css/layui.css">
</head>
<body>
    <h1>aaaa</h1>
    <ul id="demo">
        <li>
            <img src="http://www.tigxu.com/a.jpg" alt="404">
        </li>
        <li>
            <img src="http://www.tigxu.com/b.jpg" alt="404">
        </li>
    </ul>
    <script src="<%=basePath%>static/library/layui.js"></script>
    <script>
        layui.use('flow', function(){
            var $ = layui.jquery; //不用额外加载jQuery，flow模块本身是有依赖jQuery的，直接用即可。
            var flow = layui.flow;
            flow.load({
                elem: '#demo' //指定列表容器
                ,done: function(page, next){ //到达临界点（默认滚动触发），触发下一页
                    var lis = [];
                    //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
                    $.get('http://localhost:8080/dapg/ajax?page='+page, function(res){
                        //假设你的列表返回在data集合中
                        layui.each(res.data, function(index, item){
                            lis.push('<li><img src="'+ item +'" alt="404"></li>');
                        });

                        //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                        //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                        console.log(res.eof);
                        next(lis.join(''), res.eof);
                    });
                }
            });
        });
    </script>
</body>
</html>
