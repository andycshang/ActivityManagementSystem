package com.activity.DTO.schedule;

import com.activity.entity.participant.Participant;
import com.activity.entity.schedule.Schedule;
import com.activity.entity.schedule.ScheduleParticipant;
import lombok.Data;


@Data
public class ScheduleParticipantDTO {
    private Integer scheduleId;
    private String scheduleTitle;

    private Integer participantId;
    private String participantName;


    public static ScheduleParticipantDTO build(ScheduleParticipant scheduleParticipant){
        ScheduleParticipantDTO scheduleParticipantDTO = new ScheduleParticipantDTO();

        scheduleParticipantDTO.setScheduleId(scheduleParticipant.getSchedule().getId());
        scheduleParticipantDTO.setScheduleTitle(scheduleParticipant.getSchedule().getTitle());

        scheduleParticipantDTO.setParticipantId(scheduleParticipant.getParticipant().getId());
        scheduleParticipantDTO.setParticipantName(scheduleParticipant.getParticipant().getName());

        return scheduleParticipantDTO;
    }
    public static  ScheduleParticipant parse(ScheduleParticipantDTO scheduleParticipantDTO){
        ScheduleParticipant scheduleParticipant = new ScheduleParticipant();

        Schedule schedule = new Schedule();
        schedule.setId(scheduleParticipantDTO.getScheduleId());
        scheduleParticipant.setSchedule(schedule);

        Participant participant = new Participant();
        participant.setId(scheduleParticipantDTO.getParticipantId());
        scheduleParticipant.setParticipant(participant);

        return scheduleParticipant;
    }

}
