package com.activity.controller;

import com.activity.DTO.budget.BudgetDTO;
import com.activity.common.result.Result;
import com.activity.common.result.ResultUtils;
import com.activity.service.Budget.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller("/A")

public class ActivityBudgetController {

    @Autowired
    private BudgetService budgetService;

    @GetMapping("/")
    public Result findById(@RequestParam("id" ) int id){
        List<BudgetDTO> budgetDTOList = budgetService.findById(id);
        return ResultUtils.success(budgetDTOLis t);
    }
}
