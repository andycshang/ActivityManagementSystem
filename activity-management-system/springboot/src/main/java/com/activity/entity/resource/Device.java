package com.activity.entity.resource;

import lombok.Data;


@Data
public class Device {
    private Integer id;
    private String name;
    private String department;
    private String address;

    private String managerName;
    private String managerContact;

    private DeviceType type;

}
