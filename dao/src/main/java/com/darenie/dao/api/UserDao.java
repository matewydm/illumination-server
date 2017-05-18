package com.darenie.dao.api;

import com.darenie.model.db.User;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface UserDao extends Repository<User,Long> {

    User findByUsrId(Integer userId);

}
