package com.zmy.jsp;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-08 16:23
 */
public class LoginUtil {

    public boolean login(String name,String psd){
        System.out.println(name+psd);
        JDBCUtils jdbcUtils = new JDBCUtils();
        return jdbcUtils.isLogin(name,psd);
    }
}
