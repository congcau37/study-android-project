package com.app.acaziasoft.vncalendar.model;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by duyth on 12/02/2017.
 */

public class MonthModel {
    private Calendar calendar;
    private Integer[] calendar_lunar;
    private boolean festival;
    private boolean select;
    private boolean today;
    private Integer day_of_week;
    private String textMonth;
    private boolean dayoff;

    public MonthModel(Calendar calendar, Integer[] calendar_lunar, boolean festival, boolean select, boolean today, Integer day_of_week, String textMonth, boolean dayoff) {
        if (calendar != null) {
            this.calendar = (Calendar) calendar.clone();
        }
        this.calendar_lunar = calendar_lunar;
        this.festival = festival;
        this.select = select;
        this.today = today;
        this.day_of_week = day_of_week;
        this.textMonth = textMonth;
        this.dayoff = dayoff;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        if (calendar != null) {
            this.calendar = (Calendar) calendar.clone();
        }
    }

    public Integer[] getCalendar_lunar() {
        return calendar_lunar;
    }

    public void setCalendar_lunar(Integer[] calendar_lunar) {
        this.calendar_lunar = calendar_lunar;
    }

    public boolean isFestival() {
        return festival;
    }

    public void setFestival(boolean festival) {
        this.festival = festival;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public boolean isToday() {
        return today;
    }

    public void setToday(boolean today) {
        this.today = today;
    }

    public Integer getDay_of_week() {
        return day_of_week;
    }

    public void setDay_of_week(Integer day_of_week) {
        this.day_of_week = day_of_week;
    }

    public String getTextMonth() {
        return textMonth;
    }

    public void setTextMonth(String textMonth) {
        this.textMonth = textMonth;
    }

    public boolean isDayoff() {
        return dayoff;
    }

    public void setDayoff(boolean dayoff) {
        this.dayoff = dayoff;
    }
}
