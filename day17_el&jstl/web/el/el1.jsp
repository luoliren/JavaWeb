<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 18400
  Date: 2019/11/1
  Time: 9:40
 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
</head>
<body>



        ${3 > 4}
       \${3 > 4}
<hr>
<h1>算术运算符</h1>
${3 + 4}<br>
${3 / 4}<br>
${3 div 4}<br>
${3 % 4}<br>
${3 mod 4}<br>
        <h1>比较运算符</h1>
        ${3 == 4}<br>


        <h1>逻辑运算符</h1>
        ${3 > 4 && 3 < 4}<br>
        ${3 > 4 and 3 < 4}<br>

        <h1>empty运算符</h1>
        <%
            String string = "";//null ,""用empty的结果都是true
            request.setAttribute("str",string);

            List list = new ArrayList();
            request.setAttribute("list",list);
        %>
    ${ empty str}
    ${not empty list}
</body>
</html>
