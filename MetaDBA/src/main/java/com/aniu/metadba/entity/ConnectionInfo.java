package com.aniu.metadba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionInfo {
    private int id;
    private int userId;
    private String name;
    private String host;
    private String port;
    private String authentication;
    private String username;
    private String password;
    private String databaseName;
    private String driverClassName;
    private String url;
    private Boolean connected;
    private Timestamp connectionTime;

    public ConnectionInfo(int userId, String name, String host, String port, String authentication, String username, String password, String databaseName, String driverClassName, String url, Boolean connected, Timestamp connectionTime) {
        this.userId = userId;
        this.name = name;
        this.host = host;
        this.port = port;
        this.authentication = authentication;
        this.username = username;
        this.password = password;
        this.databaseName = databaseName;
        this.driverClassName = driverClassName;
        this.url = url;
        this.connected = connected;
        this.connectionTime = connectionTime;
    }
}
