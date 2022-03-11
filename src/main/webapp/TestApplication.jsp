<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/3/9
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示网站的访问量</title>
</head>
<body>
    <%
        Integer count = (Integer) application.getAttribute("count");
        if (count==null){
            count=new Integer(1);
        }
    %>
    <h2>访问量<%=count%></h2>
    <%
        application.setAttribute("count",++count);
    %>
</body>
</html>
