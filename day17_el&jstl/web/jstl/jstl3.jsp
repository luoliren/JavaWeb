<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 18400
  Date: 2019/11/1
  Time: 13:02
 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>foreach标签</title>
</head>
<body>
    <%--

        foreach相当于java代码的for语句
        1.完成重复操作
        for(int i = 0 ; i < 10 ; i ++) {
        }
        *属性：
            begin:开始值
            end:结束值
            var：临时变量
            step:步长 2 i+2
            varStatus:；循环状态的对象
                index:容器中元素的索引，从0开始
                count:循环次数
        2.遍历容器
        List<User> list;
        for(USer user:list) {
        }
        属性
            items:容器对象 相当于list
            var:容器元素的临时变量 相当于 user

    --%>

<c:forEach begin="1" end="10" var="i" step="2" varStatus="s">
    ${i}${s.index}${s.count}<br>
</c:forEach>


    <hr>
    <%
        List list = new ArrayList();
        list.add("aaaa");
        list.add("bbbb");
        list.add("cccc");

        request.setAttribute("list",list);


    %>
    <c:forEach items="${list}" var="str" varStatus="s">
        ${s.index} ${s.count} ${str}<br>
    </c:forEach>

</body>
</html>
