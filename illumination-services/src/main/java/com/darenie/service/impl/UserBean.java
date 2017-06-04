package com.darenie.service.impl;

import com.darenie.database.dao.RoleDao;
import com.darenie.database.dao.UserDao;
import com.darenie.database.model.Role;
import com.darenie.database.model.User;
import com.darenie.json.model.LightLampDataJson;
import com.darenie.json.model.RoleJson;
import com.darenie.json.model.UserJson;
import com.darenie.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserBean implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void save(UserJson userJson) {
        Set<RoleJson> roleSet = new HashSet<>();
        RoleJson roleUser = new RoleJson();
        roleUser.setRoleName("USER");
        roleSet.add(roleUser);
        userJson.setUsrPassword(passwordEncoder.encode(userJson.getUsrPassword()));
        User user = modelMapper.map(userJson,User.class);
        userDao.save(user);
    }

    @Override
    public UserJson findByUsrLogin(String usrLogin) {
        User user = userDao.findByUsrLogin(usrLogin);
        if (user != null) {
            return modelMapper.map(user,UserJson.class);
        }
        return null;
    }

    @Override
    public UserJson findByUsrId(Integer usrId) {
        User user = userDao.findByUsrId(usrId);
        UserJson userJson = null;
        if (user != null) {
            userJson = modelMapper.map(user,UserJson.class);
        }
        return userJson;
    }

    @Override
    public List<RoleJson> getAllRoles() {
        List<Role> roleList = roleDao.findAll();
        Type listType = new TypeToken<List<RoleJson>>() {}.getType();
        return modelMapper.map(roleList,listType);
    }

    @Override
    public List<RoleJson> getRolesByIds(List<Integer> roleIds) {
        if (roleIds != null && !roleIds.isEmpty()) {
            List<Role> roleList = roleDao.findByRoleIds(roleIds);
            Type listType = new TypeToken<List<RoleJson>>() {
            }.getType();
            return modelMapper.map(roleList, listType);
        }
        return null;
    }
}
