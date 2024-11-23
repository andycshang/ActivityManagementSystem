package com.activity.entity.resource;

import lombok.Data;


@Data
public class Venue {
    private Integer id;
    private String name;
    private String department;
    private String address;
    private Integer capacity;

    private String managerName;
    private String managerContact;

    private VenueType type;

}
