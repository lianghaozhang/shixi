package com.aniu.metadba.entity;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModifyTableLog {
    private int id;
    private String content;
    private String operator;
    private Timestamp operatingTime;

    public ModifyTableLog(String content, String operator, Timestamp operatingTime) {
        this.content = content;
        this.operator = operator;
        this.operatingTime = operatingTime;
    }
}
