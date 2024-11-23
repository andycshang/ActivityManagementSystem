package com.activity.entity.activity;

import com.activity.entity.event.EventInfo;
import com.activity.entity.user.User;
import lombok.Data;

import java.sql.Timestamp;


@Data
public class Activity {
    // 1.内部字段
    private Integer id;
    private String title;
    private Timestamp startTime;
    private Timestamp endTime;
    private String location;
    private String description;

    private Timestamp creationTime;
    private Timestamp lastUpdateTime;
    private Boolean visible;
    private String UUID;

    // 2.外键
    private ActivityType type;
    private ActivityState state;
    private User adminUser;

}
