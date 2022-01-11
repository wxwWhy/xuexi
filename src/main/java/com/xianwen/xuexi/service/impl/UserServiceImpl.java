package com.xianwen.xuexi.service.impl;

import com.xianwen.xuexi.common.response.RestResponse;
import com.xianwen.xuexi.entity.User;
import com.xianwen.xuexi.entity.dto.UserDto;
import com.xianwen.xuexi.manager.UserManager;
import com.xianwen.xuexi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserManager userManager;

    @Override
    public RestResponse<Object> queryByWhere(UserDto req) {
        List<User> users = userManager.queryByWhere(req);
        return RestResponse.ok(users);
    }
}
