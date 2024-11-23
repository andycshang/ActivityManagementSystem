package com.activity.DTO.resource;

import com.activity.entity.resource.Device;
import lombok.Data;


@Data
public class DeviceDTO {
    private Integer id;
    private String name;
    private String department;
    private String address;
    private Integer capacity;

    private String managerName;
    private String managerContact;

    private String typeName;


    public static DeviceDTO build(Device device){
        DeviceDTO deviceDTO = new DeviceDTO();

        deviceDTO.setId(device.getId());
        deviceDTO.setName(device.getName());
        deviceDTO.setDepartment(device.getDepartment());
        deviceDTO.setAddress(device.getAddress());

        deviceDTO.setManagerName(device.getManagerName());
        deviceDTO.setManagerContact(device.getManagerContact());

        deviceDTO.setTypeName(device.getType().getName());

        return deviceDTO;
    }
}
