package com.aniu.metadba.service;

import com.aniu.metadba.entity.MappingLog;
import com.aniu.metadba.mapper.MappingLogMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MappingLogService {

    @Resource
    private MappingLogMapper mappingLogMapper;

//    插入关联关系记录
    public int insert(MappingLog mappingLog) {
        return mappingLogMapper.insert(mappingLog);
    }

//    获取日志
    public List<MappingLog> selectByOperator(String operator) {
        return mappingLogMapper.selectByOperator(operator);
    }
}
