package com.darenie.jobs;

import com.darenie.database.dao.LightLampDataRepository;
import com.darenie.database.model.LightLampData;
import com.darenie.database.model.TimeLineData;
import com.darenie.service.LightLampService;
import com.darenie.service.impl.LightLampMockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class LampDispatcher {

    @Autowired
    private LightLampService service;

    @Autowired
    private LightLampDataRepository repository;

    @Autowired
    private LightLampMockBean lampService;

    public void handleLamps(){
        List<LightLampData> lamps =repository.findAll();
        LocalTime time = LocalTime.now();
        LocalDate today = LocalDate.now();
        for (LightLampData lamp: lamps){
            List<TimeLineData> timeLines= lamp.getTimeLineDataForDay(today.getDayOfWeek());
            Boolean turnOn = false;
            for(TimeLineData timeLineData:timeLines){
                Time startTime = (Time) timeLineData.getStartTime();
                Time endTime = (Time) timeLineData.getEndTime();
                if (time.isAfter(startTime.toLocalTime()) && time.isBefore(endTime.toLocalTime())){
                    turnOn = true;
                    break;
                }
            }
            if(turnOn && !LightLampData.Status.WORKING.equals(lamp.getStatus())){
                lampService.turnOnLamp(lamp);
            }else if (!turnOn &&
                    (LightLampData.Status.NOT_WORKING.equals(lamp.getStatus()) ||
                            lamp.getStatus() == null)){
                lampService.turnOffLamp(lamp);
            }
        }
    }

}
