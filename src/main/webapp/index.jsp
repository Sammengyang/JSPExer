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
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
    模拟首页
    <br>
    <h1>系统首页</h1>
    <table border="1" cellspacing="0">
        <tr>
            <td>名字</td>
            <td>性别</td>
            <td>用户名</td>
            <td>密码</td>
        </tr>
        <%
            JDBCUtils jdbcUtils = new JDBCUtils();
            List<User> query = jdbcUtils.Query(new User());
            Iterator iterator = query.iterator();
            while (iterator.hasNext()){
            User user = (User) iterator.next();
        %>
        <tr>
            <td><%=user.getName()%></td>
            <td><%=user.getSex()%></td>
            <td><%=user.getUser()%></td>
            <td><%=user.getPassword()%></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>