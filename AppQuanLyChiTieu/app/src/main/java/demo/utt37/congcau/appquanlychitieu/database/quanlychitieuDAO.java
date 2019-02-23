package demo.utt37.congcau.appquanlychitieu.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by cong on 12/29/2017.
 */

public class quanlychitieuDAO {

     static SQLiteDatabase database;
     static QuanLiChiTieuDataBase quanLiChiTieuDataBase;

    public quanlychitieuDAO (Context context){

        quanLiChiTieuDataBase = new QuanLiChiTieuDataBase(context);
    }
    public void open(){

        database = quanLiChiTieuDataBase.getWritableDatabase();
    }
    public void close(){

        quanLiChiTieuDataBase.close();
    }
    public boolean themGiaoDich(quanlychitieuDTO a){
        ContentValues contentValues = new ContentValues();
        contentValues.put(QuanLiChiTieuDataBase.NGAY,a.getNgay());
        contentValues.put(QuanLiChiTieuDataBase.SOTIEN,a.getSotien());
        contentValues.put(QuanLiChiTieuDataBase.NOIDUNG,a.getNoidung());
        contentValues.put(QuanLiChiTieuDataBase.LOAIGIAODICH,a.getLoaigiaodich());

        if(a.getLoaigiaodich()==1){

            contentValues.put(quanLiChiTieuDataBase.SODU,quanLiChiTieuDataBase.TONGSOTIEN + a.getSotien());
        }else if(a.getLoaigiaodich()==0){

            contentValues.put(quanLiChiTieuDataBase.SODU,quanLiChiTieuDataBase.TONGSOTIEN - a.getSotien());
        }
        long kiemTra = database.insert(quanLiChiTieuDataBase.TABLE_NAME,null,contentValues);
        if(kiemTra!= 0){
            return true;

        }
            return false;
    }
    public static ArrayList<quanlychitieuDTO> layDuLieu(int ngay, int thang){
        ArrayList <quanlychitieuDTO> arr = new ArrayList<quanlychitieuDTO>();
        String sql = "SELECT * FROM CHITIEU WHERE ngay = "+ngay+" AND thang= "+thang;
        Cursor cursor = database.rawQuery(sql,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            quanlychitieuDTO b = new quanlychitieuDTO();
            b.setNgay(cursor.getInt(cursor.getColumnIndex(quanLiChiTieuDataBase.NGAY)));
            b.setThang(cursor.getInt(cursor.getColumnIndex(quanLiChiTieuDataBase.THANG)));
            b.setSodu(cursor.getInt(cursor.getColumnIndex(quanLiChiTieuDataBase.SODU)));
            b.setSotien(cursor.getInt(cursor.getColumnIndex(quanLiChiTieuDataBase.SOTIEN)));
            b.setNoidung(cursor.getString(cursor.getColumnIndex(quanLiChiTieuDataBase.NOIDUNG)));
            b.setLoaigiaodich(cursor.getInt(cursor.getColumnIndex(quanLiChiTieuDataBase.LOAIGIAODICH)));
            b.setId_chitieu(cursor.getInt(cursor.getColumnIndex(quanLiChiTieuDataBase.ID_CHITIEU)));
            arr.add(b);
            cursor.moveToNext();

        }
        return arr;
    }
}
