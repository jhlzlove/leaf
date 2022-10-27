package com.example.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jhlz
 * @time 2022/8/10 11:45
 * @desc: WebController
 * 公共 API
 */
@RestController
@RequestMapping("/api")
@Api(value = "OpenApiController", tags = "OpenApi")
public class OpenApiController {

    private static final Logger log = LoggerFactory.getLogger(OpenApiController.class);
}
