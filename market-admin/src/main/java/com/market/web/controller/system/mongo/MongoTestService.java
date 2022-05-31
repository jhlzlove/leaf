package com.market.web.controller.system.mongo;

import com.market.common.core.domain.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MongoTestService {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public MongoTestService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Transactional
    public void insert() {
        SysUser user = new SysUser();
        user.setNickName("风中捉刀");
        user.setPassword("fzzd");
        user.setSex("男");
        mongoTemplate.insert(user);
    }
}
