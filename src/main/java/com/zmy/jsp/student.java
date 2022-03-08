package com.zmy.jsp;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-08 22:29
 */
public class student {
    private Integer index;
    private String name;
    private String sex;
    private Integer age;

    public student(Integer index, String name, String sex, Integer age) {
        this.index = index;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
