package com.activity.entity.budget;

import com.activity.entity.participant.Participant;
import lombok.Data;


@Data
public class BudgetFlowRecord {
    private Integer id;
    private String title;
    private Double value;
    private String description;
    private Boolean accepted;

    private Participant participant;
    private Budget budget;


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

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "BudgetFlowRecord{" +
                "flowRecordId=" + id +
                ", flowRecordTitle='" + title + '\'' +
                ", value=" + value +
                ", description='" + description + '\'' +
                ", accepted=" + accepted +
                ", participant=" + participant +
                ", budget=" + budget +
                '}';
    }

}
