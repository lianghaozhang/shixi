package com.aniu.metadba.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseJson {

    private int code;
    private String msg;
    private Object data;
}
