package com.darenie.rest.service.api;

import com.darenie.json.model.UserJson;

public interface UserService {

    UserJson findByUsrId(Integer usrId);

}
