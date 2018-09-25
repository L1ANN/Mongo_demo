<%--
  Created by IntelliJ IDEA.
  User: lianpengfei
  Date: 2018/9/20
  Time: 下午6:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
    <form action="/file/upload.action" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <input type="submit" name="确认">
    </form>

    <a href="/file/download.action?fileName=1.png">下载</a>
</body>
</html>
