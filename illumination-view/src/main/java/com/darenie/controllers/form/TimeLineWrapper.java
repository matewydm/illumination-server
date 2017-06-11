package com.darenie.controllers.form;

import java.util.Date;

public class TimeLineWrapper {

    public TimeLineWrapper(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        remove = false;
    }

    public TimeLineWrapper() {
    }
    private Long id;
    private boolean remove;
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

    public boolean getRemove() {
        return remove;
    }

    public void setRemove(boolean toRemove) {
        this.remove = toRemove;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
