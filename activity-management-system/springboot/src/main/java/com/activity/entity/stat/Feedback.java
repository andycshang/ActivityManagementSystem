package com.activity.entity.stat;

import com.activity.entity.activity.Activity;
import com.activity.entity.user.User;
import lombok.Data;


@Data
public class Feedback {
    private Integer id;
    private String text;

    private Satisfaction satisfaction;
    private User user;
    private Activity activity;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Satisfaction getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(Satisfaction satisfaction) {
        this.satisfaction = satisfaction;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackId=" + id +
                ", text='" + text + '\'' +
                ", satisfaction=" + satisfaction +
                ", user=" + user +
                ", activity=" + activity +
                '}';
    }

}
