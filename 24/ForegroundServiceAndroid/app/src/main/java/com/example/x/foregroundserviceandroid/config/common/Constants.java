package com.example.x.foregroundserviceandroid.config.common;

/* Created by X on 12/10/2017.
* */

public class Constants {
    public interface ACTION {
        String MAIN_ACTION = "com.example.foregroundservice.action.main";
        String PREV_ACTION = "com.example.foregroundservice.action.prev";
        String PLAY_ACTION = "com.example.foregroundservice.action.play";
        String NEXT_ACTION = "com.example.foregroundservice.action.next";
        String STARTFOREGROUND_ACTION = "com.example.foregroundservice.action.startforeground";
        String STOPFOREGROUND_ACTION = "com.example.foregroundservice.action.stopforeground";
    }

    public interface TAG {
        String LOG_START = "foregroundservice";
    }

    public interface NOTIFICATION_ID {
        int FOREGROUND_SERVICE = 101;
    }
}
