package com.darenie.database.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@AttributeOverrides(value = {
        @AttributeOverride(name = "id", column = @Column(name = "cron_data_id")),
        @AttributeOverride(name = "name", column = @Column(name = "address_data_name")),
        @AttributeOverride(name = "description", column = @Column(name = "address_data_description"))
})
public class CronData extends AbstractData {

    private String type;

    private String cronString;

    private List<Date> turnOnTime;

    public interface Types {
        String cronType = "C";
        String simpleDate ="S";
    }
    @Column(length =1 )
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Column
    public String getCronString() {
        return cronString;
    }

    public void setCronString(String cronString) {
        this.cronString = cronString;

    }

    @ElementCollection
    @CollectionTable(name = "cronSimplyTimes",
    joinColumns = @JoinColumn(name = "cron_id"))
    public List<Date> getTurnOnTime() {
        return turnOnTime;
    }

    public void setTurnOnTime(List<Date> turnOnTime) {
        this.turnOnTime = turnOnTime;
    }
}
