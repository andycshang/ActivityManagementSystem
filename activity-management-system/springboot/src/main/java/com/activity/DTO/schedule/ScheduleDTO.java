package com.activity.DTO.schedule;

import com.activity.common.time.TimestampConverter;
import com.activity.entity.schedule.Schedule;
import lombok.Data;


@Data
public class ScheduleDTO {
    private Integer id;
    private String title;
    private String startTime;
    private String endTime;
    private String location;
    private String description;


    public static ScheduleDTO build(Schedule schedule){
        ScheduleDTO scheduleDTO = new ScheduleDTO();

        scheduleDTO.setId(schedule.getId());
        scheduleDTO.setTitle(schedule.getTitle());
        scheduleDTO.setStartTime(schedule.getStartTime().toString());
        scheduleDTO.setEndTime(schedule.getEndTime().toString());
        scheduleDTO.setLocation(schedule.getLocation());
        scheduleDTO.setDescription(schedule.getDescription());

        return scheduleDTO;
    }
    public static Schedule parse(ScheduleDTO scheduleDTO){
        Schedule schedule = new Schedule();

        schedule.setId(scheduleDTO.getId());
        schedule.setTitle(scheduleDTO.getTitle());
        schedule.setStartTime(TimestampConverter.stringToTimestamp(scheduleDTO.getStartTime()));
        schedule.setEndTime(TimestampConverter.stringToTimestamp(scheduleDTO.getEndTime()));
        schedule.setLocation(scheduleDTO.getLocation());
        schedule.setDescription(scheduleDTO.getDescription());

        return schedule;
    }

}
