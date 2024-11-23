package com.activity.DTO.resource;

import com.activity.entity.resource.Venue;
import lombok.Data;


@Data
public class VenueDTO {
    private Integer id;
    private String name;
    private String department;
    private String address;
    private Integer capacity;

    private String managerName;
    private String managerContact;

    private String typeName;


    public static VenueDTO build(Venue venue){
        VenueDTO venueDTO = new VenueDTO();

        venueDTO.setId(venue.getId());
        venueDTO.setName(venue.getName());
        venueDTO.setDepartment(venue.getDepartment());
        venueDTO.setAddress(venue.getAddress());
        venueDTO.setCapacity(venue.getCapacity());

        venueDTO.setManagerName(venue.getManagerName());
        venueDTO.setManagerContact(venue.getManagerContact());

        venueDTO.setTypeName(venue.getType().getName());

        return venueDTO;
    }

}
