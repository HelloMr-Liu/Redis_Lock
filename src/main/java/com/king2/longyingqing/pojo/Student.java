package com.king2.longyingqing.pojo;

import lombok.Data;

/**
 * ================================================================
 * 说明：当前类说说明
 * <p>
 * 作者          时间                    注释
 * 刘梓江    2020/4/27  13:27            创建
 * =================================================================
 **/
@Data
public class Student {
    private String name;
    private String age;
    private String address;
    public Student(String name, String age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Student(){}
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
