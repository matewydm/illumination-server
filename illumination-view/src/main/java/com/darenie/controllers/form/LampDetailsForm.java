package com.darenie.controllers.form;

import com.darenie.database.model.AddressData;
import com.darenie.database.model.LampModuleData;
import com.darenie.database.model.LightLampData;
import com.darenie.database.model.TimeLineData;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LampDetailsForm {

    private LightLampData lampData;
    private List<TimeDayScheduleForm> scheduleForms;

    public LampDetailsForm (LightLampData lampData) {
        this.lampData = lampData;

        this.scheduleForms = Arrays.stream(DayOfWeek.values())
                .map(TimeDayScheduleForm::new).collect(Collectors.toList());
        for (TimeDayScheduleForm timeDay : scheduleForms) {
            List<TimeLineData> timeDataList = lampData.getTimeLineDataForDay(timeDay.getDayOfWeek());
            List<TimeLineWrapper> timeWrapperList = new ArrayList<>();
            timeDataList.stream().forEach(t -> timeWrapperList.add(new TimeLineWrapper(t.getStartTime(),t.getEndTime())));
            timeDay.setTimeLine(timeWrapperList);
        }
    }

    public List<TimeDayScheduleForm> getScheduleForms() {
        return scheduleForms;
    }

    public Long getId() {
        return lampData.getId();
    }

    public String getName() {
        return lampData.getName();
    }

    public String getDescription() {
        return lampData.getDescription();
    }

    public AddressData getAddressData() {
        return lampData.getAddressData();
    }

    public String getStatus() {
        return lampData.getStatus();
    }

    public LampModuleData getLampModuleData() {
        return lampData.getLampModuleData();
    }

    public Integer getLampModuleNumber() {
        return lampData.getLampModuleNumber();
    }


}
