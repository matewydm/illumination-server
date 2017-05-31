package com.darenie.service;

import com.darenie.database.model.User;
import com.darenie.json.model.UserJson;

public interface UserService {

    void save(UserJson userJson);

    UserJson findByUsrLogin(String usrLogin);

    UserJson findByUsrId(Integer usrId);

}
