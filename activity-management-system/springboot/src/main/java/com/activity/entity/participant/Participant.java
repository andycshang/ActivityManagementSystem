package com.activity.entity.participant;

import com.activity.entity.activity.Activity;
import lombok.Data;


@Data
public class Participant {
    private Integer id;
    private String name;
    private Boolean valid;

    private ParticipantType type;
    private Activity activity;

}
