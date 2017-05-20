package com.darenie.database.dao;

import com.darenie.database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface UserDao extends JpaRepository<User,Long> {

    User findByUsrId(Integer userId);

}
