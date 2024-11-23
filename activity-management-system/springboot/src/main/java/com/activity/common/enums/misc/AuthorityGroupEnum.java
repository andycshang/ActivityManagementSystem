package com.activity.common.enums.misc;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum AuthorityGroupEnum implements IEnum<Integer> {
    VISITOR(1, "访客", 0),
    NORMAL_USER(2, "普通用户", 1),
    MEMBER(3, "会员", 2),
    ADMIN(4, "管理员", 7);

    private final int value;
    private final String name;
    private final int permissionLevel;

    @Override
    public Integer getValue() {
        return this.value;
    }

}
