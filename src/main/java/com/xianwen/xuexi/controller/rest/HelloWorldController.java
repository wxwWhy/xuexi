package com.xianwen.xuexi.controller.rest;

import com.xianwen.xuexi.common.response.RestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：xw.weng
 * @date ：Created in 2021/11/12 14:05
 * @description：
 * @modified By：
 * @version: $
 */
@Api(description = "示例-HelloWord Controller")
@RestController
@RequestMapping("/uni/api/ceshi")
@Slf4j
public class HelloWorldController {

    @ApiOperation(value = "示例1")
    @RequestMapping(value = "helloWorld", method = RequestMethod.POST)
    public String helloWorld() {
        String string = "helloWorld";
        return string;
    }

    @ApiOperation(value = "示例2")
    @RequestMapping(value = "helloWorld2", method = RequestMethod.POST)
    RestResponse<Object> helloWorldb() {
        String string = "helloWorldb";
        log.info("日志打印输出测试string:{}", string);
        return RestResponse.ok(string);
    }

}
