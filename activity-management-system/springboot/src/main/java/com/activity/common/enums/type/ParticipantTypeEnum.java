package com.activity.common.enums.type;

import com.activity.common.enums.EnumBase;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ParticipantTypeEnum implements EnumBase {
    ORDINARY_PARTICIPANT(1, "普通参与者"),
    OTHER_PERSONNEL(2, "其他人员"),
    VOLUNTEER(3, "志愿者"),
    STAFF(4, "工作人员"),
    INVITED_GUEST(5, "特邀嘉宾"),
    ORGANIZER(6, "主办方");

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
