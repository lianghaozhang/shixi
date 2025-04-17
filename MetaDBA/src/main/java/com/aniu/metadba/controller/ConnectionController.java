package com.aniu.metadba.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.fastjson2.JSONObject;
import com.aniu.metadba.entity.ConnectionInfo;
import com.aniu.metadba.entity.Field;
import com.aniu.metadba.entity.Table;
import com.aniu.metadba.service.ConnectionService;
import com.aniu.metadba.utils.ResponseJson;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class ConnectionController {

    @Resource
    private ConnectionService connectionService;

    // 测试数据库连接
    @PostMapping("/api/tesConnection")
    public Boolean testConnection(@RequestBody ConnectionInfo connectionInfo) {
        String url = connectionInfo.getUrl() + "/" + connectionInfo.getDatabaseName() + "?connectTimeout=2000&useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai";
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(connectionInfo.getDriverClassName());
        dataSource.setUsername(connectionInfo.getUsername());
        dataSource.setPassword(connectionInfo.getPassword());
        dataSource.setUrl(url);
        dataSource.setMaxWait(2000);

        try (DruidPooledConnection connection = dataSource.getConnection()) {
            Thread.sleep(1000);
            System.out.println(connection);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            dataSource.close();
        }
    }


    // 获取数据库连接
    @PostMapping("/api/getConnection")
    public ResponseJson getConnection(@RequestBody ConnectionInfo connectionInfo) {
        Integer inode = connectionService.getConnection(connectionInfo);
        if (inode >= 1) {
            return new ResponseJson(200, "数据库连接创建成功", inode);
        }
        return new ResponseJson(999, "数据库连接创建失败", inode);
    }

    // 获取数据库连接
    @PostMapping("/api/checkContrarian")
    public void checkContrarian() {
        connectionService.checkContrarian();
    }

    //    获取指定数据库中的表
    @PostMapping("/api/getTables")
    public ResponseJson getTables(@RequestBody Integer inode) {
        System.out.println("接口接收的inode:" + inode);
        List<Table> databaseTables = connectionService.getDatabaseTables(inode);
        if (!Objects.isNull(databaseTables)) {
            return new ResponseJson(200, "查询成功", databaseTables);
        }
        return new ResponseJson(999, "查询失败", null);
    }


    //    获取指定数据库指定表的字段
    @PostMapping("/api/getField")
    public ResponseJson getField(@RequestBody JSONObject jsonObject) {
        Integer inode = jsonObject.getInteger("inode");
        String tableName = jsonObject.getString("tableName");
        List<Field> tableFields = connectionService.getTableFields(inode, tableName);
        if (!Objects.isNull(tableFields)) {
            return new ResponseJson(200, "查询成功", tableFields);
        }
        return new ResponseJson(999, "查询失败", null);
    }


    //    获取所有连接记录
    @PostMapping("/api/getConnectionInfoList")
    public ResponseJson getConnectionInfoList(@RequestBody JSONObject jsonObject) {
        List<ConnectionInfo> connectionInfoList = connectionService.getConnectionInfoList(jsonObject.getString("username"));
        List<ConnectionInfo> resList = new ArrayList<>();

        if (connectionInfoList != null && !connectionInfoList.isEmpty()) {
            connectionInfoList.forEach(connectionInfo -> {
                if(connectionInfo.getAuthentication().equals("1")){
                    connectionInfo.setAuthentication("用户名&密码");
                }
                resList.add(connectionInfo);
            });
            return new ResponseJson(200, "查询成功", resList);
        }
        return new ResponseJson(999, "查询失败", null);
    }


}
