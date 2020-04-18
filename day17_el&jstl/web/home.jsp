<%--
  Created by IntelliJ IDEA.
  User: 18400
  Date: 2019/10/31
  Time: 9:56
 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="top.jsp"%>
<html>
<head>
    <title>Title</title>

</head>
<body>
        <%
            pageContext.setAttribute("msg","" +"hello");

        %>





        <%=pageContext.getAttribute("msg")%>
</body>
</html>
