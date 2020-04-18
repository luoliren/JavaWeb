<%@ page import="cn.itcast.domain.User" %>
<%@ page import="sun.rmi.server.UnicastServerRef" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: 18400
  Date: 2019/11/1
  Time: 10:47
 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取数据</title>
</head>
<body>
    <%
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setBirthday(new Date());

        request.setAttribute("u",user);

        List list =new ArrayList();
        list.add("aaaa");
        list.add(1);
        list.add("cccc");
        request.setAttribute("list",list);


        Map map = new HashMap();
        map.put("sname","李四");
        map.put("gender","男");
        map.put("user",user);
        request.setAttribute("map",map);

    %>

<h1>el获取对象中的值</h1>

${requestScope.u}

<%--
    通过对象的属性来获取
        setter和getter方法，去掉set和get，再将剩余的部分，首字母变小写
        setName--->Name--->name
--%>
${requestScope.u.name}<br>
${u.birthday.month}<br>
${u.birthday.year}<br>
${u.birStr}<br>
${u.age}<br>


    <h1>el获取List中的值</h1>
    ${list}<br>
    ${list[0]}<br>
    ${list[1]}<br>
    ${list[10]}<br>//不报错直接打印空字符串



    <h1>el获取Map中的值</h1>
    ${map.gender}<br>
    ${map["gender"]}<br>
    ${map.user.name}


</body>
</html>
