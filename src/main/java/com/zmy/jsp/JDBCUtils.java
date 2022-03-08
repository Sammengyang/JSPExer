package com.zmy.jsp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-08 17:13
 */
public class JDBCUtils {
    static String url = "jdbc:mysql://localhost:3306/javatest?rewriteBatchedStatements=true&useSSL=false";
    static String user = "root";
    static String password = "123456";
    static Connection con = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    /**
     * 获取数据库链接
     * @return
     */
    public Connection getConn(){
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 登录确认
     * @param user
     * @param psd
     * @return
     */
    public boolean isLogin(String user,String psd){
        String sql = "select * from user where user=? and password=?";
        getConn();
        try {
            // 预编译sql语句
            ps = con.prepareStatement(sql);
            // 填充占位符
            ps.setObject(1,user);
            ps.setObject(2,password);
            // 执行sql语句
            rs = ps.executeQuery();
            if (rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            CloseResource();
        }
        return false;
    }

    /**
     * 查询出所有员工
     * @param clazz
     * @return
     */
    public List<User> Query(User clazz){
        List <User> list = new ArrayList<>();
        try {
            getConn();
            String  sql = "select * from user";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                User user = new User(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseResource();
        }
        return list;
    }

    /**
     * 关闭资源
     */
    public void CloseResource(){
        try {
            if (rs!=null)
                rs.close();
            if (ps!=null)
                ps.close();
            if (con!=null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
