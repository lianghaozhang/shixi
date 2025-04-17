package com.aniu.metadba.mapper;

import com.aniu.metadba.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user_info where username = #{username} and password = #{password}")
    User checkLogin(@Param("username") String username, @Param("password") String password);

    @Select("select id from user_info where username = #{username}")
    Integer getUserIdByUsername(@Param("username") String username);
}
