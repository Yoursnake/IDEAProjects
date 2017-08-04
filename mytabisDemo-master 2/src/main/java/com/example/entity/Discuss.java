package com.example.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author weixianbin
 * @date 2017/3/15
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
@Data
public class Discuss {
    /*public Discuss(User founder,String content,Task task){
        this.founder = founder;
        this.content = content;
        this.task = task;
    }*/
    /**
     * 讨论 Id
     */
    private long discussId;
    /**
     * 讨论发起者
     */
    private User founder;
    /**
     * 讨论创建时间
     */
    private Date createTime;
    /**
     * 讨论内容
     */
    private String content;

    private Task task;

}
