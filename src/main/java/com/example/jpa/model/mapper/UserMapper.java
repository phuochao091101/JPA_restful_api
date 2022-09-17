package com.example.jpa.model.mapper;

import com.example.jpa.entity.User;
import com.example.jpa.model.dto.UserDto;

public class UserMapper {
    public static UserDto toUserDto(User user){
        UserDto tmp =new UserDto();
        tmp.setId(user.getId());
        tmp.setName(user.getFullname());
        tmp.setAvatar(user.getAvatar());
        tmp.setPhone(user.getPhone());
        tmp.setEmail(user.getEmail());
        return tmp;
    }
}
