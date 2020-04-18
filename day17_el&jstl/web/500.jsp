<%--
  Created by IntelliJ IDEA.
  User: 18400
  Date: 2019/10/31
  Time: 9:43
 
--%><%--要想用exception对象必须设置isErrorPage为true 否则用不了--%>
<%@ page contentType="text/html;charset=UTF-8"  isErrorPage="true" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>服务器异常</h1>
<%
    String message = exception.getMessage();
    out.print(message);
%>
</body>
</html>
