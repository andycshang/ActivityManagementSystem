package com.activity.controller;

import com.activity.DTO.activity.ActivityDTO;
import com.activity.DTO.enums.EnumDTO;
import com.activity.common.enums.EnumBase;
import com.activity.common.result.Result;
import com.activity.common.result.ResultEnum;
import com.activity.common.result.ResultUtils;
import com.activity.entity.activity.Activity;
import com.activity.service.activity.ActivityService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/activity")
public class ActivityInfoController {

    @Resource
    private ActivityService activityService;

    // 1.获取信息
    // 获取资源类型列表
    @GetMapping("/edit/{uuid}")
    public Result getAllResourceType(@PathVariable String uuid){
        List<EnumDTO> enumDTOList = new ArrayList<>();
        for(EnumBase enumBase : ResourceTypeEnum.values()){
            enumDTOList.add(EnumDTO.build(enumBase));
        }
        return ResultUtils.success(enumDTOList);
    }

    // 显示所有活动
    @GetMapping("/hall")
    public Result showAll() {
        List<Activity> activityList = activityService.getAll();
        List<ActivityDTO> activityDTOList = new ArrayList<>();
        for (Activity activity:activityList) {
            activityDTOList.add(ActivityDTO.build(activity));
        }
        return ResultUtils.success(activityDTOList);
    }
    @GetMapping("/{uuid}")
    public Result get(@PathVariable String uuid){
        Activity activity = null;
        try{
            activity = activityService.getByUUID(uuid);
        }
        catch (Exception e){
            return ResultUtils.error(ResultEnum.NOT_EXIST_DATA, "活动不存在");
        }
        return ResultUtils.success(ActivityDTO.build(activity));
    }

    // 2.提交信息
    // 1) 创建
    @PostMapping("/create")
    public Result create(@RequestBody ActivityDTO activityDTO){
        Activity activity = ActivityDTO.parse(activityDTO);


        return ResultUtils.success(ActivityDTO.build(activity));
    }
    // 2) 删除
    @PostMapping("/edit/{uuid}")
    public Result delete(@PathVariable String uuid){
        // 匹配活动ID
        Activity activity = null;
        try{
            activity = activityService.getByUUID(uuid);
        }
        catch (Exception e){
            return ResultUtils.error(ResultEnum.NOT_EXIST_DATA, "活动不存在");
        }
        // 检查用户权限
        if( !activity.getAdminUser().getId().equals() )

        return ResultUtils.success(ActivityDTO.build(activity));
    }
    // 3) 编辑
    // 编辑信息
    @PostMapping("/{uuid}/edit/")
    public Result editInfo(@PathVariable String uuid, @RequestBody ActivityDTO activityDTO){
        Activity activity = ActivityDTO.parse(activityDTO);


        return ResultUtils.success(ActivityDTO.build(activity));
    }

    // 编辑成员
    @PostMapping("/{uuid}/edit/participant")
    public Result editParticipant(@PathVariable String uuid, @RequestBody ActivityDTO activityDTO){
        Activity activity = ActivityDTO.parse(activityDTO);


        return ResultUtils.success(ActivityDTO.build(activity));
    }
    // 编辑申请人
    @PostMapping("/{uuid}/edit/applicant")
    public Result editApplicant(@PathVariable String uuid, @RequestBody ActivityDTO activityDTO){
        Activity activity = ActivityDTO.parse(activityDTO);


        return ResultUtils.success(ActivityDTO.build(activity));
    }

}
