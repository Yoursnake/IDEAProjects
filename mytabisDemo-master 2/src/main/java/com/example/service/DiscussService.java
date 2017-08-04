package com.example.service;


import com.example.entity.Discuss;

/**
 * @author weixianbin
 * @date 2017/3/15
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
public interface DiscussService {
    void save(Discuss discuss);
    void remove(Discuss discuss);
    void updateDiscuss(Discuss discuss);
    void getDiscuss(Discuss discuss);

}
