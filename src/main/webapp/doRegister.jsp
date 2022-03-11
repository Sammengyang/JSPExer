<%@ page import="com.zmy.jsp.RegisterUtil" %>
<%@ page import="com.zmy.jsp.JDBCUtils" %>
<%@ page import="com.zmy.jsp.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/3/8
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>模拟后台</title>
</head>
<body>
  <h2>实现数据的接收和处理</h2>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String role = request.getParameter("role");
    RegisterUtil loginUtil = new RegisterUtil();
    boolean register = loginUtil.Register(username, password);
    if (register){
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }else {
        // 将用户名放入cookie中
        Cookie cookie = new Cookie("username",username);
        // 把cookie发送到客户端
        response.addCookie(cookie);
        request.getRequestDispatcher("fail.jsp").forward(request,response);
    }
%>
</body>
</html>
