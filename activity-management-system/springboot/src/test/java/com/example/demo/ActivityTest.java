package com.example.demo;

import com.activity.entity.activity.Activity;
import com.activity.entity.activity.ActivityState;
import com.activity.entity.user.Account;
import com.activity.entity.user.User;
import com.activity.mapper.activity.ActivityMapper;
import com.activity.mapper.user.AccountMapper;
import com.activity.service.user.AccountService;
import com.activity.service.user.UserService;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@MapperScan("com.activity.mapper")
@ComponentScan("com.activity.service")
public class ActivityTest {
    @Resource
    private AccountMapper accountMapper;
    @Resource
    private AccountService accountService;

    /**
    private Activity createTestActivity(){
        Activity activity = new Activity();
        // 0.设置必要信息
        activity.setTitle("test");

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

        // 3.设置默认状态
        ActivityState activityState = new ActivityState();
        activityState.setId(1);
        activity.setState(activityState);

        // 4.设置活动管理员用户
        User user = new User();
        user.setId(1);
        activity.setAdminUser(user);

        return activity;
    }
     **/

    @Test
    public void main() {
        Account account = new Account();
        account.setPhone("phone");
        account.setEmail("email");
        account.setPassword("pass");

        Integer changedLine = accountMapper.insert(account);
        if( changedLine > 0 ){
            System.out.println(account);
        }
        else{
            System.out.println("failed");
        }


        /**
        System.out.println("Test Result:");
        try {
            account = accountService.createAccount(account);
            System.out.println(account.toString());
        }
        catch (Exception e){
            System.out.println("failed");
        }**/
    }
}
