package com.darenie.service.impl;

import com.darenie.database.dao.LightLampDataRepository;
import com.darenie.database.model.LightLampData;
import com.darenie.service.LightLampService;
import com.darenie.json.model.LightLampDataJson;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class LightLampServiceImpl implements LightLampService {

    @Autowired
    private LightLampDataRepository lightLampDataDao;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<LightLampDataJson> getAll() {
        List<LightLampData> lightLampDataList = lightLampDataDao.findAll();
        Type listType = new TypeToken<List<LightLampDataJson>>() {}.getType();
        return modelMapper.map(lightLampDataList,listType);
    }
}
