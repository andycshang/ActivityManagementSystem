package com.activity.controller;

import com.activity.DTO.user.AccountDTO;
import com.activity.DTO.user.UserDTO;
import com.activity.service.user.AccountService;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import com.activity.common.result.Result;
import com.activity.common.result.ResultEnum;
import com.activity.common.result.ResultUtils;
import com.activity.entity.user.Account;
import com.activity.entity.user.User;
import com.activity.service.user.UserService;


// Controller：
// 职责：
// 1) 页面导航
// 2) 数据验证：合法性、匹配性检查
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private AccountService accountService;

    @GetMapping("/")
    public Result hello() {
        return ResultUtils.success("访问成功");
    }

    @PostMapping("/register")
    public Result register(@RequestBody AccountDTO accountDTO){
        Account account = AccountDTO.parse(accountDTO);

        // 1.数据合法性检查
        // 检查是否填入有效账户
        if( StringUtils.isBlank(account.getPhone()) && StringUtils.isBlank(account.getEmail()) ){
            return ResultUtils.error(ResultEnum.MISSING_REQUIRED_FIELD, "请填入账户手机号或邮箱");
        }
        // 检查是否输入有效密码
        if(StringUtils.isBlank(account.getPassword())){
            return ResultUtils.error(ResultEnum.MISSING_REQUIRED_FIELD, "请填入密码");
        }

        // 2.数据验证
        Account fetchedAccount = null;
        try{
            // 尝试获取账户信息
            fetchedAccount = accountService.getAccount(account, false);
        }
        catch (Exception e){
            return ResultUtils.error(ResultEnum.ALREADY_EXIST_DATA, "账户已存在");
        }

        // 3.创建账户
        try{
            account = accountService.createAccount(account);
        }
        catch (Exception e){
            return ResultUtils.error(ResultEnum.SERVER_INTERNAL_ERROR, "创建账户失败");
        }

        // 4.创建用户
        User user = null;
        try{
            user = userService.createUser(account);
        }
        catch (Exception e){
            return ResultUtils.error(ResultEnum.SERVER_INTERNAL_ERROR, "创建用户失败");
        }
        return ResultUtils.success(UserDTO.build(user));
    }

    @PostMapping("/login")
    public Result login(@RequestBody AccountDTO accountDTO){
        Account account = AccountDTO.parse(accountDTO);

        // 1.数据合法性检查
        // 检查是否填入有效账户
        if( StringUtils.isBlank(account.getPhone()) && StringUtils.isBlank(account.getEmail()) ){
            return ResultUtils.error(ResultEnum.MISSING_REQUIRED_FIELD, "请填入账户关联的手机号或邮箱");
        }
        // 检查是否填入有效密码
        if(ObjectUtils.isEmpty(account.getPassword())){
            return ResultUtils.error(ResultEnum.MISSING_REQUIRED_FIELD, "请填入账户密码");
        }

        // 2.账户信息
        Account fetchedAccount = null;
        try{
            // 尝试获取账户信息
            fetchedAccount = accountService.getAccount(account, true);
        }
        catch (Exception e){
            return ResultUtils.error(ResultEnum.NOT_EXIST_DATA, "账户不存在");
        }

        // 3.数据验证
        // 匹配密码
        if( !account.getPassword().equals(fetchedAccount.getPassword()) ){
            return ResultUtils.error(ResultEnum.MISMATCHED_DATA, "密码错误");
        }

        // 4.用户信息
        User user = null;
        try{
            // 尝试获取用户信息
            user = userService.getUserByAccount(fetchedAccount);
        }
        catch (Exception e){
            return ResultUtils.error(ResultEnum.NOT_EXIST_DATA, "用户不存在");
        }
        // 成功，返回
        return ResultUtils.success(UserDTO.build(user));
    }

    @PostMapping("/changePassword")
    public Result changePassword(@RequestBody AccountDTO accountDTO){
        Account account = AccountDTO.parse(accountDTO);
        String newPassword = accountDTO.getNewPassword();

        // 1.账户信息
        Account fetchedAccount = null;
        try{
            fetchedAccount = accountService.getAccount(account, true);
        }
        catch (Exception e){
            return ResultUtils.error(ResultEnum.NOT_EXIST_DATA, "账户不存在");
        }

        // 2.数据验证
        // 匹配密码
        if( !account.getPassword().equals(fetchedAccount.getPassword()) ){
            return ResultUtils.error(ResultEnum.MISMATCHED_DATA, "旧密码错误");
        }

        // 3.修改账户
        try{
            accountService.changePassword(fetchedAccount, newPassword);
        }
        catch (Exception e){
            return ResultUtils.error(ResultEnum.SERVER_INTERNAL_ERROR, "修改密码失败");
        }
        return ResultUtils.success("修改成功");
    }
    @PostMapping("/bind")
    public Result bind(@RequestBody User user){
        return ResultUtils.success("该功能未开放");
    }

}
