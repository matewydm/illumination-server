package com.darenie.jobs;

import com.darenie.service.impl.LightLampMockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LampScheduler {

    @Autowired
    private LightLampMockBean lightLampMockBean;

//    @Scheduled(cron="0 0/1 * * * *")
    public void verifyLampStatuses() {
//        lightLampMockBean.verifyLampStatuses();
    }

}
