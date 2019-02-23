package com.app.acaziasoft.vncalendar.ui.interfaces;

import com.app.acaziasoft.vncalendar.model.MonthModel;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by duyth on 12/04/2017.
 */

public class BaseInterfaces {
    public interface loadData {
        void loadData(ArrayList<MonthModel> monthModels);

        void goToIndex(ArrayList<MonthModel> monthModels);
    }

    public interface loadMoreData {
        void loadDataTop(ArrayList<MonthModel> monthModels);

        void loadDataBottom(ArrayList<MonthModel> monthModels);
    }

    public interface loadDataFestival{
        void loadDataFestivalSolar(String[] strings);
        void loadDataFestivalLunar(String[] strings);
        void loadDataDayOff(String[] strings);
    }
}
