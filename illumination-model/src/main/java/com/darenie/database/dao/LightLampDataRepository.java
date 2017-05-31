package com.darenie.database.dao;

import com.darenie.database.model.LightLampData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightLampDataRepository extends JpaRepository<LightLampData,Long>{
}
