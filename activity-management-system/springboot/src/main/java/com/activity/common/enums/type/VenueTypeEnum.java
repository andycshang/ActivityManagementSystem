package com.activity.common.enums.type;

import com.activity.common.enums.EnumBase;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum VenueTypeEnum implements EnumBase {
    OTHER(1, "其他类型"),
    AUDITORIUM(2, "礼堂"),
    MEETING_ROOM(3, "会议室"),
    SPORTS_FIELD(4, "体育场地"),
    CLASSROOM(5, "教室"),
    LABORATORY(6, "实验室");

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
