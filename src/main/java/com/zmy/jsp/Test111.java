package com.zmy.jsp;

import org.junit.Test;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-08 17:31
 */
public class Test111 {
    @Test
    public void test1(){
        JDBCUtils jdbcUtils = new JDBCUtils();
        System.out.println(jdbcUtils.Query("sam", "123456"));
    }
}