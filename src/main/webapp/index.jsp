<%@ page import="java.util.Date" %>
<%@ page import="com.zmy.jsp.JDBCUtils" %>
<%@ page import="com.zmy.jsp.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
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
<h1><%= "Hello World!" %>
</h1>
<br/>
    模拟首页
    <br>
    <h1>系统首页</h1>
    <%

    %>
    <table border="1" cellspacing="0">
        <tr>
            <td>名字</td>
            <td>性别</td>
            <td>用户名</td>
            <td>密码</td>
            <td>爱好</td>
        </tr>
        <%
            JDBCUtils jdbcUtils = new JDBCUtils();
            List<User> query = jdbcUtils.Query(new User());
            Iterator iterator = query.iterator();
            String str ="";
            String [] hobby = (String[]) request.getAttribute("hobby");
            for (int i=0;i<hobby.length;i++){
                str+=hobby[i]+" ";
            }
            while (iterator.hasNext()){
            User user = (User) iterator.next();
        %>
        <tr>
            <td><%=user.getName()%></td>
            <td><%=user.getSex()%></td>
            <td><%=user.getUser()%></td>
            <td><%=user.getPassword()%></td>
            <td><%=str%></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>