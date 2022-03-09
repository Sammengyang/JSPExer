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
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }
    // 登录
    public boolean Register(String user,String password){
        String login = isExist(user, password);
        if (login!=null){
            return true;
        }
        return false;
    }
    // 注册
    public boolean Login(User user){
        String login = isExist(user.getName(), user.getPassword());
        if (login==null){
            // 注册成功添加到数据库
            AddOne(user);
            return true;
        }
        return false;
    }
    /**
     * 遍历数据库是否存对应的数据，存在返回对象，不存在返回null
     * @param user
     * @param psd
     * @return
     */
    public String isExist(String user,String psd){
        String sql = "select * from user where user=? and password=?";
        getConn();
        try {
            // 预编译sql语句
            ps = con.prepareStatement(sql);
            // 填充占位符
            ps.setObject(1,user);
            ps.setObject(2,psd);
            // 执行sql语句
            rs = ps.executeQuery();
            if (rs.next()){
                if (user.equals(rs.getString("user"))&&
                    psd.equals(rs.getString("password"))){
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            CloseResource();
        }
        return null;
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
                        rs.getString(4),
                        rs.getString(5)
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

    // 添加用户
    public void AddOne(User user){
        getConn();
        String sql = "insert into user values(?,?,?,?,?)";
        try {
            // 预编译sql语句
            ps = con.prepareStatement(sql);
            // 填充占位符
            ps.setObject(1,user.getUser());
            ps.setObject(2,user.getPassword());
            ps.setObject(3,user.getName());
            ps.setObject(4,user.getSex());
            ps.setObject(5,user.getHobby());
            // 执行sql语句
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 关闭资源
            CloseResource(con,ps);
        }
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
    public void CloseResource(Connection conn,PreparedStatement pss){
        try {
            if (pss!=null)
                ps.close();
            if (conn!=null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
