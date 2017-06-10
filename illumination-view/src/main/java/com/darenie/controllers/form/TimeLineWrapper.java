package com.darenie.controllers.form;

import java.util.Date;

public class TimeLineWrapper {

    public TimeLineWrapper(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TimeLineWrapper() {
    }

    private Date startTime;
    private Date endTime;

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
}
