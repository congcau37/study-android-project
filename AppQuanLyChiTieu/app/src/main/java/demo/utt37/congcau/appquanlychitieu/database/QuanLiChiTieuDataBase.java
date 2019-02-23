package demo.utt37.congcau.appquanlychitieu.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cong on 12/29/2017.
 */

public class QuanLiChiTieuDataBase extends SQLiteOpenHelper {

    public static final String DB_NAME ="QuanLyChiTieu";
    public static final int DB_VERSION =1;
    public static final int TONGSOTIEN =0;
    public static final String TABLE_NAME ="CHITIEU";
    public static final String ID_CHITIEU ="id_chitieu";
    public static final String NGAY ="ngay";
    public static final String THANG ="thang";
    public static final String SODU ="sodu";
    public static final String SOTIEN ="sotien";
    public static final String LOAIGIAODICH ="loaigiaodich";
    public static final String NOIDUNG ="noidung";


    public QuanLiChiTieuDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE CHITIEU(id_chitieu INTEGER PRIMARY KEY AUTOINCREMENT,ngay INTEGER,thang INTEGER,sotien INTEGER,sodu INTEGER,noidung TEXT,loaigiaodich INTEGER);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
