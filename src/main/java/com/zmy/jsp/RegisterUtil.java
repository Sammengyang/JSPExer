package com.zmy.jsp;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-08 16:23
 */
public class RegisterUtil {

    public boolean Register(String name,String psd){
        JDBCUtils jdbcUtils = new JDBCUtils();
        return jdbcUtils.Register(name,psd);
    }
    public boolean login(User user){
        JDBCUtils jdbcUtils = new JDBCUtils();
        return jdbcUtils.Login(user);
    }
}
