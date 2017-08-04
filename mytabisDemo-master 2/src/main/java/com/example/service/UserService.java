package com.example.service;


import com.example.entity.User;

/**
 * @author weixianbin
 * @date 2017/3/15
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
public interface UserService {
    void save(User user) throws  Exception;
    void remove(User user) throws  Exception;
    void updateUser(User user) throws Exception;
    void getUser(User user) throws Exception;
}
