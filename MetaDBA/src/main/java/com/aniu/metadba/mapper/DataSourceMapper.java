package com.aniu.metadba.mapper;

import com.aniu.metadba.entity.DataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DataSourceMapper {

    @Select("select * from data_source")
    List<DataSource> selectAll();
}
