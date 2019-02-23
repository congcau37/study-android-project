package com.app.acaziasoft.vncalendar;

import android.app.Application;

import com.app.acaziasoft.vncalendar.manager.AppPreference;

/**
 * Created by duyth on 12/07/2017.
 */

public class ApplicationApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppPreference.INSTANCE.init(this);
    }

}
