package com.xianwen.xuexi.manager;

import com.xianwen.xuexi.common.response.RestResponse;
import com.xianwen.xuexi.entity.User;
import com.xianwen.xuexi.entity.dto.UserDto;

import java.util.List;

public interface UserManager {

    List<User> queryByWhere(UserDto req);

}
