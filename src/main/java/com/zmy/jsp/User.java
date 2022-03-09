package com.zmy.jsp;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-08 17:41
 */
public class User {
    private String user;
    private String password;
    private String name;
    private String sex;
    private String hobby;

    public User() {
    }

    public User(String user, String password, String name, String sex, String hobby) {
        this.user = user;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.hobby = hobby;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
