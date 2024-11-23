package com.activity.mapper.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.activity.entity.user.Account;


@Mapper
public interface AccountMapper {
    @Select("SELECT * FROM account WHERE account_id = #{accountId} LIMIT 1;")
    Account selectById(@Param("accountId") Integer accountId);
    @Select("SELECT * FROM account WHERE phone = #{phone} LIMIT 1;")
    Account selectByPhone(@Param("phone") String phone);
    @Select("SELECT * FROM account WHERE email = #{email} LIMIT 1;")
    Account selectByEmail(@Param("email") String email);

    Integer insert(@Param("account") Account account);

    Integer updatePasswordById(@Param("accountId") Integer accountId, @Param("newPassword") String newPassword);
    Integer updateEmailById(@Param("accountId") Integer accountId, @Param("email") String email);
    Integer updatePhoneById(@Param("accountId") Integer accountId, @Param("phone") String phone);
}
