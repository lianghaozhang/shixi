package com.aniu.metadba.mapper;

import com.aniu.metadba.entity.TableMapping;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TableMappingMapper {

    @Insert("insert into table_mapping (table_name1, field_name1, table_name2, field_name2, operator, is_delete) " +
            "values (#{tableMapping.tableName1}, #{tableMapping.fieldName1}, #{tableMapping.tableName2}, #{tableMapping.fieldName2}, #{tableMapping.operator}, #{tableMapping.isDelete})")
    int insert(@Param("tableMapping") TableMapping tableMapping);

    @Select("select * from table_mapping where operator = #{operator} and is_delete = false")
    List<TableMapping> selectByOperator(@Param("operator") String operator);
}
