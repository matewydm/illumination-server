package com.darenie.controllers.form;

import com.darenie.database.model.User;
import com.darenie.json.model.UserJson;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class RegisterForm {

    private User user;
    private List<Integer> roleIds;

    public RegisterForm(User user) {
        this.user = user;
    }

    @Size(min = 4, max = 32)
    public String getLogin() {
        return user.getUsrLogin();
    }

    public void setLogin(String login) {
        user.setUsrLogin(login);
    }

    @Size(min = 4, max = 32)
    public String getPassword() {
        return user.getUsrPassword();
    }

    public void setPassword(String password) {
        user.setUsrPassword(password);
    }

    @NotEmpty
    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    public User getUser() {
        return user;
    }

}
