package com.aniu.metadba.service;

import com.aniu.metadba.entity.MappingLog;
import com.aniu.metadba.entity.TableMapping;
import com.aniu.metadba.mapper.MappingLogMapper;
import com.aniu.metadba.mapper.TableMappingMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TableMappingService {

    @Resource
    private TableMappingMapper tableMappingMapper;

    @Resource
    private MappingLogMapper mappingLogMapper;

    @Transactional
    public int insertMappingData(TableMapping tableMapping) {
        int i = tableMappingMapper.insert(tableMapping);
        String content = "用户【" + tableMapping.getOperator() + "】将【" + tableMapping.getTableName1() + "】表的【" + tableMapping.getFieldName1() + "】字段" +
                "与【" + tableMapping.getTableName2() + "】表的【" + tableMapping.getFieldName2() + "】字段进行关联";
        int i1 = 0;
        if (i > 0) {
             i1 = mappingLogMapper.insert(new MappingLog(content, tableMapping.getOperator(), new Timestamp(System.currentTimeMillis())));
        }
        if(i1 > 0){
            return i1;
        }
        return -1;
    }

    public List<TableMapping> selectByOperator(String operator) {
        return tableMappingMapper.selectByOperator(operator);
    }
}
