package com.activity.common.enums.misc;

import com.activity.common.enums.EnumBase;
import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum SatisfactionEnum implements EnumBase {
    NOT_SPECIFIED(1, "未指定"),
    VERY_SATISFIED(2, "非常满意"),
    SATISFIED(3, "满意"),
    NEUTRAL(4, "一般"),
    DISSATISFIED(4, "不满意");

    private final Integer value;
    private final String desc;

    @Override
    public Integer getValue() {
        return this.value;
    }
    @Override
    public String getDesc() {
        return this.desc;
    }
}
