<%@ page import="com.zmy.jsp.RegisterUtil" %><%--
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
    String [] hobby = request.getParameterValues("hobby");
    request.setAttribute("hobby",hobby);
    RegisterUtil loginUtil = new RegisterUtil();
    boolean register = loginUtil.Register(username, password);
    if (register){
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }else {
        request.getRequestDispatcher("fail.jsp").forward(request,response);
    }
%>
</body>
</html>
