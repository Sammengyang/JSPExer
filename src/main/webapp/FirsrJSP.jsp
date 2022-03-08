<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/3/7
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         isErrorPage="true"
%>
<%@ page import="java.util.Map" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
    这里是jsp输出的页面内容
    html数据
    <%= 10%>
    <%= 100%>
    <%= 1000%>
    <%= 10000%>
    <%=request.getParameter("username")%>

    <%
        int i = 12;
        if (i>0){
            System.out.println("true!!!!!");
        }else{
            System.out.println("false!!!!!!");
        }
    %>
    <table border="1" cellspacing="0">
    <%
        for (int j = 0; j < 10; j++) {
    %>
        <tr>
            <td>第<%=j+1%>行</td>
        </tr>
    <%
        }
    %>
    </table>
</body>
</html>
