package com.activity.service.user;

import com.activity.entity.user.Account;
import com.activity.exception.CustomException;
import com.activity.mapper.user.AccountMapper;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("AccountService")
public class AccountService {
    @Resource
    private AccountMapper accountMapper;

    // 1.只读
    // 获取账户信息
    @Transactional(readOnly = true)
    public Account getAccount(Account account, Boolean hopeExist) throws CustomException {
        // 尝试使用账户ID匹配
        if(ObjectUtils.isNotEmpty(account.getId())){
            account = accountMapper.selectById(account.getId());
        }
        // 尝试使用手机号匹配
        else if(StringUtils.isNotBlank(account.getPhone())){
            account = accountMapper.selectByPhone(account.getPhone());
        }
        // 尝试使用邮箱匹配
        else if(StringUtils.isNotBlank(account.getEmail())){
            account = accountMapper.selectByEmail(account.getEmail());
        }

        // 检查匹配结果
        Boolean isAccountEmpty = ObjectUtils.isNotEmpty(account);
        if( (isAccountEmpty && hopeExist) || (!isAccountEmpty && !hopeExist) ){
            // 异常情况：账户为空&希望存在、账户不为空&希望不存在
            throw new CustomException("不期望的结果");
        }
        return account;
    }

    // 2.读写
    // 创建账户信息
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public Account createAccount(Account account) throws CustomException{
        // 尝试新增记录
        if( accountMapper.insert(account).equals(1) ){
            return account;
        }
        throw new CustomException("创建账户异常");
    }
    // 修改密码
    @Transactional
    public Boolean changePassword(Account account, String newPassword) throws CustomException{
        // 尝试更新密码
        if( accountMapper.updatePasswordById(account.getId(), newPassword).equals(1) ){
            return true;
        }
        throw new CustomException("更新账户密码异常");
    }
    // 绑定邮箱：检查逻辑放在Controller层
    @Transactional
    public Boolean bindPhone(Account account, String phone) throws CustomException{
        // 尝试绑定邮箱
        if( accountMapper.updatePhoneById(account.getId(), phone).equals(1) ){
            return true;
        }
        throw new CustomException("更新账户手机异常");
    }
    // 绑定手机
    @Transactional
    public Boolean bindEmail(Account account, String email) throws CustomException{
        // 尝试绑定手机
        if( accountMapper.updateEmailById(account.getId(), email).equals(1) ){
            return true;
        }
        throw new CustomException("更新账户邮箱异常");
    }

}
