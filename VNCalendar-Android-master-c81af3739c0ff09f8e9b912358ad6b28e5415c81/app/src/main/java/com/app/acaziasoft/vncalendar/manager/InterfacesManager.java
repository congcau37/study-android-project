package com.app.acaziasoft.vncalendar.manager;

import com.app.acaziasoft.vncalendar.model.MonthModel;
import com.app.acaziasoft.vncalendar.ui.interfaces.BaseInterfaces;

import java.util.Calendar;

/**
 * Created by duyth on 12/13/2017.
 */

public class InterfacesManager {
    public interface getData {
        void getData(Calendar calendar, boolean start);
    }

    public interface getMoreData {
        void getDataTop();

        void getDataBottom();
    }

    public interface getDataFestival {
        void getDataFestival(MonthModel monthModel);
    }

}
