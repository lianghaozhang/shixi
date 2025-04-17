package com.aniu.metadba.mapper;

import com.aniu.metadba.entity.ModifyTableLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ModifyTableLogMapper {

    @Insert("insert into modify_table_log (content, operator, operating_time) values (#{modifyTableLog.content}, #{modifyTableLog.operator}, #{modifyTableLog.operatingTime})")
    int insert(@Param("modifyTableLog") ModifyTableLog modifyTableLog);

    @Select("select * from modify_table_log where operator = #{operator}")
    List<ModifyTableLog> selectByOperator(@Param("operator") String operator);
}
