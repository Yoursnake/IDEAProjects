package com.example.dao;

import com.example.entity.User;

import java.util.List;

/**
 * @author weixianbin
 * @date 2017/3/15
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
public interface UserDao {


    /**
     * 添加用户
     * @param user
     * @return
     */
    int save(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int remove(long id);

    /**
     * 改用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 通过 email 查询用户
     * @param email
     * @return
     */
    User getUserByEmail(String email);

    /**
     * 通过电话号码查询用户
     * @param phone
     * @return
     */
    User getUserByPhone(String phone);

    /**
     * 通过用户 id 查询用户
     * @param id
     * @return
     */
    User getUserById(long id);

    /**
     * 获得所用用户
     * @return
     */
    List<User> listUserAll();
}
