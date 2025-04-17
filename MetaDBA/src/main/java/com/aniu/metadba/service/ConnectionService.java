package com.aniu.metadba.service;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.aniu.metadba.entity.ConnectionInfo;
import com.aniu.metadba.entity.Field;
import com.aniu.metadba.entity.Table;
import com.aniu.metadba.mapper.ConnectionMapper;
import com.aniu.metadba.mapper.UserMapper;
import com.aniu.metadba.utils.ConnectionContainer;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConnectionService {

    @Resource
    private ConnectionMapper connectionMapper;

    @Resource
    private ConnectionContainer connectionContainer;

    @Resource
    private UserMapper userMapper;

    //    获取数据库连接并存入数据库
    public Integer getConnection(ConnectionInfo connectionInfo) {
        String url = connectionInfo.getUrl() + "/" +
                connectionInfo.getDatabaseName() + "?connectTimeout=2000&useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai";
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(connectionInfo.getDriverClassName());
        dataSource.setUsername(connectionInfo.getUsername());
        dataSource.setPassword(connectionInfo.getPassword());
        dataSource.setUrl(url);

        try {
            DruidPooledConnection connection = dataSource.getConnection();
            connectionContainer.addConnection(connectionInfo.getUserId(), connection);

            ConnectionInfo conne = new ConnectionInfo(connectionInfo.getUserId(), connectionInfo.getName(), connectionInfo.getHost(), connectionInfo.getPort(), connectionInfo.getAuthentication(),
                    connectionInfo.getUsername(), connectionInfo.getPassword(), connectionInfo.getDatabaseName(), connectionInfo.getDriverClassName(),
                    url, true, new Timestamp(System.currentTimeMillis())
            );
            connectionMapper.inset2tb_connection_info(conne);
            return conne.getId();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void checkContrarian() {
        connectionContainer.listAllConnections();
    }


    //    获取数据库中的所有表，前端传来inode，inode就是数据库中记录连接信息connection_info表的id
    public List<Table> getDatabaseTables(int inode) {
        List<Table> tablesInfo = new ArrayList<>();
        ConnectionInfo connectionInfo = connectionMapper.getConnectionById(inode);
        System.out.println(connectionInfo.toString());
        int userId = connectionInfo.getUserId();
        System.out.println(userId);
        DruidPooledConnection connection = connectionContainer.getConnection(userId);
        System.out.println(connection);
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet tables = metaData.getTables(null, connectionInfo.getDatabaseName(), "%", new String[]{"TABLE"});
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                String remarks = tables.getString("REMARKS");
                if (remarks.isEmpty()) {
                    remarks = "无注释";
                }
                tablesInfo.add(new Table(tableName, remarks));
            }
            tables.close();
            return tablesInfo;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    获取指定指定数据表中的所有字段属性
    public List<Field> getTableFields(int inode, String tableName) {
        List<Field> fields = new ArrayList<>();
        ConnectionInfo connectionInfo = connectionMapper.getConnectionById(inode);
        int userId = connectionInfo.getUserId();
        DruidPooledConnection connection = connectionContainer.getConnection(userId);
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet columns = metaData.getColumns(null, connectionInfo.getDatabaseName(), tableName, null);
            while (columns.next()) {
                String columnName = columns.getString("COLUMN_NAME");
                String columnType = columns.getString("TYPE_NAME");
                String columnSize = columns.getString("COLUMN_SIZE");
                String nullable = columns.getInt("NULLABLE") == DatabaseMetaData.columnNullable ? "YES" : "NO";
                String remarks = columns.getString("REMARKS");
                if (remarks.isEmpty()) {
                    remarks = "无注释";
                }
                fields.add(new Field(columnName, columnType, columnSize, nullable, remarks));
            }
            columns.close();
            return fields;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


//    获取所有的连接记录
    public List<ConnectionInfo> getConnectionInfoList(String username) {
        Integer userId = userMapper.getUserIdByUsername(username);
        return connectionMapper.getConnectionInfoList(userId);
    }


}
