package com.activity.mapper.participant;

import com.activity.entity.participant.Applicant;
import com.activity.entity.participant.Participant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


@Mapper
public interface ParticipantMapper {
    @Select("SELECT * FROM participant WHERE participant_activity_id = #{activityId};")
    List<Participant> selectAllByActivityId(@Param("activityId") Integer activityId);

    @Update("UPDATE participant SET ")
    Integer disableById(@Param("participantId") Integer participantId);


}
