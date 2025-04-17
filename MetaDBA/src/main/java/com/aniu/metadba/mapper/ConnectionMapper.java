package com.aniu.metadba.mapper;

import com.aniu.metadba.entity.ConnectionInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ConnectionMapper {

    @Options(useGeneratedKeys = true, keyProperty = "connectionInfo.id", keyColumn = "id")
    @Insert("insert into connection_info (user_id, name, host, port, authentication, username, password, database_name, driver_class_name, url, connected, connection_time) " +
            "values (#{connectionInfo.userId}, #{connectionInfo.name}, #{connectionInfo.host}, #{connectionInfo.port}, #{connectionInfo.authentication}, #{connectionInfo.username}, " +
            "#{connectionInfo.password}, #{connectionInfo.databaseName}, #{connectionInfo.driverClassName}, #{connectionInfo.url}, #{connectionInfo.connected}, #{connectionInfo.connectionTime})")
    void inset2tb_connection_info(@Param("connectionInfo") ConnectionInfo connectionInfo);

    @Select("select * from connection_info where id = #{id}")
    ConnectionInfo getConnectionById(@Param("id") Integer id);

    @Select("select * from connection_info where user_id = #{userId}")
    List<ConnectionInfo> getConnectionInfoList(@Param("userId") Integer userId);
}
