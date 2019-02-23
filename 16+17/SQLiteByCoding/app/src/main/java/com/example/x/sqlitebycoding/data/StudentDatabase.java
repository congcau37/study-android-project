package com.example.x.sqlitebycoding.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.x.sqlitebycoding.config.common.Constants;

/* Created by X on 11/30/2017.
* */

public class StudentDatabase extends SQLiteOpenHelper {
    public StudentDatabase(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "
                + Constants.TABLE_NAME
                + " ("
                + Constants.ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Constants.NAME
                + " TEXT, "
                + Constants.AGE
                + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            String query = "DROP TABLE STUDENT IF EXISTS";
            db.execSQL(query);
        }
    }
}
