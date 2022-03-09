<%@ page import="com.zmy.jsp.RegisterUtil" %>
<%@ page import="com.zmy.jsp.User" %>
<%  request.setCharacterEncoding( "utf-8");%>
<% response.setCharacterEncoding("utf-8"); %><%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/3/9
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String name = request.getParameter("name");
    String sex = request.getParameter("sex");
    String hobby = "";
    String[] hobbies = request.getParameterValues("hobby");
    for (int i = 0; i < hobbies.length; i++) {
        hobby+=hobbies[i]+" ";
    }
    RegisterUtil loginUtil = new RegisterUtil();
    User user = new User(username,password,name,sex,hobby);
    boolean login = loginUtil.login(user);
    if (login&&username!=null&&password!=null){
        request.getRequestDispatcher("Register.jsp").forward(request,response);
    }else {
        request.getRequestDispatcher("Login.jsp").forward(request,response);
    }
%>
</body>
</html>
