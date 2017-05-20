package com.darenie.service.impl;

import com.darenie.database.dao.UserDao;
import com.darenie.database.model.User;
import com.darenie.json.model.UserJson;
import com.darenie.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBean implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserJson findByUsrId(Integer usrId) {
        User user = userDao.findByUsrId(usrId);
        UserJson userJson = modelMapper.map(user,UserJson.class);
        return userJson;
    }
}
