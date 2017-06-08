package com.darenie.service.impl;

import com.darenie.database.dao.LightLampDataRepository;
import com.darenie.database.model.LampModuleData;
import com.darenie.database.model.LightLampData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class LightLampMockBean {

    @Autowired
    private LightLampDataRepository lightLampDataRepository;

    private static final String HTTP = "http://";
    private static final String REST_PATH = "/lamp/";
    private static final String USER = "user";
    private static final String PASSWORD = "user";

    public void verifyLampStatuses() {
        List<LightLampData> lampDataList = lightLampDataRepository.findAll();

        lampDataList.stream()
                .filter(this::hasLampStatusChanged)
                .forEach(lampData -> lightLampDataRepository.save(lampData));
    }

    public boolean hasLampStatusChanged(LightLampData lampData) {
        final String STATUS = "status";
        RestTemplate restTemplate = initRestTemplate();
        String url = buildUrl(lampData, STATUS);
        String pulledStatus = restTemplate.getForObject(url, String.class);
        if (!pulledStatus.equals(lampData.getStatus())) {
            lampData.setStatus(pulledStatus);
            return true;
        }
        return false;
    }

    public void setLampStatus(LightLampData lampData) {
        RestTemplate restTemplate = initRestTemplate();
        String url = buildUrl(lampData, lampData.getStatus());
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity(url, lampData.getStatus(), Void.class);
        if (responseEntity.getStatusCodeValue() == 200) {
            lightLampDataRepository.save(lampData);
        } else {
            throw new IllegalStateException("Cannot process lightLamp setting");
        }
    }

    private RestTemplate initRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(USER, PASSWORD));
        return restTemplate;
    }

    private String buildUrl(LightLampData lampData, String context)  {
        LampModuleData moduleData = lampData.getLampModuleData();
        if (moduleData == null) {
            throw new IllegalStateException("Lamp is not connected to any module");
        }
        return HTTP + moduleData.getIpAddress() + ":"
                + moduleData.getPort() + REST_PATH + context + "/"
                + lampData.getLampModuleNumber();
    }

}
