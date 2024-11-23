package com.activity.entity.schedule;

import com.activity.entity.activity.Activity;
import com.activity.entity.event.EventInfo;
import lombok.Data;

import java.sql.Timestamp;


@Data
public class Schedule {
    private Integer id;
    private String title;
    private Timestamp startTime;
    private Timestamp endTime;
    private String location;
    private String description;

    private Activity activity;

}
