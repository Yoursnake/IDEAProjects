package com.example.dao;


import com.example.entity.Task;

import java.util.List;

/**
 * @author weixianbin
 * @date 2017/3/15
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
public interface TaskDao {
    int save(Task task);
    int remove(long id);
     int updateTask(Task task);

    Task getTaskById(long id);
    List<Task> listTaskAll();
}
