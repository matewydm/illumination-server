package com.darenie.service;

import com.darenie.database.model.LightLampData;
import com.darenie.database.model.TimeLineData;
import com.darenie.json.model.LightLampDataJson;

import java.util.List;



public interface LightLampService {
    List<LightLampDataJson> getAll();
    Long updateLampLightDateWithTimeLineData(List<TimeLineData> data, Long lightId);
}
