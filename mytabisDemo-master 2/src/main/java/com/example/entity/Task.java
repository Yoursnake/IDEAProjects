package com.example.entity;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * @author weixianbin
 * @date 2017/3/15
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
@Data
public class Task {
   /* public Task(User publisher, String content,User accepter){
        this.publisher = publisher;
        this.content = content;
        this.accepter = accepter;
    }
    public Task(User publisher, String content){
        this.publisher = publisher;
        this.content = content;
    }*/
    /**
     * 任务 Id
     */
    private long taskId;
    /**
     * 任务发布人
     */
    private User publisher;
    /**
     * 任务发布时间
     */
    private Date createTime;
    /**
     * 任务关闭时间
     */
    private Date closeTime;
    /**
     * 任务内容
     */
    private String content;
    /**
     * 任务接受人
     */

    private User accepter;
    /**
     * 任务是否被接
     */
    private boolean isAccept;
    /**
     * 任务中的交流
     */
    private List<Discuss> discusses;
    /**
     * 任务发布人确认完成任务
     */
    private boolean isAccomplishPublisher;
    /**
     * 任务接受人确定完成任务
     */
    private boolean isAccomplishAccepter;
}
