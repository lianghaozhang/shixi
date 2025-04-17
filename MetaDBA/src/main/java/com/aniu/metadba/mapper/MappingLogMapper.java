package com.aniu.metadba.mapper;

import com.aniu.metadba.entity.MappingLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MappingLogMapper {

    @Insert("insert into mapping_log (content, operator) values (#{mappingLog.content}, #{mappingLog.operator})")
    int insert(@Param("mappingLog") MappingLog mappingLog);

    @Select("select * from mapping_log where operator = #{operator}")
    List<MappingLog> selectByOperator(@Param("operator") String operator);
}
