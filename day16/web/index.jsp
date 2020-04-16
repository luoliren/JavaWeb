<%--
  Created by IntelliJ IDEA.
  User: 18400
  Date: 2019/10/28
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
   <body>
  <% response.getWriter().write("response"); %>
  <%
    int i = 5;
    System.out.println("hello");
  %>
  <%!
    int i = 3;
  %>
  <%=//servelt中
  i
  %>
    <h1>hi-jsp</h1>
  <% response.getWriter().write("response...."); %>
  </body>
</html>
