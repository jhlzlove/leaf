package com.example.controller;

import com.example.common.annotation.ApiRestController;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jhlz
 * @time 2022/8/10 11:45
 * @desc: WebController
 * 公共 API
 */
@ApiRestController
@RequestMapping("/openapi")
@Api(value = "Web", tags = "OpenApi测试")
public class OpenApiController {

    private static final Logger logger = LoggerFactory.getLogger(OpenApiController.class);
}
