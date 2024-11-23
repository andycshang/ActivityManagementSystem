package com.activity.mapper.schedule;

import com.activity.entity.event.EventInfo;
import com.activity.entity.schedule.Schedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ScheduleMapper {
    @Select("SELECT * FROM schedule WHERE schedule_acticity_id = #{activityId}")
    List<Schedule> selectAllByActivityId(@Param("activityId") Integer activityId);

    Integer insertWithInfo(@Param("schedule") Schedule schedule);
    Integer updateWithInfo(@Param("schedule") Schedule schedule);
}
