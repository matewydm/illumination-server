package com.darenie.json.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

public class RoleJson {

    private Integer roleId;
    private String roleName;
    @JsonBackReference
    private List<UserJson> users;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UserJson> getUsers() {
        return users;
    }

    public void setUsers(List<UserJson> users) {
        this.users = users;
    }
}
