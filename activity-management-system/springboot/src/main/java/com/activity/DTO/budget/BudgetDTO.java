package com.activity.DTO.budget;

import lombok.Data;


@Data
public class BudgetDTO {
    private Integer id;
    private String title;
    private Double value;
    private String description;

}
