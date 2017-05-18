package com.darenie.service.api;

import com.darenie.model.json.UserJson;

public interface UserService {

    UserJson findByUsrId(Integer usrId);

}
