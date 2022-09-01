package com.example.controller;

import com.example.domain.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jhlz
 * @time 2022/8/10 11:45
 * @desc: WebController
 * 公共 API
 */
@RestController
@RequestMapping("/openapi")
@Api(value = "Web", tags = "OpenApi测试")
public class OpenApiController {

    private static final Logger logger = LoggerFactory.getLogger(OpenApiController.class);

    @PostMapping("register")
    @ApiOperation(value = "register", tags = "添加新用户")
    public SysUser register(SysUser user) {
        return null;
    }

}
