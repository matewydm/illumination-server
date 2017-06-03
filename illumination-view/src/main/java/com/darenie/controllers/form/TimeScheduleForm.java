package com.darenie.controllers.form;

import java.time.DayOfWeek;
import java.util.Date;

public class TimeScheduleForm {

    private Date startTime;

    private Date endTime;

    private DayOfWeek day;

    public TimeScheduleForm(DayOfWeek day) {
        this.day = day;
    }

    public TimeScheduleForm() {
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }
}
