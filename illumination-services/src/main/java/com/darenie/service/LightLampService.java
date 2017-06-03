package com.darenie.service;

import com.darenie.json.model.LightLampDataJson;

import java.util.List;

public interface LightLampService {
    List<LightLampDataJson> getAll();
}
