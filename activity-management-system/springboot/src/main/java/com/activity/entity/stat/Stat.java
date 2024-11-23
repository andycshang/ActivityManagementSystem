package com.activity.entity.stat;

import com.activity.entity.activity.Activity;
import lombok.Data;


@Data
public class Stat {
    private Integer id;
    private Integer actualMemberCount;
    private String text;

    private Effect effect;
    private Activity activity;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActualMemberCount() {
        return actualMemberCount;
    }

    public void setActualMemberCount(Integer actualMemberCount) {
        this.actualMemberCount = actualMemberCount;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Stat{" +
                "statId=" + id +
                ", actualMemberCount=" + actualMemberCount +
                ", text='" + text + '\'' +
                ", effect=" + effect +
                ", activity=" + activity +
                '}';
    }

}
