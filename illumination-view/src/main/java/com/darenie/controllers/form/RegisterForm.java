package com.darenie.controllers.form;

import com.darenie.json.model.UserJson;

import java.util.List;

public class RegisterForm {

    private UserJson user;
    private List<Integer> roleIds;

    public RegisterForm(UserJson user) {
        this.user = user;
    }

    public String getLogin() {
        return user.getUsrLogin();
    }

    public void setLogin(String login) {
        user.setUsrLogin(login);
    }

    public String getPassword() {
        return user.getUsrPassword();
    }

    public void setPassword(String password) {
        user.setUsrPassword(password);
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    public UserJson getUser() {
        return user;
    }

}
