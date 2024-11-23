package com.activity.entity.user;

import lombok.Data;


@Data
public class AuthorityGroup {
    private Integer id;
    private String name;
    private Integer permissionLevel;


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

    public Integer getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(Integer permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    @Override
    public String toString() {
        return "AuthorityGroup{" +
                "authorityGroupId=" + id +
                ", authorityGroupName='" + name + '\'' +
                ", permissionLevel=" + permissionLevel +
                '}';
    }

}
