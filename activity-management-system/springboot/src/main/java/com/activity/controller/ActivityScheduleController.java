package com.activity.controller;

import com.activity.DTO.enums.EnumDTO;
import com.activity.DTO.schedule.ScheduleDTO;
import com.activity.common.enums.EnumBase;
import com.activity.common.result.Result;
import com.activity.common.result.ResultUtils;
import com.activity.entity.schedule.Schedule;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/activity")
public class ActivityScheduleController {

    // 获取资源类型列表
    @GetMapping("/{uuid}/edit")
    public Result getAllResourceType(@PathVariable String uuid){
        List<EnumDTO> enumDTOList = new ArrayList<>();
        for(EnumBase enumBase : ResourceTypeEnum.values()){
            enumDTOList.add(EnumDTO.build(enumBase));
        }
        return ResultUtils.success(enumDTOList);
    }
    /**
    // 获取资源列表
    @GetMapping("/{uuid}/edit")
    public Result getAllResource(@PathVariable String uuid){

    }
    // 获取某资源的占用列表
    @GetMapping("/{uuid}/edit")
    public Result getAllReservationOfResource(@PathVariable String uuid, @RequestBody ResourceDTO resourceDTO){

    }

    // 获取日程信息
    @GetMapping("/{uuid}/edit")
    public Result getAllScheduleOfActivity(@PathVariable String uuid, @RequestBody ActivityDTO activityDTO){

    }**/

    // 编辑日程信息
    // 1) 新增
    @PostMapping("/{uuid}/edit")
    public Result addSchedule(@PathVariable String uuid, @RequestBody ScheduleDTO scheduleDTO){
        Schedule schedule = ScheduleDTO.parse(scheduleDTO);


        return ResultUtils.success(scheduleDTO.build(schedule));
    }
    // 2) 编辑
    @PostMapping("/{uuid}/edit")
    public Result editSchedule(@PathVariable String uuid, @RequestBody ScheduleDTO scheduleDTO){
        Schedule schedule = ScheduleDTO.parse(scheduleDTO);


        return ResultUtils.success(ScheduleDTO.build(schedule));
    }
    // 3) 删除
    @PostMapping("/{uuid}/edit")
    public Result deleteSchedule(@PathVariable String uuid, @RequestBody ScheduleDTO scheduleDTO){
        Schedule schedule = ScheduleDTO.parse(scheduleDTO);


        return ResultUtils.success(scheduleDTO.build(schedule));
    }

}
