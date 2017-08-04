package com.example.service.Impl;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * @author weixianbin
 * @date 2017/3/15
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public void save(User user) throws Exception {
        if (user == null){
            throw new UsernameNotFoundException("User have some problem");
        }
        userDao.save(user);
    }

    @Override
    public void remove(User user) throws Exception {
        if (user == null){
            throw new UsernameNotFoundException("User have some problem");
        }
        userDao.remove(user.getUserId());
    }

    @Override
    public void updateUser(User user) throws Exception {
        if (user == null){
            throw new UsernameNotFoundException("User have some problem");
        }
        userDao.updateUser(user);
    }

    @Override
    public void getUser(User user) throws Exception {
        if (user == null){
            throw new UsernameNotFoundException("User have some problem");
        }
        userDao.getUserById(user.getUserId());
    }
}
