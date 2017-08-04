package com.example.mapper;

import com.example.dao.DiscussDao;
import com.example.dao.TaskDao;
import com.example.dao.UserDao;
import com.example.entity.Discuss;
import com.example.entity.Task;
import com.example.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

/**
 * @author weixianbin
 * @date 2017/3/17
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private DiscussDao discussDao;

    @Test
    public void testInsert() throws Exception {
       /*User publisher = userDao.getUserById(3);
       User accpeter = userDao.getUserById(1);

       for (int i = 0; i< 100; i++){
           Task task = new Task(publisher,i+"      oooo ");
           taskDao.save(task);
       }*/
        /*User accpeter = userDao.getUserById(1);
        Task task = taskDao.getTaskById(1);
       Discuss discuss =  new Discuss(accpeter,"dfsdfs",task);
       discussDao.save(discuss);*/
        Task task = taskDao.getTaskById(1);
        System.out.println(task.toString());
    }

}

