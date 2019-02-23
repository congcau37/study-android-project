package com.example.x.sqliteassethelper.data;

/* Created by X on 12/5/2017.
* */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.x.sqliteassethelper.config.common.Constants;
import com.example.x.sqliteassethelper.model.StudentModel;

import java.util.ArrayList;

public class StudentDao {
    private MyDatabase database;
    private SQLiteDatabase db;

    public StudentDao(Context context) {
        database = new MyDatabase(context);
    }

    public void open() {
        db = database.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public long addNewStudent(StudentModel newStudent) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.NAME, newStudent.getName());
        contentValues.put(Constants.AGE, newStudent.getAge());
        return db.insert(Constants.TABLE_NAME, null, contentValues);
    }

    public ArrayList<StudentModel> getStudentList() {
        ArrayList<StudentModel> data = new ArrayList<>();
        String query = "SELECT * FROM " + Constants.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data.add(
                    new StudentModel(
                            cursor.getInt(cursor.getColumnIndex(Constants.ID)),
                            cursor.getString(cursor.getColumnIndex(Constants.NAME)),
                            cursor.getInt(cursor.getColumnIndex(Constants.AGE))
                    )
            );
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    public boolean deleteStudent(int id) {
        try {
            String query = "DELETE FROM " + Constants.TABLE_NAME + " WHERE " + Constants.ID + " = " + id;
            db.execSQL(query);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateStudent(StudentModel newStudent) {
        try {
            String query = "UPDATE "
                    + Constants.TABLE_NAME
                    + " SET "
                    + Constants.NAME
                    + " = '"
                    + newStudent.getName()
                    + "', "
                    + Constants.AGE
                    + " = "
                    + newStudent.getAge()
                    + " WHERE "
                    + Constants.ID
                    + " = "
                    + newStudent.getId();
            db.execSQL(query);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
