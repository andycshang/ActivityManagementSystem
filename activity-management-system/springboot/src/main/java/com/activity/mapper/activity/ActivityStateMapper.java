package com.activity.mapper.activity;

import com.activity.entity.activity.ActivityState;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface ActivityStateMapper {
    // 按名称匹配
    @Select("SELECT * FROM activity_state WHERE activity_state_name = #{activityStateName}")
    ActivityState selectByName(@Param("activityStateName") String activityStateName);

}
