package com.activity.common.enums.misc;

import com.activity.common.enums.EnumBase;
import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum EffectEnum implements EnumBase {
    NOT_SPECIFIED(1, "未指定"),
    GOOD(2, "好"),
    MEDIUM(3, "中等"),
    POOR(4, "差");

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
