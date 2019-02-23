package com.example.x.sqliteassethelper.data;

/* Created by X on 12/5/2017.
* */

import android.content.Context;

import com.example.x.sqliteassethelper.config.common.Constants;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class MyDatabase extends SQLiteAssetHelper {
    
    public MyDatabase(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }
}
