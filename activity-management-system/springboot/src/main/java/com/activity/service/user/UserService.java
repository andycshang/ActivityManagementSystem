package com.activity.service.user;

import com.activity.common.enums.misc.AuthorityGroupEnum;
import com.activity.entity.user.Account;
import com.activity.entity.user.AuthorityGroup;
import com.activity.entity.user.User;
import com.activity.exception.CustomException;
import com.activity.mapper.user.AccountMapper;
import com.activity.mapper.user.UserMapper;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;


// Service：
// 职责：
// 1) 数据处理：补充对象信息
// 2) 事务管理（事务：一系列操作的集合；要么全部成功执行，要么全部失败回滚）
@Service("UserService")
public class UserService {
    @Resource
    private AccountMapper accountMapper;
    @Resource
    private UserMapper userMapper;

    // 1.只读
    // 获取用户信息
    @Transactional(readOnly = true)
    public User getUserByAccount(Account account) throws CustomException{
        User user = userMapper.selectByAccountId(account.getId());
        if( ObjectUtils.isNotEmpty(user) ){
            return user;
        }
        throw new CustomException("获取用户失败");
    }

    // 2.读写
    // 创建用户并返回
    @Transactional
    public User createUser(Account account) throws CustomException {
        // 1.创建对象
        User user = new User();
        // 设置用户名
        user.setName(getRandomUsername());
        // 设置用户权限组：默认普通用户
        AuthorityGroup authorityGroup = new AuthorityGroup();
        authorityGroup.setId(AuthorityGroupEnum.NORMAL_USER.getValue());
        user.setAuthorityGroup(authorityGroup);
        // 绑定账户
        user.setAccount(account);
        // 2.新增数据
        // 尝试新增记录
        if( userMapper.insert(user).equals(1) ){
            return user;
        }
        throw new CustomException("创建用户异常");
    }
    @Transactional
    public User changeName(User user, String newName) throws CustomException{
        if( userMapper.updateNameById(user.getId(), newName).equals(1) ){
            return user;
        }
        throw new CustomException("更改用户名失败");
    }

    // 固定用户名前缀
    private static final String PREFIX = "user_";
    // 固定用户名长度
    private static final int suffixLength = 8;
    // 生成随机用户名的方法
    private static String getRandomUsername() {
        // 可以包含的字符集合
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        // 创建一个 Random 对象
        Random random = new Random();

        // 字符串
        StringBuilder username = new StringBuilder();
        // 添加固定前缀
        username.append(PREFIX);
        // 生成随机字符，直到达到指定的长度
        for (int i = 0; i < suffixLength; i++) {
            // 从字符集合中随机选择一个字符
            char randomChar = characters.charAt(random.nextInt(characters.length()));
            // 将随机字符添加到用户名中
            username.append(randomChar);
        }

        // 返回生成的随机用户名
        return username.toString();
    }

}
