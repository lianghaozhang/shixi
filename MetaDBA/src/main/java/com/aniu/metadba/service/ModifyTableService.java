package com.aniu.metadba.service;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.aniu.metadba.entity.Field;
import com.aniu.metadba.entity.ModifyTableLog;
import com.aniu.metadba.mapper.ConnectionMapper;
import com.aniu.metadba.mapper.ModifyTableLogMapper;
import com.aniu.metadba.utils.ConnectionContainer;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ModifyTableService {

    @Resource
    private ConnectionMapper connectionMapper;

    @Resource
    private ConnectionContainer connectionContainer;

    @Resource
    private ModifyTableLogMapper modifyTableLogMapper;

    //    修改字段信息
    @Transactional
    public int modifyField(Integer inode, String tableName, Field field, Field fieldBefore, String operator) {
//        通过inode拿到用户id再获取连接对象
        int userId = connectionMapper.getConnectionById(inode).getUserId();
        DruidPooledConnection connection = connectionContainer.getConnection(userId);
        /*
         * alter table test_table change name name1 varchar(255) not null comment '姓名';
         * */
        String sql;
        if (field.getNullable().equals("YES")) {
            sql = "alter table " + tableName + " change " + fieldBefore.getName() + " " + field.getName() + " " + field.getType() + "(" + field.getSize() + ")" + " comment '" + field.getRemark() + "'";
        } else {
            sql = "alter table " + tableName + " change " + fieldBefore.getName() + " " + field.getName() + " " + field.getType() + "(" + field.getSize() + ")" + " not null comment '" + field.getRemark() + "'";
        }
        System.out.println(sql);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            String content = "用户【" + operator + "】执行了sql语句：" + sql;
            modifyTableLogMapper.insert(new ModifyTableLog(content, operator, new Timestamp(System.currentTimeMillis())));
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     * 删除字段
     * alter table test_table drop column aaa;
     * */
    @Transactional
    public int deleteField(int inode, String tableName, Field field, String operator) {
        int userId = connectionMapper.getConnectionById(inode).getUserId();
        DruidPooledConnection connection = connectionContainer.getConnection(userId);
        String sql = "alter table " + tableName + " drop column " + field.getName();
        System.out.println(sql);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            String content = "用户【" + operator + "】执行了sql语句：" + sql;
            modifyTableLogMapper.insert(new ModifyTableLog(content, operator, new Timestamp(System.currentTimeMillis())));
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    查询所有操作记录
    public List<ModifyTableLog> selectByOperator(String operator) {
        return modifyTableLogMapper.selectByOperator(operator);
    }

//    删除数据表 drop table test_table;
    public int deleteTable(int inode, String tableName, String operator) {
        int userId = connectionMapper.getConnectionById(inode).getUserId();
        DruidPooledConnection connection = connectionContainer.getConnection(userId);
        String sql = "drop table " + tableName;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            String content = "用户【" + operator + "】删除了【" + connection.getCatalog() + "】数据库中的【" + tableName + "】表";
            modifyTableLogMapper.insert(new ModifyTableLog(content, operator, new Timestamp(System.currentTimeMillis())));
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
