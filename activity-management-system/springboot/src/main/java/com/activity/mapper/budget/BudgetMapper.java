package com.activity.mapper.budget;

import com.activity.DTO.budget.BudgetDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BudgetMapper {
    @Select("SELECT * FROM  budget WHERE budget_activity_id = #{id}")
    List<BudgetDTO> findById(int id);


}
