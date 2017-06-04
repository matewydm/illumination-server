package com.darenie.service;

import com.darenie.database.model.Role;
import com.darenie.database.model.User;
import com.darenie.json.model.RoleJson;
import com.darenie.json.model.UserJson;

import java.util.List;

public interface UserService {

    void save(UserJson userJson);

    UserJson findByUsrLogin(String usrLogin);

    UserJson findByUsrId(Integer usrId);

    List<RoleJson> getAllRoles();

    List<RoleJson> getRolesByIds(List<Integer> roleIds);

}
