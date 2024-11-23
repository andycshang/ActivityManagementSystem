package com.activity.common.result;


public class ResultUtils {
    // 1.成功
    // 1) 存在返回数据
    public static Result success(Object object) {
        Result successResult = new Result();
        successResult.setCode(ResultEnum.SUCCESS.getCode());
        successResult.setMsg(ResultEnum.SUCCESS.getMsg());
        successResult.setData(object);
        return successResult;
    }
    // 2) 无返回数据
    public static Result success() {
        return success(null);
    }

    // 2.失败
    // 1) 返回预设code和msg
    public static Result error(ResultEnum resultEnum) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;
    }
    // 2) 返回预设code和自定义msg
    public static Result error(ResultEnum resultEnum, String msg) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(msg);
        return result;
    }
    // 3) 返回自定义code和msg
    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}

