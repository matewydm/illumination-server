package com.darenie.controllers.form;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class TimeScheduleForm {

//    private Date startTime;
//
//    private Date endTime;

    private List<TimeLineWrapper> timeLine;

    private DayOfWeek day;

    public TimeScheduleForm(DayOfWeek day) {
        timeLine = new ArrayList<>(1);
        TimeLineWrapper tl = new TimeLineWrapper();
        timeLine.add(tl);
        this.day = day;
    }

    public TimeScheduleForm() {
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public List<TimeLineWrapper> getTimeLine() {
        return timeLine;
    }

    public void setTimeLine(List<TimeLineWrapper> timeLine) {
        this.timeLine = timeLine;
    }
}
