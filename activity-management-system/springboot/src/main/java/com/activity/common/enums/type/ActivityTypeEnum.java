package com.activity.common.enums.type;

import com.activity.common.enums.EnumBase;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ActivityTypeEnum implements EnumBase {
    UNKNOWN(1, "未分类"),
    OTHER(2, "其他类别"),
    VOLUNTEERING(3, "志愿活动"),
    CAUCUS(4, "党团活动"),
    LITERARY(5, "文艺活动"),
    SPORTS(6, "体育活动"),
    LECTURE(7, "知识讲座"),
    CONTEST(8, "竞赛");

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
