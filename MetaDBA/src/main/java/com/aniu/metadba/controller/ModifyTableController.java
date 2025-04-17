package com.aniu.metadba.controller;

import com.alibaba.fastjson2.JSONObject;
import com.aniu.metadba.entity.Field;
import com.aniu.metadba.entity.ModifyTableLog;
import com.aniu.metadba.service.ModifyTableService;
import com.aniu.metadba.utils.ResponseJson;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ModifyTableController {

    @Resource
    private ModifyTableService modifyTableService;

//    修改字段
    @PostMapping("/api/modifyField")
    public ResponseJson modifyField(@RequestBody JSONObject jsonObject) {
        Integer inode = jsonObject.getInteger("inode");
        String targetTableName = jsonObject.getString("targetTableName");
        Field fieldBefore = jsonObject.getObject("formBefore", Field.class);
        Field field = jsonObject.getObject("form", Field.class);
        String operator = jsonObject.getString("operator");


        int i = modifyTableService.modifyField(inode, targetTableName, field, fieldBefore, operator);
        System.out.println(i);
        if(i>=0){
            return new ResponseJson(200, "success", i);
        }
        return new ResponseJson(999, "error", i);
    }


//    删除字段
    @PostMapping("/api/deleteField")
    public ResponseJson deleteField(@RequestBody JSONObject jsonObject) {
        Integer inode = jsonObject.getInteger("inode");
        String targetTableName = jsonObject.getString("targetTableName");
        Field field = jsonObject.getObject("form", Field.class);
        String operator = jsonObject.getString("operator");
        int i = modifyTableService.deleteField(inode, targetTableName, field, operator);
        System.out.println(i);
        if(i>=0){
            return new ResponseJson(200, "success", i);
        }
        return new ResponseJson(999, "error", i);
    }

//    查询所有操作记录
    @PostMapping("/api/getModifyTableLogList")
    public ResponseJson getModifyTableLogList(@RequestBody JSONObject jsonObject) {
        String operator = jsonObject.getString("operator");
        System.out.println(operator);
        List<ModifyTableLog> modifyTableLogList = modifyTableService.selectByOperator(operator);
        if (!modifyTableLogList.isEmpty()){
            return new ResponseJson(200, "success", modifyTableLogList);
        }
        return new ResponseJson(999, "error", null);
    }

//    删除数据库中的表
    @PostMapping("/api/deleteTable")
    public ResponseJson deleteTable(@RequestBody JSONObject jsonObject) {
        Integer inode = jsonObject.getInteger("inode");
        String deleteTableName = jsonObject.getString("deleteTableName");
        String operator = jsonObject.getString("operator");
        int i = modifyTableService.deleteTable(inode, deleteTableName, operator);
        if(i>=0){
            return new ResponseJson(200, "success", i);
        }
        return new ResponseJson(999, "error", null);
    }
}
