package com.example.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by shengliyi on 2017/4/2.
 */
@Data
public class Student {

    /**
     * 学号
     */
    private long id;
    /**
     * 姓名
     */
    private String studentName;
    /**
     * 年龄
     */
    private int age;
    /**
     * 性别，true表示男，false表示女
     */
    private boolean sex;
    /**
     * 生日
     */
    private Date birthday;
}
