package com.activity.DTO.stat;

import lombok.Data;


@Data
public class FeedbackDTO {
    private String text;
    private Integer satisfactionId;

    private Integer participantId;
    private String participantName;


}
