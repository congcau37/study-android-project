package com.app.acaziasoft.vncalendar.ui.interfaces;

import com.app.acaziasoft.vncalendar.model.MonthModel;

/**
 * Created by duyth on 11/30/2017.
 */

public class BaseEvent {
    public static class ShowFestival {
        public MonthModel monthModel;

        public ShowFestival(MonthModel monthModel) {
            this.monthModel = monthModel;
        }
    }
}
