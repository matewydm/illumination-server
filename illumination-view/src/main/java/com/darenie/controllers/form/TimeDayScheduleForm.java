package com.darenie.controllers.form;

import org.springframework.context.i18n.LocaleContextHolder;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.List;

public class TimeDayScheduleForm{

    private List<TimeLineWrapper> timeLine;
    private DayOfWeek dayOfWeek;

    public TimeDayScheduleForm(DayOfWeek day) {
        this.dayOfWeek = day;
    }

    public String getStringDay() {
        DayOfWeek dayOfWeek = getDayOfWeek();
        return dayOfWeek.getDisplayName(TextStyle.FULL, LocaleContextHolder.getLocale()).toUpperCase();
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public List<TimeLineWrapper> getTimeLine() {
        return timeLine;
    }

    public void setTimeLine(List<TimeLineWrapper> timeLine) {
        this.timeLine = timeLine;
    }
}
