package com.darenie.database.dao;

import com.darenie.database.model.LightLampData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LightLampDataRepository extends JpaRepository<LightLampData,Long>{

    @Query("SELECT lamp from LightLampData lamp INNER JOIN lamp.lampModuleData AS module" +
            " WHERE lamp.lampModuleNumber = :lampModuleNumber " +
            " AND module.id = :moduleId")
    LightLampData findByNumberAndModule(@Param("lampModuleNumber") Integer lampModuleNumber,
                                        @Param("moduleId") Long moduleId);

    LightLampData findByName(String name);
}
