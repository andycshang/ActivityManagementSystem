package com.activity.mapper.activity;

import com.activity.entity.activity.Activity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ActivityMapper {
    // 1.新增
    // 动态SQL：在Activity.xml中
    Integer insert(Activity activity);

    // 2.更改
    // 动态SQL
    Integer update(Activity activity);

    // 3.删除
    // 注解方法定义
    @Delete("DELETE FROM activity WHERE activity_id = #{activityId}")
    Integer deleteById(Integer activityId);

    // 4.查找
    // 1) 无条件匹配
    @Select("SELECT * FROM activity")
    List<Activity> selectAll();
    // 2) 关键属性匹配
    @Select("SELECT * FROM activity WHERE activity_admin_user_id = #{adminUserId}")
    List<Activity> selectAllByAdminUser(@Param("adminUserId") Integer adminUserId);
    @Select("SELECT * FROM activity WHERE activity_title LIKE CONCAT('%', #{title}, '%')")
    List<Activity> matchAllByTitle(@Param("title") String title);
    // 3) 精确匹配
    @Select("SELECT * FROM activity WHERE activity_uuid = #{UUID} limit 1")
    Activity selectByUUID(@Param("UUID") String UUID);

    Integer updateActivityStateById(Integer id);

    Integer updateActivityVisibilityById(Integer id);

    Integer selectIdByUUID(String uuid);
}
