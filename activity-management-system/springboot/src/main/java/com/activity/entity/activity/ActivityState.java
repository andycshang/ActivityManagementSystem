package com.activity.entity.activity;

import lombok.Data;


@Data
public class ActivityState {
    private Integer id;
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ActivityState{" +
                "stateId=" + id +
                ", stateName='" + name + '\'' +
                '}';
    }

}
