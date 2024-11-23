package com.activity.mapper.participant;

import com.activity.entity.participant.Applicant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ApplicantMapper {
    @Select("SELECT * FROM applicant WHERE applicant_activity_id = #{activityId};")
    List<Applicant> selectAllByActivityId(@Param("activityId") Integer activityId);
}
