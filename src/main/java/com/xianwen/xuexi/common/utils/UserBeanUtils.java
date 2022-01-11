package com.xianwen.xuexi.common.utils;

import com.xianwen.xuexi.entity.User;
import com.xianwen.xuexi.entity.dto.UserDto;

public class UserBeanUtils {

    public static User dto2User(UserDto userDto) {
        User user = new User();
        if (userDto != null) {
            user.setId(userDto.getId());
            user.setUserId(userDto.getUserId());
            user.setName(userDto.getName());
        }
        return user;
    }

}
