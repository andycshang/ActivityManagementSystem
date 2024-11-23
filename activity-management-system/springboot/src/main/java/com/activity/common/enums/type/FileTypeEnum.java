package com.activity.common.enums.type;

import com.activity.common.enums.EnumBase;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum FileTypeEnum implements EnumBase {
    OTHER(1, "其他类型"),
    DISPLAY_IMAGE(2, "展示图"),
    IMAGE(3, "图片"),
    DOCUMENT(4, "文档"),
    VIDEO(5, "视频"),
    AUDIO(6, "音频");

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
