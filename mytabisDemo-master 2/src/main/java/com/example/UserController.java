package com.example;

import com.example.dao.TaskDao;
import com.example.dao.UserDao;
import com.example.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author weixianbin
 * @date 2017/3/17
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
@RestController
public class UserController {
    @Autowired
    UserDao userDao;

    @Autowired
    TaskDao taskDao;
    @RequestMapping(value = "/add")
    public List<Task> add() {
        return taskDao.listTaskAll();
    }

    @RequestMapping(value = "/get")
    public String get(){
        return "Hello World!";
    }
}
