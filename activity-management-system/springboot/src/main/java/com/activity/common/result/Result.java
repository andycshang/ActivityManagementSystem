package com.activity.common.result;

import lombok.Data;


@Data
public class Result<T> {
    // 返回体
    private Integer code;
    private String msg;
    private T data;

}

