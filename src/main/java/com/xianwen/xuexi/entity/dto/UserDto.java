package com.xianwen.xuexi.entity.dto;

import lombok.Data;

@Data
public class UserDto {

    private Integer id;
    private String userId;
    private String name;

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
