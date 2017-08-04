package com.example.dao;


import com.example.entity.Discuss;

/**
 * @author weixianbin
 * @date 2017/3/15
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
public interface DiscussDao {
    int save(Discuss discuss);
    int remove(long id);
    int updateDiscuss(Discuss discuss);

    Discuss getDiscussById(long id);
}
