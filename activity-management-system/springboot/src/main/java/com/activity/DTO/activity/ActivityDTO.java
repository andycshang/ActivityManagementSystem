package com.activity.DTO.activity;

import com.activity.common.time.TimestampConverter;
import com.activity.entity.activity.Activity;
import com.activity.entity.event.EventInfo;
import com.activity.entity.user.User;
import lombok.Data;


@Data
public class ActivityDTO {
    private Integer id;
    private String title;

    private String location;
    private String description;
    private String startTime;
    private String endTime;

    private String creationTime;
    private String lastUpdateTime;
    private Boolean visible;

    private Integer editUserId;
    private Integer adminUserId;


    public static ActivityDTO build(Activity activity){
        ActivityDTO activityDTO = new ActivityDTO();

        activityDTO.setId(activity.getId());
        activityDTO.setTitle(activity.getTitle());
        activityDTO.setStartTime(activity.getStartTime().toString());
        activityDTO.setEndTime(activity.getEndTime().toString());
        activityDTO.setLocation(activity.getLocation());
        activityDTO.setDescription(activity.getDescription());

        activityDTO.setCreationTime(activity.getCreationTime().toString());
        activityDTO.setLastUpdateTime(activity.getLastUpdateTime().toString());
        activityDTO.setVisible(activity.getVisible());

        return activityDTO;
    }
    public static Activity parse(ActivityDTO activityDTO){
        Activity activity = new Activity();

        activity.setId(activityDTO.getId());
        activity.setTitle(activityDTO.getTitle());
        activity.setStartTime(TimestampConverter.stringToTimestamp(activityDTO.getStartTime()));
        activity.setEndTime(TimestampConverter.stringToTimestamp(activityDTO.getEndTime()));
        activity.setLocation(activityDTO.getLocation());
        activity.setDescription(activityDTO.getDescription());

        activity.setVisible(activityDTO.getVisible());

        User user = new User();
        user.setId(activityDTO.getAdminUserId());
        activity.setAdminUser(user);

        return activity;
    }

}
