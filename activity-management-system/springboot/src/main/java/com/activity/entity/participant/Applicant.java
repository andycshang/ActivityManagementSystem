package com.activity.entity.participant;

import com.activity.entity.activity.Activity;
import com.activity.entity.user.User;
import lombok.Data;


@Data
public class Applicant {
    private Participant participant;
    private Activity activity;
    private User user;

    private Boolean accepted;


    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "participant=" + participant +
                ", activity=" + activity +
                ", user=" + user +
                ", accepted=" + accepted +
                '}';
    }

}
