package com.activity.service.Budget;

import com.activity.DTO.budget.BudgetDTO;
import com.activity.mapper.budget.BudgetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {
    @Autowired
    private BudgetMapper budgetMapper;
    public List<BudgetDTO> findById(int id) {
        return budgetMapper.findById(id);
    }
}
