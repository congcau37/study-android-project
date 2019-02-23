package demo.utt37.congcau.sqllite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cong on 12/8/2017.
 */

public class Database extends SQLiteOpenHelper {
    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    // truy van khong co du lieu tra ve

   public void QueryDatabade(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);

   }
   // truy van co du lieu tra ve
    public SQLiteDatabase GetDatabase(String sql){
       SQLiteDatabase database = getReadableDatabase();
       database.rawQuery(sql,null);
       return database;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
