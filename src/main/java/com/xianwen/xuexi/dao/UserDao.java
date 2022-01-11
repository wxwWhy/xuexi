package com.xianwen.xuexi.dao;

import com.xianwen.xuexi.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

   List<User> queryByWhere(User user);

}
