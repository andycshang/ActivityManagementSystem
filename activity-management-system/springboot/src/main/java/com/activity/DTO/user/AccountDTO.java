package com.activity.DTO.user;

import com.activity.entity.user.Account;
import lombok.Data;


@Data
public class AccountDTO {
    private String phone;
    private String email;
    private String password;
    private String newPassword;


    public static Account parse(AccountDTO accountDTO){
        Account account = new Account();
        account.setPhone(accountDTO.getPhone());
        account.setEmail(accountDTO.getEmail());
        account.setPassword(accountDTO.getPassword());
        return account;
    }

}
