package com.xianwen.xuexi.manager.impl;

import com.xianwen.xuexi.common.utils.UserBeanUtils;
import com.xianwen.xuexi.dao.UserDao;
import com.xianwen.xuexi.entity.User;
import com.xianwen.xuexi.entity.dto.UserDto;
import com.xianwen.xuexi.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> queryByWhere(UserDto req) {
        User query = UserBeanUtils.dto2User(req);
        List<User> users = userDao.queryByWhere(query);
        return users;
    }
}
