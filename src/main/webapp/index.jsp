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
    <script src="js/jquery-3.6.0.js" type="text/javascript"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

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
    <table class="table table-condensed">
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
            /**
             * 获取复选框的数
             */
//            String str ="";
//            String [] hobby = (String[]) request.getAttribute("hobby");
//            for (int i=0;i<hobby.length;i++){
//                str+=hobby[i]+" ";
//            }
            while (iterator.hasNext()){
            User user = (User) iterator.next();
        %>
        <tr>
            <td><%=user.getName()%></td>
            <td>${user.getName()}</td>
            <td><%=user.getSex()%></td>
            <td><%=user.getUser()%></td>
            <td><%=user.getPassword()%></td>
            <td><%=user.getHobby()%></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>