package com.example.controller;

import com.example.common.annotation.ApiRestController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: jhlz
 * @since: 2022/10/27 22:26:48
 */
@ApiRestController
@RequestMapping("test")
@Api(value = "TestController", tags = "TestController")
public class TestController {
}
