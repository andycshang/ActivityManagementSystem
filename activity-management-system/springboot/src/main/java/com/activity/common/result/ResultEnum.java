package com.activity.common.result;


// 枚举类
public enum ResultEnum {
    // 交互码
    // 1.发生错误
    // 1) 交互数据合法性错误：View -> Controller
    MISSING_REQUIRED_FIELD(1, "Missing Required Field"), // 缺少必填字段
    INVALID_INPUT(2, "Invalid Input"), // 无效的输入
    INVALID_FORMAT(3, "Invalid Format"), // 数据格式错误
    // 2) 数据验证错误：Service
    NOT_EXIST_DATA(101, "Not Exist Data"), // 数据不存在
    ALREADY_EXIST_DATA(102, "Already Exist Data"), // 已存在的数据
    MISMATCHED_DATA(103, "Mismatched Data"), // 不匹配的数据
    // 3) 数据操作错误：DAO
    SERVER_INTERNAL_ERROR(201, "Server Internal Error"), // 服务器内部错误
    SYSTEM_BUSY(202, "System Busy"), // 系统繁忙
    // 4) 访问权限错误：Controller
    UNAUTHORIZED_ACCESS(301, "Unauthorized Access"), // 未经授权的访问
    FORBIDDEN_ACCESS(302, "Forbidden Access"), // 禁止访问
    // else
    UNKNOWN_ERROR(-1, "Unknown Error"),

    // 2.操作成功
    // Success
    SUCCESS(0, "Success"),
    ;
    private final Integer code;
    private final String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
