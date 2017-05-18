package com.darenie.service.impl;

import com.darenie.dao.api.UserDao;
import com.darenie.model.db.User;
import com.darenie.model.json.UserJson;
import com.darenie.service.api.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

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
