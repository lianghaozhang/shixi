package com.aniu.metadba.controller;

import com.alibaba.fastjson2.JSONObject;
import com.aniu.metadba.entity.TableMapping;
import com.aniu.metadba.mapper.UserMapper;
import com.aniu.metadba.service.TableMappingService;
import com.aniu.metadba.utils.ResponseJson;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TableMappingController {

    @Resource
    private TableMappingService tableMappingService;
    
    @Resource
    private UserMapper userMapper;

    @PostMapping("/api/insertMappingData")
    public ResponseJson insertMappingData(@RequestBody JSONObject jsonObject) {
        String tableName1 = jsonObject.getString("tableName1");
        String fieldName1 = jsonObject.getString("fieldName1");
        String tableName2 = jsonObject.getString("tableName2");
        String fieldName2 = jsonObject.getString("fieldName2");
        String username = jsonObject.getString("username");
        int i = tableMappingService.insertMappingData(new TableMapping(tableName1, fieldName1, tableName2, fieldName2, username, false));
        if (i > 0) {
            return new ResponseJson(200, "关联关系添加成功", i);
        }
        return new ResponseJson(999, "关联关系添加失败", null);
    }

    @PostMapping("/api/getTableMapping")
    public ResponseJson selectTableMappingByOperator(@RequestBody JSONObject jsonObject) {
        String operator = jsonObject.getString("operator");
        List<TableMapping> tableMappingList = tableMappingService.selectByOperator(operator);
        if (!tableMappingList.isEmpty()) {
            return new ResponseJson(200, "success", tableMappingList);
        }
        return new ResponseJson(999, "error", null);
    }
}
