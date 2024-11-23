package com.activity.entity.budget;

import com.activity.entity.activity.Activity;
import lombok.Data;


@Data
public class Budget {
    private Integer id;
    private String title;
    private Double value;
    private String description;

    private Activity activity;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "budgetId=" + id +
                ", budgetTitle='" + title + '\'' +
                ", value=" + value +
                ", description='" + description + '\'' +
                ", activity=" + activity +
                '}';
    }

}
