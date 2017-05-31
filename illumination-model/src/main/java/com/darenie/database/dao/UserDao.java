package com.darenie.database.dao;

import com.darenie.database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Long> {

    User findByUsrId(Integer userId);

    User findByUsrLogin(String username);
}
