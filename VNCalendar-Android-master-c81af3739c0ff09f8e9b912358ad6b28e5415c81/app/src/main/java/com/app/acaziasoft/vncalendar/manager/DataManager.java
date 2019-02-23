package com.app.acaziasoft.vncalendar.manager;

import android.util.Log;

import com.app.acaziasoft.vncalendar.model.MonthModel;
import com.app.acaziasoft.vncalendar.ui.interfaces.BaseInterfaces;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by duyth on 11/30/2017.
 */

public class DataManager{
    private static ArrayList<MonthModel> models_total = new ArrayList<>();
    public static Integer index = 0;
    public static Calendar calendar_start = Calendar.getInstance();
    public static Calendar calendar_end = Calendar.getInstance();

    //calculator calendar
    public static ArrayList<MonthModel> loadDataWithIndex(Calendar calendar) {
        models_total.clear();
        //load item top
        LoadItemTop((Calendar) calendar.clone(), AppPreference.INSTANCE.RANGE_CALENDAR);

        //set index
        index = models_total.size();

        //load item bottom
        LoadItemBottom((Calendar) calendar.clone(), AppPreference.INSTANCE.RANGE_CALENDAR);
        return models_total;
    }

    public static ArrayList<MonthModel> LoadItemTop(Calendar calendar, int count) {
        ArrayList<MonthModel> monthModels = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            calendar.add(Calendar.MONTH, -1);
            monthModels.addAll(0, CalendarUtils.setMonthModel(calendar.get(Calendar.DATE),
                    calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR)));
            DataManager.calendar_start = (Calendar) calendar.clone();
        }
        addTotal(monthModels, true);
        return monthModels;
    }

    public static ArrayList<MonthModel> LoadItemBottom(Calendar calendar, int count) {
        ArrayList<MonthModel> monthModels = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            monthModels.addAll(CalendarUtils.setMonthModel(calendar.get(Calendar.DATE),
                    calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR)));
            calendar.add(Calendar.MONTH, 1);
            DataManager.calendar_end = (Calendar) calendar.clone();
        }
        addTotal(monthModels, false);
        return monthModels;
    }

    private static void addTotal(ArrayList<MonthModel> monthModels, boolean top) {
        if (top)
            models_total.addAll(0, monthModels);
        else
            models_total.addAll(monthModels);
    }
}
