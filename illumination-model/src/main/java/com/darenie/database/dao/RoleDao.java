package com.darenie.database.dao;

import com.darenie.database.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao extends JpaRepository<Role,Long> {

    @Query("SELECT role FROM Role role WHERE roleId in :roleIds")
    List<Role> findByRoleIds(@Param("roleIds") List<Integer> roleIds);
}
