package com.activity.service.activity;

import com.activity.common.enums.misc.ActivityStateEnum;
import com.activity.entity.activity.Activity;
import com.activity.entity.activity.ActivityState;
import com.activity.entity.user.User;
import com.activity.exception.CustomException;
import com.activity.mapper.activity.ActivityMapper;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
public class ActivityService {
    // 三种方法：
    // @Autowired：按类型自动装配
    // @Qualifier：按名称自动装配
    // @Resource：优先按名称装配，失败尝试按类型装配
    @Resource
    private ActivityMapper activityMapper;


    // 1.只读
    // @Transactional：保证事务的数据一致性
    @Transactional(readOnly = true)
    public List<Activity> getAll(){
        return activityMapper.selectAll();
    }
    @Transactional(readOnly = true)
    public Activity getByUUID(String UUID) throws CustomException{
        Activity activity = activityMapper.selectByUUID(UUID);
        if(ObjectUtils.isNotEmpty(activity)){
            return activity;
        }
        throw new CustomException("活动不存在");
    }
    @Transactional(readOnly = true)
    public Integer getIdByUUID(String UUID) throws CustomException{
        Integer activityId = activityMapper.selectIdByUUID(UUID);
        if( ObjectUtils.isNotEmpty(activityId) ){
            return activityId;
        }
        throw new CustomException("活动不存在");
    }

    // 2.读写
    // 1) 创建活动
    @Transactional
    public Activity createActivity(Activity activity) throws CustomException {
        // 1.获取创建时间
        // 获取当前时间
        LocalDateTime currentTime = LocalDateTime.now();
        // 将当前时间转换为 Timestamp 类型
        Timestamp timestamp = Timestamp.valueOf(currentTime);
        activity.setCreationTime(timestamp);
        activity.setLastUpdateTime(timestamp);

        // 2.生成UUID
        UUID uuid = UUID.randomUUID();
        activity.setUUID(uuid.toString());

        // 3.设置默认活动状态
        ActivityState activityState = new ActivityState();
        activityState.setId(ActivityStateEnum.PREPARING.getValue());
        activity.setState(activityState);

        // 4.设置活动管理员
        if( ObjectUtils.isEmpty(activity.getAdminUser().getId()) ){
            activity.getAdminUser().setId(1); // 如果活动管理员为空，设置为默认管理员
        }

        // 尝试创建活动
        if( activityMapper.insert(activity).equals(1) ){
            return activity;
        }
        throw new CustomException("创建活动失败");
    }
    // 2) 更改活动基本信息
    @Transactional
    public Activity changeInfo(Activity activity) throws CustomException{
        if( activityMapper.update(activity).equals(1) ){
            return activity;
        }
        throw new CustomException("更新活动信息失败");
    }

    // 3) 删除活动
    @Transactional
    public Boolean delete(Activity activity) throws CustomException{
        if( activityMapper.deleteById(activity.getId()).equals(1) ){
            return true;
        }
        throw new CustomException("删除活动失败");
    }

}
