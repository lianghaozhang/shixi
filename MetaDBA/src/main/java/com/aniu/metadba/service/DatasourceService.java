package com.aniu.metadba.service;

import com.aniu.metadba.entity.DataSource;
import com.aniu.metadba.mapper.DataSourceMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatasourceService {

    @Resource
    private DataSourceMapper dataSourceMapper;

    public List<DataSource> selectAll() {
        return dataSourceMapper.selectAll();
    }
}
