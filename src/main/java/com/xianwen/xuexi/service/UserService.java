package com.xianwen.xuexi.service;

import com.xianwen.xuexi.common.response.RestResponse;
import com.xianwen.xuexi.entity.User;
import com.xianwen.xuexi.entity.dto.UserDto;
import org.springframework.stereotype.Service;


public interface UserService{

    RestResponse<Object> queryByWhere(UserDto req);

}
