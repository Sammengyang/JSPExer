package com.zmy.jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-08 22:25
 */
@WebServlet("/student")
public class Stu extends HttpServlet {
    List<student> list = new ArrayList();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (int i = 0; i < 10; i++) {
            int t = i+1;
            list.add(new student(t,"name"+t,"男",20+t));
        }
        // 将学生的信息保存到reques域中
        req.setAttribute("stulist",list);
        // 请求转发到stu.jsp页面
        req.getRequestDispatcher("stu.jsp").forward(req,resp);
    }
}
