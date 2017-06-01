package com.darenie.json.model;

import java.util.Date;
import java.util.List;

public class CronDataJson extends AbstractDataJson {

    private String type;
    private String cronString;
    private List<Date> turnOnTime;

    public interface Types {
        String cronType = "C";
        String simpleDate ="S";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCronString() {
        return cronString;
    }

    public void setCronString(String cronString) {
        this.cronString = cronString;

    }

    public List<Date> getTurnOnTime() {
        return turnOnTime;
    }

    public void setTurnOnTime(List<Date> turnOnTime) {
        this.turnOnTime = turnOnTime;
    }
}