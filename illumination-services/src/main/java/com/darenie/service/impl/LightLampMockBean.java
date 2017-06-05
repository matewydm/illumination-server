package com.darenie.service.impl;

import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LightLampMockBean {

    public void getLampStatus() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("user", "user"));
        Object object = restTemplate.getForObject("http://localhost:8081/lamp/status/1", Object.class);
    }

}
