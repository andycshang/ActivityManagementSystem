package com.activity.service.schedule;

import com.activity.entity.activity.Activity;
import com.activity.entity.event.EventInfo;
import com.activity.entity.schedule.Schedule;
import com.activity.exception.CustomException;
import com.activity.mapper.schedule.ScheduleMapper;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("ScheduleService")
public class ScheduleService {
    @Resource
    private ScheduleMapper scheduleMapper;

    public List<Schedule> getAllOfActivity(Activity activity) throws CustomException {
        if( ObjectUtils.isEmpty(activity.getId()) ){
            throw new CustomException("");
        }
        return scheduleMapper.selectAllByActivityId(activity.getId());
    }

    /**
    public createOfActivity(Schedule schedule){

        EventInfo eventInfo = schedule.getInfo();
    }
**/
}
