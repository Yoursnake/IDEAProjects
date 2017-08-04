package com.example.service;


import com.example.entity.Task;

/**
 * @author weixianbin
 * @date 2017/3/15
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
public interface TaskService {
    void save(Task task);
    void remove(Task task);
    void updateTask(Task task);
    void getTask(Task task);
}
