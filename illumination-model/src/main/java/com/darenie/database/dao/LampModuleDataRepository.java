package com.darenie.database.dao;

import com.darenie.database.model.LampModuleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LampModuleDataRepository extends JpaRepository<LampModuleData,Long>{
//    findByIsConnec

}
