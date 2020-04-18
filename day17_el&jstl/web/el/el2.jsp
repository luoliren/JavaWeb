<%--
  Created by IntelliJ IDEA.
  User: 18400
  Date: 2019/11/1
  Time: 10:36
 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取域中的数据</title>
</head>
<body>

<%
    //在域存储数据
    request.setAttribute("name","zhangsan");
    session.setAttribute("age","23");
    session.setAttribute("name","李四");

%>
    <h1>el获取值</h1>
    ${requestScope.name}
    ${sessionScope.age}
    ${sessionScope.name}
    ${sessionScope.haha}

${name}
</body>
</html>
