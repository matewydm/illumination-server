package com.darenie.service;

import com.darenie.json.model.UserJson;

public interface UserService {

    UserJson findByUsrId(Integer usrId);

}
