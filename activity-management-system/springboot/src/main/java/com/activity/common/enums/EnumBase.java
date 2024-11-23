package com.activity.common.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

public interface EnumBase extends IEnum<Integer> {
    Integer value = null;
    String desc = null;

    public Integer getValue();
    public String getDesc();
}
