package com.app.acaziasoft.vncalendar.manager;

import android.content.Context;
import android.util.Log;

import com.app.acaziasoft.vncalendar.R;
import com.app.acaziasoft.vncalendar.model.MonthModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by duyth on 12/04/2017.
 */

public class CalendarUtils {
    private static ArrayList<MonthModel> monthModels;
    private static Calendar calendar;
    private static Integer dayOfWeek;
    private static int countDay;
    private static Integer[] date;
    private static boolean isFestival = false, isDayOff = false, isSelect = false, isToday = false;

    private static void initData(Integer day, Integer month, Integer year) {
        monthModels = new ArrayList<>();
        calendar = Calendar.getInstance();
        calendar.set(year, month, 1);
        dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static ArrayList<MonthModel> setMonthModel(Integer day, Integer month, Integer year) {
        initData(day, month, year);
        // add title
        for (int i = 1; i < 8; i++) {
            if (i < dayOfWeek)
                monthModels.add(new MonthModel(calendar, null, false, false, false, 0, "", false));
            else if (i == dayOfWeek)
                monthModels.add(new MonthModel(calendar, null, false, false, false, 0, AppPreference.INSTANCE.array[month], false));
            else
                monthModels.add(new MonthModel(calendar, null, false, false, false, 0, "", false));
        }
        countDay = calendar.getActualMaximum(Calendar.DATE);

        for (int i = 1; i < 8; i++) {
            if (i < dayOfWeek) {
                monthModels.add(new MonthModel(null, null, false, false, false, 0, "", false));
            } else {
                for (int j = 1; j < (countDay + 1); j++) {
                    date = LunarCalendarUtils.convert2Lunar(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));

                    checkStatusEvent();

                    monthModels.add(new MonthModel(calendar, date, isFestival, false, isToday,
                            calendar.get(Calendar.DAY_OF_WEEK), "", isDayOff));
                    calendar.add(Calendar.DATE, 1);
                }
                if (calendar.get(Calendar.DAY_OF_WEEK) > 1) {
                    for (int k = 0; k < (8 - calendar.get(Calendar.DAY_OF_WEEK)); k++) {
                        monthModels.add(new MonthModel(null, null, false, false, false, 0, "", false));
                    }
                }
                break;
            }
        }
        return monthModels;
    }

    private static void checkStatusEvent() {
        isDayOff = AppPreference.INSTANCE.dayoff.get(calendar.get(Calendar.DATE) + "/" + calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.YEAR)) != null;
        isFestival = AppPreference.INSTANCE.festivalCalendar.get(calendar.get(Calendar.DATE) + "/" + calendar.get(Calendar.MONTH)) != null
                || AppPreference.INSTANCE.festivalLunar.get(date[0] + "/" + date[1]) != null;
        isToday = calendar.get(Calendar.DATE) == AppPreference.INSTANCE.today.get(Calendar.DATE)
                && calendar.get(Calendar.MONTH) == AppPreference.INSTANCE.today.get(Calendar.MONTH)
                && calendar.get(Calendar.YEAR) == AppPreference.INSTANCE.today.get(Calendar.YEAR);
        MonthModel model = AppPreference.INSTANCE.model_select;
        isSelect = model != null && model.getCalendar().get(Calendar.DATE) == calendar.get(Calendar.DATE)
                && model.getCalendar().get(Calendar.MONTH) == calendar.get(Calendar.MONTH)
                && model.getCalendar().get(Calendar.YEAR) == calendar.get(Calendar.YEAR);
    }
}
