package com.activity.entity.resource;

import com.activity.entity.schedule.Schedule;
import lombok.Data;

import java.sql.Timestamp;


@Data
public class DeviceReservationRecord {
    private Integer id;
    private Timestamp startTime;
    private Timestamp endTime;

    private Device device;
    private Schedule schedule;

}
