package com.darenie.database.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    private Integer usrId;
    private String usrLogin;
    private String usrPassword;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usr_id", nullable = false, unique = true)
    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    @Column(name = "usr_login", nullable = false, unique = true)
    public String getUsrLogin() {
        return usrLogin;
    }

    public void setUsrLogin(String usrLogin) {
        this.usrLogin = usrLogin;
    }

    @Column(name = "usr_password", nullable = false)
    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }
}
