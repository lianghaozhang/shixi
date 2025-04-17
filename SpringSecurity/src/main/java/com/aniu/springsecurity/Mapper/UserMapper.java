package com.aniu.springsecurity.Mapper;


import com.aniu.springsecurity.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from sys_user where user_name = #{username}")
    User getUsers(@Param("username") String username);
}
