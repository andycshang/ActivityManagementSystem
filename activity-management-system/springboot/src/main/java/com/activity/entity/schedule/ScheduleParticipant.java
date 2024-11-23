package com.activity.entity.schedule;

import com.activity.entity.participant.Participant;
import lombok.Data;


@Data
public class ScheduleParticipant {
    private Schedule schedule;
    private Participant participant;


    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    @Override
    public String toString() {
        return "ScheduleParticipant{" +
                "schedule=" + schedule +
                ", participant=" + participant +
                '}';
    }

}
