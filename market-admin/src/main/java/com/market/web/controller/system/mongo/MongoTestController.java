package com.market.web.controller.system.mongo;

import com.market.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mongo")
public class MongoTestController {


    private final MongoTestService mongoTestService;

    @Autowired
    public MongoTestController(MongoTestService mongoTestService) {
        this.mongoTestService = mongoTestService;
    }

    @PostMapping("/insert")
    public AjaxResult insert() {
        mongoTestService.insert();
        return AjaxResult.success("添加成功！");
    }
}
