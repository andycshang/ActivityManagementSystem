package com.activity.mapper.user;

import com.activity.entity.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE user_id = #{userId} LIMIT 1;")
    User selectById(@Param("userId") Integer userId);
    @Select("SELECT * FROM user WHERE user_account_id = #{accountId} LIMIT 1;")
    User selectByAccountId(@Param("accountId") Integer accountId);

    Integer insert(@Param("user") User user);

    Integer updateNameById(@Param("userId") Integer userId, @Param("newName") String newName );
}
