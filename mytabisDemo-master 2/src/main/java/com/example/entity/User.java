package com.example.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * @author weixianbin
 * @date 2017/3/15
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
@Data
public class User implements Serializable {
    public User(){
        super();
    }
    /*public User(String username,String email, String phone,String password){
        super();
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }*/
    /**
     * 用户 Id
     */
    private long  userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户电话
     */
    private String phone;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户上次登录时间
     */
    private Date lastLoginTime;
    /**
     * 用户角色
     */
    private String role;
}
