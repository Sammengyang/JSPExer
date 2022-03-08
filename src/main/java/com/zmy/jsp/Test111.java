package com.zmy.jsp;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-08 17:31
 */
public class Test111 {
    @Test
    public void test1(){
        JDBCUtils jdbcUtils = new JDBCUtils();
//        System.out.println(jdbcUtils.isLogin("sam", "123456"));
        List<User> query = jdbcUtils.Query(new User());
        Iterator iterator = query.iterator();
        while (iterator.hasNext()){
            User user = (User) iterator.next();
            System.out.println(user.toString());
        }
    }

}
