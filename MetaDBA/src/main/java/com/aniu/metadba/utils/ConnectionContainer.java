package com.aniu.metadba.utils;

import com.alibaba.druid.pool.DruidPooledConnection;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ConnectionContainer {

    private final Map<Integer, DruidPooledConnection> userConnectionMap = new ConcurrentHashMap<>();

    public void addConnection(Integer userId, DruidPooledConnection connection) {
        userConnectionMap.put(userId, connection);
    }

    public void removeAndCloseConnection(Integer userId) {
        DruidPooledConnection connection = userConnectionMap.remove(userId);
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public DruidPooledConnection getConnection(Integer userId) {
        return userConnectionMap.get(userId);
    }

    public void listAllConnections() {
        if (userConnectionMap.isEmpty()) {
            System.out.println("当前没有活跃的数据库连接。");
            return;
        }

        userConnectionMap.forEach((userId, connection) -> {
            try {
                System.out.println(userId + ": " + connection + "， 是否关闭：" + connection.isClosed());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
