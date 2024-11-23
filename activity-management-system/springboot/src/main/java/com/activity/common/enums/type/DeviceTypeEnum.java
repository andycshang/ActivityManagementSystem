package com.activity.common.enums.type;

import com.activity.common.enums.EnumBase;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum DeviceTypeEnum implements EnumBase {
    OTHER(1, "其他类型"),
    ELECTRONIC_DEVICE(2, "电子设备"),
    MECHANICAL_DEVICE(3, "机械设备"),
    LABORATORY_EQUIPMENT(4, "实验器材"),
    SPORTS_EQUIPMENT(5, "体育器材"),
    TRANSPORTATION(6, "运输工具");

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
