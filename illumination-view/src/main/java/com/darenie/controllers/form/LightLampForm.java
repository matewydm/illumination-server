package com.darenie.controllers.form;

import com.darenie.database.model.LightLampData;
import com.darenie.database.model.TimeLineData;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class LightLampForm {

    private LightLampData lamp;
    private List<TimeScheduleForm> times;
    public LightLampForm(LightLampData lamp) {
        this.lamp = lamp;

        times =Arrays.stream(DayOfWeek.values()).map(TimeScheduleForm::new).collect(Collectors.toList());
        for(TimeScheduleForm tl : times){
            List<TimeLineData> b = lamp.getTimeLineDataForDay(tl.getDay());
            List<TimeLineWrapper> listWrapper = new ArrayList<>();
           for(TimeLineData c: b){
               TimeLineWrapper wrapper = new TimeLineWrapper();
               wrapper.setStartTime(c.getStartTime());
               wrapper.setEndTime(c.getEndTime());
               listWrapper.add(wrapper);
           }
           if(listWrapper.size() !=0)
            tl.setTimeLine(listWrapper);
        }
//        for(TimeLineData tl: lamp.getTimeLineData()){
//            TimeScheduleForm a = times.get(tl.getDayOfWeek() - 1);
//
//            a.setTimeLine();
//        }
    }


    public Long getId() {
        return lamp.getId();
    }

    @NotNull
    @Size(min = 1)
    public String getName() {
        return lamp.getName();
    }

    public void setName(String name) {
        lamp.setName(name);
    }

    public String getStatus() {
        return lamp.getStatus();
    }

    public List<TimeScheduleForm> getTimes() {
        return times;
    }

    public void setTimes(List<TimeScheduleForm> times) {
        this.times = times;
    }
}
