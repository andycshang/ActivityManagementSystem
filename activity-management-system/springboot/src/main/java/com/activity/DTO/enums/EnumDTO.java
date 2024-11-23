package com.activity.DTO.enums;

import com.activity.common.enums.EnumBase;
import lombok.Data;


@Data
public class EnumDTO {
    private Integer id;
    private String name;

    public static EnumDTO build(EnumBase enumBase){
        EnumDTO enumDTO = new EnumDTO();
        enumDTO.setId(enumBase.getValue());
        enumDTO.setName(enumBase.getDesc());
        return enumDTO;
    }

}
