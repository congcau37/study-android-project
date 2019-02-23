package com.app.acaziasoft.vncalendar.manager;

import android.util.Log;

import com.app.acaziasoft.vncalendar.model.MonthModel;
import com.app.acaziasoft.vncalendar.ui.interfaces.BaseInterfaces;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by duyth on 12/13/2017.
 */

public class ControlManager implements InterfacesManager.getData, InterfacesManager.getMoreData, InterfacesManager.getDataFestival {
    private BaseInterfaces.loadData loadData;
    private BaseInterfaces.loadMoreData loadMoreData;
    private BaseInterfaces.loadDataFestival loadDataFestival;

    public ControlManager(BaseInterfaces.loadData loadData, BaseInterfaces.loadMoreData loadMoreData, BaseInterfaces.loadDataFestival loadDataFestival) {
        this.loadData = loadData;
        this.loadMoreData = loadMoreData;
        this.loadDataFestival = loadDataFestival;
    }

    @Override
    public void getData(Calendar calendar, boolean start) {
        ArrayList<MonthModel> monthModels = DataManager.loadDataWithIndex(calendar);
        if (loadData != null) {
            if (start)
                loadData.loadData(monthModels);
            else
                loadData.goToIndex(monthModels);
        }
    }

    @Override
    public void getDataTop() {
        loadMoreData.loadDataTop(DataManager.LoadItemTop(DataManager.calendar_start, AppPreference.INSTANCE.RANGE_CALENDAR));
    }

    @Override
    public void getDataBottom() {
        loadMoreData.loadDataBottom(DataManager.LoadItemBottom(DataManager.calendar_end, AppPreference.INSTANCE.RANGE_CALENDAR));
    }

    @Override
    public void getDataFestival(MonthModel monthModel) {
        String[] solar = AppPreference.INSTANCE.festivalCalendar.get(monthModel.getCalendar().get(Calendar.DATE) + "/"
                + monthModel.getCalendar().get(Calendar.MONTH));
        String[] lunar = AppPreference.INSTANCE.festivalLunar.get(monthModel.getCalendar_lunar()[0]
                + "/" + monthModel.getCalendar_lunar()[1]);
        String[] dayoff = AppPreference.INSTANCE.dayoff.get(monthModel.getCalendar().get(Calendar.DATE)
                + "/" + monthModel.getCalendar().get(Calendar.MONTH) + "/" + monthModel.getCalendar().get(Calendar.YEAR));
        if (loadDataFestival != null) {
            loadDataFestival.loadDataFestivalSolar(solar);
            loadDataFestival.loadDataFestivalLunar(lunar);
            loadDataFestival.loadDataDayOff(dayoff);
        }
    }
}
