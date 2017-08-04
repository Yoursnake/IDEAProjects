package com.example.service.Impl;

import com.example.dao.DiscussDao;
import com.example.entity.Discuss;
import com.example.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author weixianbin
 * @date 2017/3/15
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
@Service
public class DiscussServiceImpl implements DiscussService {
    @Autowired
    DiscussDao discussDao;
    @Override
    public void save(Discuss discuss) {
        discussDao.save(discuss);
    }

    @Override
    public void remove(Discuss discuss) {
        discussDao.remove(discuss.getDiscussId());
    }

    @Override
    public void updateDiscuss(Discuss discuss) {
        discussDao.updateDiscuss(discuss);
    }

    @Override
    public void getDiscuss(Discuss discuss) {
        discussDao.getDiscussById(discuss.getDiscussId());
    }
}
