package com.aniu.metadba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Field {
    private String name;
    private String type;
    private String size;
    private String nullable;
    private String remark;
}
