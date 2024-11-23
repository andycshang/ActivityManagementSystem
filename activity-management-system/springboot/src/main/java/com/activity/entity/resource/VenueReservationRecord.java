package com.activity.entity.resource;

import com.activity.entity.schedule.Schedule;
import lombok.Data;

import java.sql.Timestamp;


@Data
public class VenueReservationRecord {
    private Integer id;
    private Timestamp startTime;
    private Timestamp endTime;

    private Venue venue;
    private Schedule schedule;
}
