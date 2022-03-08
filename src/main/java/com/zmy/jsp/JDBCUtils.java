package com.zmy.jsp;

import java.sql.*;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-08 17:13
 */
public class JDBCUtils {
    static String url = "jdbc:mysql://localhost:3306/javatest?rewriteBatchedStatements=true";
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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public boolean Query(String user,String psd){
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
            CloseResource(con,ps,rs);
        }
        return false;
    }

    public void CloseResource(Connection con,PreparedStatement ps,ResultSet rs){
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
