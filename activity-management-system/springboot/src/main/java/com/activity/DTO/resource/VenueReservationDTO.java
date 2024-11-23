package com.activity.DTO.resource;

import com.activity.entity.resource.VenueReservationRecord;
import lombok.Data;


@Data
public class VenueReservationDTO {
    private Integer id;
    private String startTime;
    private String endTime;

    private Integer venueId;
    private String venueName;

    private Integer scheduleId;
    private String scheduleTitle;


    public static VenueReservationDTO build(VenueReservationRecord venueReservationRecord){
        VenueReservationDTO venueReservationDTO = new VenueReservationDTO();

        venueReservationDTO.setId(venueReservationRecord.getId());
        venueReservationDTO.setStartTime(venueReservationRecord.getStartTime().toString());
        venueReservationDTO.setEndTime(venueReservationRecord.getEndTime().toString());

        venueReservationDTO.setVenueId(venueReservationRecord.getVenue().getId());
        venueReservationDTO.setVenueName(venueReservationRecord.getVenue().getName());

        venueReservationDTO.setScheduleId(venueReservationRecord.getSchedule().getId());
        venueReservationDTO.setScheduleTitle(venueReservationRecord.getSchedule().getTitle());

        return venueReservationDTO;
    }
    public static VenueReservationRecord parse(VenueReservationDTO venueReservationDTO){
        VenueReservationRecord venueReservationRecord = new VenueReservationRecord();



        return venueReservationRecord;
    }

}
