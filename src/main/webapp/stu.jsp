<%@ page import="java.util.List" %>
<%@ page import="com.zmy.jsp.student" %><%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/3/8
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border: 1px red solid;
            width: 600px;
            border-collapse: collapse;
        }
        td,th{
            border: 1px red solid;
        }
    </style>
</head>
<body>
    <%
        List<student> stulist = (List<student>)request.getAttribute("stulist");
    %>
    <table>
        <tr>
            <td>序号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
        </tr>
    <%
        for (int i = 0; i < 10; i++) {
            student stu = stulist.get(i);
    %>
        <tr>
            <td><%=stu.getIndex()%></td>
            <td>学生<%=stu.getName()%></td>
            <td><%=stu.getSex()%></td>
            <td><%=stu.getAge()%></td>
        </tr>
    <%
        }
    %>
    </table>
</body>
</html>
