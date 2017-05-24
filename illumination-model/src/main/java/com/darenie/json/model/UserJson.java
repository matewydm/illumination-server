package com.darenie.json.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

public class UserJson {

    private Integer usrId;
    private String usrLogin;
    @XmlTransient
    private String usrPassword;
    @JsonManagedReference
    private List<RoleJson> roles;

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getUsrLogin() {
        return usrLogin;
    }

    public void setUsrLogin(String usrLogin) {
        this.usrLogin = usrLogin;
    }

    public List<RoleJson> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleJson> roles) {
        this.roles = roles;
    }
}
