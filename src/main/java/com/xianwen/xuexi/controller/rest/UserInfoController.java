package com.xianwen.xuexi.controller.rest;

import com.xianwen.xuexi.common.response.RestResponse;
import com.xianwen.xuexi.entity.User;
import com.xianwen.xuexi.entity.dto.UserDto;
import com.xianwen.xuexi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：xw.weng
 * @date ：Created in 2022/1/11 01:21
 * @description：
 * @modified By：
 * @version: $
 */
@Api(description = "示例-HelloWord Controller")
@RestController
@RequestMapping("/uni/api/user")
@Slf4j
public class UserInfoController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询测试")
    @RequestMapping(value = "queryTest", method = RequestMethod.POST)
    RestResponse<Object> queryTest(@RequestBody UserDto req) {
        RestResponse<Object> res = userService.queryByWhere(req);
        return res;
    }



}
