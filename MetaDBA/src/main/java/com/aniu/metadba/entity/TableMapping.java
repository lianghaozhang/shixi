package com.aniu.metadba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableMapping {

    private int id;
    private String tableName1;
    private String fieldName1;
    private String tableName2;
    private String fieldName2;
    private String operator;
    private Boolean isDelete;

    public TableMapping(String tableName1, String fieldName1, String tableName2, String fieldName2, String operator, Boolean isDelete) {
        this.tableName1 = tableName1;
        this.fieldName1 = fieldName1;
        this.tableName2 = tableName2;
        this.fieldName2 = fieldName2;
        this.operator = operator;
        this.isDelete = isDelete;
    }
}
