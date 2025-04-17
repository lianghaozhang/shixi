package com.aniu.metadba.controller;

import com.alibaba.fastjson2.JSONObject;
import com.aniu.metadba.entity.MappingLog;
import com.aniu.metadba.service.MappingLogService;
import com.aniu.metadba.utils.ResponseJson;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MappingLogController {

    @Resource
    private MappingLogService mappingLogService;

    @PostMapping("/api/getMappingLogList")
    public ResponseJson selectByOperator(@RequestBody JSONObject jsonObject) {
        String operator = jsonObject.getString("operator");
        List<MappingLog> mappingLogList = mappingLogService.selectByOperator(operator);
        if (!mappingLogList.isEmpty()) {
            return new ResponseJson(200, "success", mappingLogList);
        }
        return new ResponseJson(999, "error", null);
    }
}