<%--
  Created by IntelliJ IDEA.
  User: 18400
  Date: 2019/10/30
  Time: 22:32
 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1><%= request.getSession().getAttribute("user")%></h1>
</body>
</html>
