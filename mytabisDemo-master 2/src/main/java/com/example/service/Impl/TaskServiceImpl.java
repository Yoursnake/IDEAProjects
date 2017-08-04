package com.example.service.Impl;

import com.example.dao.TaskDao;
import com.example.entity.Task;
import com.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author weixianbin
 * @date 2017/3/15
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskDao taskDao;

    @Override
    public void save(Task task) {
        taskDao.save(task);
    }

    @Override
    public void remove(Task task) {
        taskDao.remove(task.getTaskId());
    }

    @Override
    public void updateTask(Task task) {
        taskDao.updateTask(task);
    }

    @Override
    public void getTask(Task task) {
        taskDao.getTaskById(task.getTaskId());
    }
}
