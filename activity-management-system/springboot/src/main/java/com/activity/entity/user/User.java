package com.activity.entity.user;

import lombok.Data;


@Data
public class User {
    private Integer id;
    private String name;

    private AuthorityGroup authorityGroup;
    private Account account;


    // get set
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthorityGroup getAuthorityGroup() {
        return authorityGroup;
    }

    public void setAuthorityGroup(AuthorityGroup authorityGroup) {
        this.authorityGroup = authorityGroup;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    // to_string
    @Override
    public String toString() {
        return "User{" +
                "userId=" + id +
                ", userName='" + name + '\'' +
                ", authorityGroup=" + authorityGroup +
                ", account=" + account +
                '}';
    }

}
