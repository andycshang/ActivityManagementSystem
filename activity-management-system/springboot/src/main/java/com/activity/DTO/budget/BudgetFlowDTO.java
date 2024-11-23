package com.activity.DTO.budget;

import com.activity.entity.budget.BudgetFlowRecord;
import lombok.Data;


@Data
public class BudgetFlowDTO {
    private Integer id;
    private String title;
    private Double value;
    private String description;
    private Boolean accepted;

    private Integer participantId;
    private String participantName;

    private Integer budgetId;
    private String budgetName;


    public static BudgetFlowDTO build(BudgetFlowRecord budgetFlowRecord){
        BudgetFlowDTO budgetFlowDTO = new BudgetFlowDTO();

        budgetFlowDTO.setId(budgetFlowRecord.getId());
        budgetFlowDTO.setTitle(budgetFlowRecord.getTitle());


        return budgetFlowDTO;
    }
    public static BudgetFlowRecord parse(BudgetFlowDTO budgetFlowDTO){
        BudgetFlowRecord budgetFlowRecord = new BudgetFlowRecord();


        return budgetFlowRecord;
    }

}
